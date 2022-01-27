package by.makei.array.service;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.IncorrectCustomArrayInsertException;
import by.makei.array.exception.IncorrectCustomArrayException;

public interface CustomSort {
    void bubbleSort(CustomArray customArray) throws IncorrectCustomArrayException, IncorrectCustomArrayInsertException;
    void selectionSort(CustomArray customArray) throws IncorrectCustomArrayException;
    void insertSort(CustomArray customArray) throws IncorrectCustomArrayException;
    void streamSort(CustomArray customArray) throws IncorrectCustomArrayException;

}
