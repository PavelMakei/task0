package by.makei.array.service.impl;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.IncorrectCustomArrayInsertException;
import by.makei.array.service.CustomMath;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CustomMathImplTest {
    private final CustomMath service =  CustomMathImpl.getInstance();

    @Test()
    @Timeout(value = 70, unit = TimeUnit.MILLISECONDS)
    public void testFindMaxPositive() {
        int[] array = {2, 4, 1};
        CustomArray customArray = new CustomArray(array);
        int expected = 4;
        int actual = service.findMax(customArray);
        assertEquals(actual, expected);
    }

    @Test()
    public void testFindMaxNegative() {
        int[] array = {2, 4, 1};
        CustomArray customArray = new CustomArray(array);
        int expected = 2;
        int actual = service.findMax(customArray);
        assertFalse(actual == expected);
    }

    @Test
    void findAverage() throws IncorrectCustomArrayInsertException {
        int[] array = {Integer.MAX_VALUE, 234,432};
        CustomArray customArray = new CustomArray(array);
        double expected = 234;
        double actual = service.findAverage(customArray);
        assertEquals(expected, actual);
    }

    @Test
    void sumArray() {
    }

    @Test
    void findAverageStream() {
        int[] array = {Integer.MAX_VALUE, Integer.MAX_VALUE,432};
        CustomArray customArray = new CustomArray(array);
        double expected = 234;
        double actual = service.findAverageStream(customArray);
        assertEquals(expected, actual);
    }
}