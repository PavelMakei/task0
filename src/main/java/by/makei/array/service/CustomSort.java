package by.makei.array.service;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.CustomException;

public interface CustomSort {
    void bubbleSort(CustomArray customArray) throws CustomException;
    void selectionSort(CustomArray customArray) throws CustomException;
    void insertSort(CustomArray customArray) throws CustomException;
    void streamSort(CustomArray customArray) throws CustomException;

}
