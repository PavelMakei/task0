package by.makei.array.service;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.IncorrectCustomArrayArithmeticException;
import by.makei.array.exception.IncorrectCustomArrayInsertException;
import by.makei.array.exception.IncorrectCustomArrayException;

public interface CustomMath {

        int findMax(CustomArray customArray);
        int findMaxStream(CustomArray customArray);
        int findMin(CustomArray customArray);
        int findMinStream(CustomArray customArray);
        double findAverage(CustomArray customArray) throws IncorrectCustomArrayInsertException;
        double findAverageStream(CustomArray customArray);
        int sumArray(CustomArray customArray) throws IncorrectCustomArrayInsertException, IncorrectCustomArrayArithmeticException, IncorrectCustomArrayException;
        int sumArrayStream(CustomArray customArray) throws IncorrectCustomArrayInsertException, IncorrectCustomArrayException, IncorrectCustomArrayArithmeticException;
        int countPositive(CustomArray customArray) throws IncorrectCustomArrayInsertException, IncorrectCustomArrayException;
        int countPositiveStream(CustomArray customArray) throws IncorrectCustomArrayException;
        int countNegative(CustomArray customArray) throws IncorrectCustomArrayException;
        int countNegativeStream(CustomArray customArray) throws IncorrectCustomArrayException;


}
