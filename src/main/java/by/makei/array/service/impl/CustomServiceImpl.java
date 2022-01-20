package by.makei.array.service.impl;

import by.makei.array.service.CustomService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.IntStream;

public class CustomServiceImpl implements CustomService {
   // private static Logger logger = LogManager.getLogger();

    @Override
    public int findMax(int[] array) {
        int result;
        result = IntStream.of(array).max().getAsInt();
        //logger.log(Level.INFO,"The maximum number is "+ result);
        return result;
    }

    @Override
    public int findMin(int[] array) {
        return 0;
    }

    @Override
    public double findAverage(int[] array) {
        return 0;
    }

    @Override
    public int sumArray(int[] array) {
        return 0;
    }

    @Override
    public int countPositive(int[] array) {
        return 0;
    }

    @Override
    public int countNegative(int[] array) {
        return 0;
    }

    @Override
    public int sumPositive(int[] array) {
        return 0;
    }

    @Override
    public int sumNegative(int[] array) {
        return 0;
    }
}
