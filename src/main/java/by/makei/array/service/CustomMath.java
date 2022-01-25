package by.makei.array.service;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.CustomException;

public interface CustomMath {

        int findMax(CustomArray customArray);
        int findMaxStream(CustomArray customArray);
        int findMin(CustomArray customArray);
        int findMinStream(CustomArray customArray);
        double findAverage(CustomArray customArray) throws CustomException;
        double findAverageStream(CustomArray customArray);
        int sumArray(CustomArray customArray) throws CustomException;
        int sumArrayStream(CustomArray customArray) throws CustomException;
        int countPositive(CustomArray customArray) throws CustomException;
        int countPositiveStream(CustomArray customArray);
        int countNegative(CustomArray customArray);
        int countNegativeStream(CustomArray customArray);


}
