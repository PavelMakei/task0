package by.makei.array.main;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.CustomException;
import by.makei.array.parser.impl.CustomArrayParser;
import by.makei.array.reader.CustomFileReader;
import by.makei.array.service.CustomMath;
import by.makei.array.service.CustomSort;
import by.makei.array.service.CustomUtil;
import by.makei.array.service.impl.CustomMathImpl;
import by.makei.array.service.impl.CustomSortImpl;
import by.makei.array.service.impl.CustomUtilImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;


public class UserMain {
    public static Logger logger = LogManager.getLogger(UserMain.class);
    private static final CustomMath customMath = CustomMathImpl.getInstance();
    CustomFileReader customFileReader = CustomFileReader.getInstance();
    CustomArrayParser customArrayParser = CustomArrayParser.getInstance();
    CustomSort customSort = CustomSortImpl.getInstance();
    CustomUtil customUtil = CustomUtilImpl.getInstance();
    List<String> lines = new ArrayList<>();
    List<CustomArray> customArrays = new ArrayList<>();
    String fileName = "src/main/resources/datafile/incomeData.txt";

    public static void main(String[] args) throws CustomException {
        UserMain userMain = new UserMain();
        userMain.run();
    }

    public void run() throws CustomException {
        try {
            lines = customFileReader.readLinesFromFile(fileName);
            logger.log(Level.INFO, "File was successfully loaded. It has " + lines.size() + " valid lines.");
        } catch (CustomException e) {
            logger.error("File wasn't read. Check if it exists", e);
        }
        for (String line : lines) {
            customArrays.add(new CustomArray(customArrayParser.convert(line)));
            logger.log(Level.INFO, "New CustomArray was created and added to the customArrays list");
        }
        for (CustomArray customArray : customArrays) {
            int max = customMath.findMax(customArray);
            logger.log(Level.INFO, "The max value in array "
                    + customArray.toString()
                    + " = "
                    + max);
        }
        for (CustomArray customArray : customArrays) {
            int min = customMath.findMinStream(customArray);
            logger.log(Level.INFO, "The min value in array "
                    + customArray.toString()
                    + " = "
                    + min);
        }
        for (CustomArray customArray : customArrays) {
            double average = customMath.findAverageStream(customArray);
            logger.log(Level.INFO, "The average value in array "
                    + customArray.toString()
                    + " = "
                    + average);
        }

        customUtil.replaceStream(customArrays.get(0),0,888);
        customSort.bubbleSort(customArrays.get(0));
        System.out.println(customArrays.get(0).toString());

    }
}
