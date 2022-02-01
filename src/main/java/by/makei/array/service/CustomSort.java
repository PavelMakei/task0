package by.makei.array.service;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.CustomArrayException;

public interface CustomSort {
    boolean bubbleSort(CustomArray customArray) throws CustomArrayException;
    boolean selectionSort(CustomArray customArray) throws CustomArrayException;
    boolean insertSort(CustomArray customArray) throws CustomArrayException;
    boolean streamSort(CustomArray customArray) throws CustomArrayException;

}
