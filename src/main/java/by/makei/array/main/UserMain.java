package by.makei.array.main;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.IncorrectCustomArrayInsertException;
import by.makei.array.exception.IncorrectCustomArrayException;
import by.makei.array.parser.impl.CustomArrayParserImpl;
import by.makei.array.reader.impl.CustomFileReaderImpl;
import by.makei.array.service.CustomMath;
import by.makei.array.service.CustomSort;
import by.makei.array.service.CustomUtil;
import by.makei.array.service.impl.CustomMathImpl;
import by.makei.array.service.impl.CustomSortImpl;
import by.makei.array.service.impl.CustomUtilImpl;
import by.makei.array.validator.FileValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public class UserMain {
    public static final Logger logger = LogManager.getLogger(UserMain.class);
    private static final CustomMath customMath = CustomMathImpl.getInstance();
    CustomFileReaderImpl customFileReaderImpl = new CustomFileReaderImpl();
    CustomArrayParserImpl customArrayParserImpl = CustomArrayParserImpl.getInstance();
    CustomSort customSort = CustomSortImpl.getInstance();
    CustomUtil customUtil = CustomUtilImpl.getInstance();
    List<String> lines = new ArrayList<>();
    List<CustomArray> customArrays = new ArrayList<>();
    String fileName = "datafile/incomeData.txt";

    public static void main(String[] args) throws IncorrectCustomArrayInsertException, IncorrectCustomArrayException {
        UserMain userMain = new UserMain();
        userMain.run();
    }

    public void run() throws IncorrectCustomArrayInsertException, IncorrectCustomArrayException {

        FileValidator fileValidator = new FileValidator();
        System.out.println(fileValidator.validateFile(fileName));


//        try {
//            lines = customFileReaderImpl.readLinesFromFile(fileName);
//            logger.log(Level.INFO, "File was successfully loaded. It has {} valid lines.", lines.size());
//
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
//        for (String line : lines) {
//            customArrays.add(new CustomArray(customArrayParserImpl.convert(line)));
//            logger.log(Level.INFO, "New CustomArray was created and added to the customArrays list");
//        }
//        for (CustomArray customArray : customArrays) {
//            int max = customMath.findMax(customArray);
//            logger.log(Level.INFO, "The max value in array {} = {} ",customArray.toString(), + max);
//
//        }
//        for (CustomArray customArray : customArrays) {
//            int min = customMath.findMinStream(customArray);
//            logger.log(Level.INFO, "The min value in array {} = {}" , customArray.toString(), min);
//        }
//        for (CustomArray customArray : customArrays) {
//            double average = customMath.findAverageStream(customArray);
//            logger.log(Level.INFO, "The average value in array {} = {} ", customArray.toString(), average);
//        }
////
//        customUtil.replaceStream(customArrays.get(0),0,888);
//        customSort.bubbleSort(customArrays.get(0));
//        System.out.println(customArrays.get(0).toString());

    }
}
