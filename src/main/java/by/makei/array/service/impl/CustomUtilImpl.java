package by.makei.array.service.impl;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.CustomArrayException;
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
    public boolean replace(CustomArray customArray, int index, int value) throws CustomArrayException {
        if (validate(customArray)) {
            int[] array = customArray.getIntArray();
            try {
                array[index] = value;
            }catch (ArrayIndexOutOfBoundsException e){
                logger.log(Level.ERROR, "Value on index {} more then array length {} ", index, array.length-1);
                return false;
            }
            logger.log(Level.INFO, "Value on index {} was replaced with {} ", index, value);
            return customArray.setIntArray(array);
        }
        return false;
    }

    @Override
    public boolean replaceStream(CustomArray customArray, int index, int value) throws CustomArrayException {
        if (validate(customArray)) {
            int[] array = customArray.getIntArray();
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
            logger.log(Level.INFO, "Value on index {} was replaced with {}", index, value);
            return customArray.setIntArray(resultArray);
        }
        return false;
    }

    //TODO check if no one element was replaced?
    @Override
    public boolean replaceAll(CustomArray customArray, int find, int valueToReplace) throws CustomArrayException {
        if (validate(customArray)) {
            int[] array = customArray.getIntArray();
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == find) {
                    array[i] = valueToReplace;
                    count++;
                }
            }
            logger.log(Level.INFO, "{} elements were replaced", count);
            return customArray.setIntArray(array);
        }
        return false;
    }
    //TODO check if no one element was replaced?
    @Override
    public boolean replaceAllStream(CustomArray customArray, int find, int valueToReplace) throws CustomArrayException {
        if (validate(customArray)) {
            int[] array = customArray.getIntArray();
            int[] resultArray = Arrays.stream(array).map(val -> val == find ? valueToReplace : val).toArray();
            logger.log(Level.INFO, "Elements were replaced");
            return customArray.setIntArray(resultArray);
        }
        return false;
    }

    private boolean validate(CustomArray customArray) throws CustomArrayException {
        if (customArray != null) {
            if (customArray.getIntArray() != null && customArray.getIntArray().length > 0) {
                return true;
            }
        }
        //logger.log(Level.ERROR, "Incorrect CustomArray (is null or array is null or length <1");
        throw new CustomArrayException("Incorrect CustomArray (is null or array is null or length <1");
    }

}
