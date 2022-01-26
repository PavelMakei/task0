package by.makei.array.service.impl;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.CustomException;
import by.makei.array.service.CustomUtil;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomUtilImpl implements CustomUtil {

    private static final Logger logger = LogManager.getLogger();
    private static final CustomUtilImpl instance = new CustomUtilImpl();

    private CustomUtilImpl() {
    }

    public static CustomUtilImpl getInstance() {
        return instance;
    }

    @Override
    public void replace(CustomArray customArray, int index, int value) throws CustomException {
        int[] array = customArray.getIntArray();
        array[index] = value;
        try {
            customArray.setIntArray(array);
            logger.log(Level.INFO, "Value on index " + index + "was replaced with " + value);
        } catch (CustomException e) {
            logger.log(Level.ERROR,"Method wasn't implemented");
            throw new CustomException("Method wasn't implemented", e);
        }
    }

    @Override
    public void replaceStream(CustomArray customArray, int index, int value) throws CustomException {
        int[] array = customArray.getIntArray();
        List <Integer>listFromArray = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            listFromArray.add(array[i]);
        }
        List<Integer> val = new ArrayList();
        val.add(value);
        List<Integer> resultList;
        resultList = Stream.concat(
                Stream.concat(
                        listFromArray.stream().limit(index), val.stream()),
                listFromArray.stream().skip(index + 1)
        ).collect(Collectors.toList());
        int[] resultArray = resultList.stream().mapToInt(i -> i).toArray();
        try {
            customArray.setIntArray(resultArray);
            logger.log(Level.INFO, "Value on index " + index + "was replaced with " + value);
        } catch (CustomException e) {
            logger.log(Level.ERROR, "Method wasn't implemented", e);
            throw new CustomException("Method wasn't implemented", e);
        }
    }

    @Override
    public void replaceAll(CustomArray customArray, int find, int valueToReplace) throws CustomException {
        int[] array = customArray.getIntArray();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == find) {
                array[i] = valueToReplace;
                count++;
            }
        }
        try {
            customArray.setIntArray(array);
            logger.log(Level.INFO, count + "%d elements were replaced");
        } catch (CustomException e) {
            logger.error("Method wasn't implemented", e);
            throw new CustomException("Method wasn't implemented", e);
        }
    }

    @Override
    public void replaceAllStream(CustomArray customArray, int find, int valueToReplace) throws CustomException {
        int[] array = customArray.getIntArray();
        int[] resultArray = Arrays.stream(array).map(val -> val == find ? valueToReplace : val).toArray();
        try {
            customArray.setIntArray(array);
            logger.log(Level.INFO, "Elements were replaced");
        } catch (CustomException e) {
            logger.error("Method wasn't implemented", e);
            throw new CustomException("Method wasn't implemented", e);
        }
    }
}
