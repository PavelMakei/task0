package by.makei.array.service;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.CustomArrayException;

public interface CustomMath {

    int findMax(CustomArray customArray);

    int findMaxStream(CustomArray customArray);

    int findMin(CustomArray customArray);

    int findMinStream(CustomArray customArray);

    double findAverage(CustomArray customArray);

    double findAverageStream(CustomArray customArray);

    int sumArray(CustomArray customArray) throws CustomArrayException;

    int sumArrayStream(CustomArray customArray) throws CustomArrayException;

    int countPositive(CustomArray customArray) throws CustomArrayException;

    int countPositiveStream(CustomArray customArray) throws CustomArrayException;

    int countNegative(CustomArray customArray) throws CustomArrayException;

    int countNegativeStream(CustomArray customArray) throws CustomArrayException;


}
