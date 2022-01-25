package by.makei.array.service.impl;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.CustomException;
import by.makei.array.reader.CustomFileReader;
import by.makei.array.service.CustomMath;
import by.makei.array.validator.NumberValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CustomMathImpl implements CustomMath {

    private static Logger logger = LogManager.getLogger(CustomMathImpl.class);
    private static final CustomMathImpl instance = new CustomMathImpl();

    private CustomMathImpl() {
    }

    public static CustomMathImpl getInstance() {
        return instance;
    }


    @Override
    public int findMax(CustomArray customArray) {
        int[] array = customArray.getIntArray();
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > result) {
                result = array[i];
            }
        }
        logger.log(Level.INFO, "find max = " + result);
        return result;
    }

    @Override
    public int findMaxStream(CustomArray customArray) {
        int[] array = customArray.getIntArray();
        int result = IntStream.of(array).max().getAsInt();
        logger.log(Level.INFO, "find max stream = " + result);
        return result;
    }

    @Override
    public int findMin(CustomArray customArray) {
        int[] array = customArray.getIntArray();
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < result) {
                result = array[i];
            }
        }
        logger.log(Level.INFO, "find min = " + result);
        return result;
    }

    @Override
    public int findMinStream(CustomArray customArray) {
        int[] array = customArray.getIntArray();
        int result = Arrays.stream(array).min().getAsInt();
        logger.log(Level.INFO, "find min stream = " + result);
        return result;
    }

    @Override
    public double findAverage(CustomArray customArray) {
        int[] array = customArray.getIntArray();
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        double result = sum / array.length;
        logger.log(Level.INFO, "find average = " + result);
        return result;
    }

    @Override
    public double findAverageStream(CustomArray customArray) {
        int[] array = customArray.getIntArray();
        double result = Arrays.stream(array).average().getAsDouble();
        logger.log(Level.INFO, "find average stream = " + result);
        return result;
    }

    @Override
    public int sumArray(CustomArray customArray) throws CustomException {
        int[] array = customArray.getIntArray();
        int result = 0;
        try {
            for (int i = 0; i < array.length; i++) {
                result = Math.addExact(result, array[i]);
            }
            logger.log(Level.INFO, "sum stream = " + result);
            return result;
        } catch (ArithmeticException e) {
            logger.error("The sum of array is too big or too low");
            throw new CustomException("The sum of array is too big or too low", e);
        }
    }

    @Override
    public int sumArrayStream(CustomArray customArray) throws CustomException {
        int[] array = customArray.getIntArray();
        BigInteger sum = Arrays.stream(array).mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ZERO, (a, b) -> a.add(b));
        try {
            int result = sum.intValueExact();
            logger.log(Level.INFO, "find average stream = " + result);
            return result;
        } catch (ArithmeticException e) {
            logger.error("The sum of array is too big or too low");
            throw new CustomException("The sum of array is too big or too low", e);
        }
    }

    @Override
    public int countPositive(CustomArray customArray) {
        int[] array = customArray.getIntArray();
        long result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                result++;
            }
        }
        logger.log(Level.INFO, "count positive = " + result);
        return (int) result;
    }

    @Override
    public int countPositiveStream(CustomArray customArray) {
        int[] array = customArray.getIntArray();
        long result = Arrays.stream(array).filter(a -> a > 0).count();
        logger.log(Level.INFO, "count positive stream = " + result);
        return (int) result;
    }

    @Override
    public int countNegative(CustomArray customArray) {
        int[] array = customArray.getIntArray();
        long result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                result++;
            }
        }
        logger.log(Level.INFO, "count negative = " + result);
        return (int) result;
    }

    @Override
    public int countNegativeStream(CustomArray customArray) {
        int[] array = customArray.getIntArray();
        long result = Arrays.stream(array).filter(a -> a < 0).count();
        logger.log(Level.INFO, "count negative stream = " + result);
        return (int) result;
    }

}
