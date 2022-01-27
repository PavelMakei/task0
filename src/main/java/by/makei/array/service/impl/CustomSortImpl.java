package by.makei.array.service.impl;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.IncorrectCustomArrayInsertException;
import by.makei.array.exception.IncorrectCustomArrayException;
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
    public void bubbleSort(CustomArray customArray) throws IncorrectCustomArrayException {
        if (validate(customArray)) {
            int[] array = customArray.getIntArray();
            logger.log(Level.INFO, "bubbleSort started");
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
            try {
                customArray.setIntArray(array);
            } catch (IncorrectCustomArrayInsertException e) {
                logger.log(Level.WARN, "Exception can not be thrown");
            }
        }
    }

    @Override
    public void selectionSort(CustomArray customArray) throws IncorrectCustomArrayException {
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
            try {
                customArray.setIntArray(array);
            } catch (IncorrectCustomArrayInsertException e) {
                logger.log(Level.WARN, "Exception can not be thrown");
            }
        }
    }

    @Override
    public void insertSort(CustomArray customArray) throws IncorrectCustomArrayException {
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
            try {
                customArray.setIntArray(array);
            } catch (IncorrectCustomArrayInsertException e) {
                logger.log(Level.WARN, "Exception can not be thrown");
            }
        }
    }

    @Override
    public void streamSort(CustomArray customArray) throws IncorrectCustomArrayException {
        if (validate(customArray)) {

            int[] array = customArray.getIntArray();
            int[] sortedArray;
            sortedArray = IntStream.of(array)
                    .sorted()
                    .toArray();
            try {
                customArray.setIntArray(sortedArray);
            } catch (IncorrectCustomArrayInsertException e) {
                logger.log(Level.WARN, "Exception can't be thrown");
            }
        }
    }

    private boolean validate(CustomArray customArray) throws IncorrectCustomArrayException {
        if (customArray != null) {
            if (customArray.getIntArray() != null && customArray.getIntArray().length > 0) {
                return true;
            }
        }
        //logger.log(Level.ERROR, "Incorrect CustomArray (is null or array is null or length <1");
        throw new IncorrectCustomArrayException("Incorrect CustomArray (is null or array is null or length <1");
    }

}
