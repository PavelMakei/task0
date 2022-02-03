package by.makei.array.service.impl;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.CustomArrayException;
import by.makei.array.service.CustomSort;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.IntStream;

public class CustomSortImpl implements CustomSort {
    private static final Logger logger = LogManager.getLogger();
    private static final CustomSortImpl instance = new CustomSortImpl();

    private CustomSortImpl() {
    }

    public static CustomSortImpl getInstance() {
        return instance;
    }

    @Override
    public boolean bubbleSort(CustomArray customArray) throws CustomArrayException {
        if (validate(customArray)) {
            int[] array = customArray.getIntArray();
            int buffer = 0;
            for (var i = 1; i < array.length; i++) {
                for (var j = array.length - 1; j >= i; j--) {
                    if (array[j - 1] > array[j]) {
                        buffer = array[j - 1];
                        array[j - 1] = array[j];
                        array[j] = buffer;
                    }
                }
            }
            return customArray.setIntArray(array);
        }
        logger.log(Level.ERROR, "Incorrect array");
        return false;
    }

    @Override
    public boolean selectionSort(CustomArray customArray) throws CustomArrayException {
        if (validate(customArray)) {
            int[] array = customArray.getIntArray();
            int buffer = 0, imin = 0;
            for (var i = 0; i < array.length - 1; i++) {
                imin = i;
                for (var j = i + 1; j < array.length; j++) {
                    imin = array[imin] > array[j] ? j : imin;
                }
                if (imin != i) {
                    buffer = array[imin];
                    array[imin] = array[i];
                    array[i] = buffer;
                }
            }
            return customArray.setIntArray(array);
        }
        logger.log(Level.ERROR, "Incorrect array");
        return false;
    }

    @Override
    public boolean insertSort(CustomArray customArray) throws CustomArrayException {
        if (validate(customArray)) {
            int[] array = customArray.getIntArray();
            int buffer = 0, j = 0;
            for (var i = 1; i < array.length; i++) {
                buffer = array[i];
                for (j = i - 1; j >= 0 && buffer < array[j]; j--) {
                    array[j + 1] = array[j];
                }
                array[j + 1] = buffer;
            }
            return customArray.setIntArray(array);
        }
        logger.log(Level.ERROR, "Incorrect array");
        return false;
    }

    @Override
    public boolean streamSort(CustomArray customArray) throws CustomArrayException {
        if (validate(customArray)) {

            int[] array = customArray.getIntArray();
            int[] sortedArray;
            sortedArray = IntStream.of(array)
                    .sorted()
                    .toArray();
            return customArray.setIntArray(sortedArray);
        }
        logger.log(Level.ERROR, "Incorrect array");
        return false;
    }

    private boolean validate(CustomArray customArray) throws CustomArrayException {
        if (customArray != null) {
            if (customArray.getIntArray() != null && customArray.getIntArray().length > 0) {
                return true;
            }
        }
        logger.log(Level.ERROR, "Incorrect CustomArray (is null or array is null or length <1");
        throw new CustomArrayException("Incorrect CustomArray (is null or array is null or length <1");
    }

}
