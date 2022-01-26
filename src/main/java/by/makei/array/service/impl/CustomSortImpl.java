package by.makei.array.service.impl;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.CustomException;
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
    public void bubbleSort(CustomArray customArray) throws CustomException {
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
            customArray.setIntArray(array);
            logger.log(Level.INFO, "bubbleSort finished");
    }

    @Override
    public void selectionSort(CustomArray customArray) throws CustomException {
        int[] array = customArray.getIntArray();
        logger.log(Level.INFO, "selectionSort started");
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
            customArray.setIntArray(array);
            logger.log(Level.INFO, "selectionSort finished");
    }

    @Override
    public void insertSort(CustomArray customArray) throws CustomException {
        int[] array = customArray.getIntArray();
        logger.log(Level.INFO, "insertSort started");
        if (array != null && array.length >= 1) {
            int buffer = 0, j = 0;
            for (var i = 1; i < array.length; i++) {
                buffer = array[i];
                for (j = i - 1; j >= 0 && buffer < array[j]; j--) {
                    array[j + 1] = array[j];
                }
                array[j + 1] = buffer;
            }
            customArray.setIntArray(array);
            logger.log(Level.INFO, "insertSort finished");
        } else {
            logger.log(Level.ERROR,"Array is null or length less then 1");
            throw new CustomException("Array is null or length less then 1");
        }
    }

    @Override
    public void streamSort(CustomArray customArray) throws CustomException {
        int[] array = customArray.getIntArray();
        logger.log(Level.INFO, "streamSort started");
        if (array != null && array.length >= 1) {
            int[] sortedArray;
            sortedArray = IntStream.of(array)
                    .sorted()
                    .toArray();
            customArray.setIntArray(sortedArray);
            logger.log(Level.INFO, "streamSort finished");
        } else {
            logger.log(Level.ERROR,"Array is null or length less then 1");
            throw new CustomException("Array is null or length less then 1");
        }
    }
}
