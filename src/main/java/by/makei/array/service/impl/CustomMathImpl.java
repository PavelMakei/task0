package by.makei.array.service.impl;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.CustomArrayException;
import by.makei.array.service.CustomMath;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;

public class CustomMathImpl implements CustomMath {
    private static final Logger logger = LogManager.getLogger();
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
        for (int i : array) {
            if (i > result) {
                result = i;
            }
        }
        logger.log(Level.INFO, "find max = {}", result);
        return result;
    }

    @Override
    public int findMaxStream(CustomArray customArray) {
        int[] array = customArray.getIntArray();
        int result = IntStream.of(array).max().getAsInt();
        logger.log(Level.INFO, "find max stream = {}", result);
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
        logger.log(Level.INFO, "find min = {}", result);
        return result;
    }

    @Override
    public int findMinStream(CustomArray customArray) {
        int[] array = customArray.getIntArray();
        int result = Arrays.stream(array).min().getAsInt();
        logger.log(Level.INFO, "find min stream = {}", result);
        return result;
    }

    @Override
    public double findAverage(CustomArray customArray) {
        int[] array = customArray.getIntArray();
        long sum = 0L;
        for (int i : array) {
            sum += i;
        }
        double result = (double) sum / array.length;
        logger.log(Level.INFO, "find average = {}", result);
        return result;
    }

    @Override
    public double findAverageStream(CustomArray customArray) {
        int[] array = customArray.getIntArray();
        double result = Arrays.stream(array).mapToDouble(value -> value).average().getAsDouble();
        logger.log(Level.INFO, "find average stream = {}", result);
        return result;
    }

    @Override
    public int sumArray(CustomArray customArray) throws CustomArrayException {
        if (validate(customArray)) {
            int[] array = customArray.getIntArray();
            int result = 0;
            try {
                for (int i : array) {
                    result = Math.addExact(result, i);
                }
                logger.log(Level.INFO, "sum = {}", result);
                return result;
            } catch (ArithmeticException e) {
                logger.log(Level.ERROR, "The sum of array is too big or too low", e);
                throw new CustomArrayException("The sum of array is too big or too low", e);
            }
        }
        return 0;
    }

    @Override
    public int sumArrayStream(CustomArray customArray) throws CustomArrayException {
        if (validate(customArray)) {
            int[] array = customArray.getIntArray();
            BigInteger sum = Arrays.stream(array).mapToObj(BigInteger::valueOf)
                    .reduce(BigInteger.ZERO, (a, b) -> a.add(b));
            try {
                int result = sum.intValueExact();
                logger.log(Level.INFO, "sum stream = {}", result);
                return result;
            } catch (ArithmeticException e) {
                // logger.error("The sum of array is too big or too low");
                throw new CustomArrayException("The sum of array is too big or too low", e);
            }
        }
        return 0;
    }

    @Override
    public int countPositive(CustomArray customArray) throws CustomArrayException {
        if (validate(customArray)) {
            int[] array = customArray.getIntArray();
            long result = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] > 0) {
                    result++;
                }
            }
            logger.log(Level.INFO, "count positive = {}", result);
            return (int) result;
        }
        return 0;
    }

    @Override
    public int countPositiveStream(CustomArray customArray) throws CustomArrayException {
        if (validate(customArray)) {
            int[] array = customArray.getIntArray();
            long result = Arrays.stream(array).filter(a -> a > 0).count();
            logger.log(Level.INFO, "count positive stream = {}", result);
            return (int) result;
        }
        return 0;
    }

    @Override
    public int countNegative(CustomArray customArray) throws CustomArrayException {
        if (validate(customArray)) {
            int[] array = customArray.getIntArray();
            long result = 0;
            for (int i : array) {
                if (i < 0) {
                    result++;
                }
            }
            logger.log(Level.INFO, "count negative = {}", result);
            return (int) result;
        }
        return 0;
    }

    @Override
    public int countNegativeStream(CustomArray customArray) throws CustomArrayException {
        if (validate(customArray)) {
            int[] array = customArray.getIntArray();
            long result = Arrays.stream(array).filter(a -> a < 0).count();
            logger.log(Level.INFO, "count negative stream = {}", result);
            return (int) result;
        }
        return 0;
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