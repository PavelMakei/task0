package by.makei.array.service.impl;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.IncorrectCustomArrayInsertException;
import by.makei.array.exception.IncorrectCustomArrayException;
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
    public void replace(CustomArray customArray, int index, int value) throws IncorrectCustomArrayException {
        if (validate(customArray)) {
            int[] array = customArray.getCustomIntArray();
            array[index] = value;
            try {
                customArray.setIntArray(array);
                logger.log(Level.INFO, "Value on index {} was replaced with {} ",  index ,  value);
            } catch (IncorrectCustomArrayInsertException e) {
                logger.log(Level.WARN, "Exception can't be thrown");
            }
        }
    }

    @Override
    public void replaceStream(CustomArray customArray, int index, int value) throws IncorrectCustomArrayException {
        if (validate(customArray)) {
            int[] array = customArray.getCustomIntArray();
            List<Integer> listFromArray = new ArrayList<>();
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
                logger.log(Level.INFO, "Value on index {} was replaced with {}", index, value);
            } catch (IncorrectCustomArrayInsertException e) {
                logger.log(Level.WARN, "Exception can't be thrown", e);

            }
        }
    }

    @Override
    public void replaceAll(CustomArray customArray, int find, int valueToReplace) throws IncorrectCustomArrayException {
        if (validate(customArray)) {
            int[] array = customArray.getCustomIntArray();
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == find) {
                    array[i] = valueToReplace;
                    count++;
                }
            }
            try {
                customArray.setIntArray(array);
                logger.log(Level.INFO, "{} elements were replaced", count);
            } catch (IncorrectCustomArrayInsertException e) {
                logger.error("Exception can't be thrown");
            }
        }
    }

    @Override
    public void replaceAllStream(CustomArray customArray, int find, int valueToReplace) throws IncorrectCustomArrayException {
        if (validate(customArray)) {
            int[] array = customArray.getCustomIntArray();
            int[] resultArray = Arrays.stream(array).map(val -> val == find ? valueToReplace : val).toArray();
            try {
                customArray.setIntArray(resultArray);
                logger.log(Level.INFO, "Elements were replaced");
            } catch (IncorrectCustomArrayInsertException e) {
                logger.log(Level.WARN, "Exception can't be thrown");
            }
        }
    }

    private boolean validate(CustomArray customArray) throws IncorrectCustomArrayException {
        if (customArray != null) {
            if (customArray.getCustomIntArray() != null && customArray.getCustomIntArray().length > 0) {
                return true;
            }
        }
        //logger.log(Level.ERROR, "Incorrect CustomArray (is null or array is null or length <1");
        throw new IncorrectCustomArrayException("Incorrect CustomArray (is null or array is null or length <1");
    }

}
