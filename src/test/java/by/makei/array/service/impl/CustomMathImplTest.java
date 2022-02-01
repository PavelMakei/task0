package by.makei.array.service.impl;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.CustomArrayException;
import by.makei.array.service.CustomMath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CustomMathImplTest {

    private static final CustomMath service = CustomMathImpl.getInstance();

    @Test()
    public void FindMaxPositiveTest() throws CustomArrayException {
        int[] array = {2, 4, 1};
        CustomArray customArray = new CustomArray(array);
        int expected = 4;
        int actual = service.findMax(customArray);
        assertEquals(actual, expected);
    }

    @Test()
    public void FindMaxNegativeTest() throws CustomArrayException {
        int[] array = {2, 4, 1};
        CustomArray customArray = new CustomArray(array);
        int expected = 2;
        int actual = service.findMax(customArray);
        assertFalse(actual == expected);
    }

    @Test
    public void findAveragePositiveTest() throws CustomArrayException {
        int[] array = {5, 2};
        CustomArray customArray = new CustomArray(array);
        double expected = 2.5;
        double actual = service.findAverage(customArray);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void findAverageStreamPositiveTest() throws CustomArrayException {
        int[] array = {Integer.MAX_VALUE, 234, 432};
        CustomArray customArray = new CustomArray(array);
        double expected = 715828104.33;
        double actual = service.findAverageStream(customArray);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void findMaxStreamPositiveTest() throws CustomArrayException {
        int[] array = {2, 4, 1};
        CustomArray customArray = new CustomArray(array);
        int expected = 4;
        int actual = service.findMaxStream(customArray);
        assertEquals(actual, expected);
    }

    @Test
    public void findMinPositiveTest() throws CustomArrayException {
        int[] array = {2, 4, 1};
        CustomArray customArray = new CustomArray(array);
        int expected = 1;
        int actual = service.findMin(customArray);
        assertEquals(actual, expected);
    }

    @Test
    public void findMinStream() throws CustomArrayException {
        int[] array = {2, 4, 1};
        CustomArray customArray = new CustomArray(array);
        int expected = 1;
        int actual = service.findMinStream(customArray);
        assertEquals(actual, expected);
    }

    @Test
    public void sumArrayPositiveTest() throws CustomArrayException {
        int[] array = {2, 4, 1};
        CustomArray customArray = new CustomArray(array);
        int expected = 7;
        int actual = service.sumArray(customArray);
        assertEquals(actual, expected);
    }

    @Test
    public void sumArrayTrowExceptionTest() throws CustomArrayException {
        int[] array = {2, 4, 1, Integer.MIN_VALUE, Integer.MIN_VALUE};
        CustomArray customArray = new CustomArray(array);
        Assertions.assertThrows(CustomArrayException.class, () -> service.sumArray(customArray));
    }

    @Test
    public void sumArrayStreamPositiveTest() throws CustomArrayException {
        int[] array = {2, 4, 1};
        CustomArray customArray = new CustomArray( array);
        int expected = 7;
        int actual = service.sumArrayStream(customArray);
        assertEquals(actual, expected);
    }

    @Test
    public void countPositiveTest() throws CustomArrayException {
        int[] array = {2, 4, 1, -6, -234};
        CustomArray customArray = new CustomArray(array);
        int expected = 3;
        int actual = service.countPositive(customArray);
        assertEquals(actual, expected);
    }

    @Test
    public void countPositiveStreamTest() throws CustomArrayException {
        int[] array = {2, 4, 1, -6, -234};
        CustomArray customArray = new CustomArray(array);
        int expected = 3;
        int actual = service.countPositiveStream(customArray);
        assertEquals(actual, expected);
    }

    @Test
    public void countNegativeTest() throws CustomArrayException {
        int[] array = {2, 4, 1, -6, -234};
        CustomArray customArray = new CustomArray(array);
        int expected = 2;
        int actual = service.countNegative(customArray);
        assertEquals(actual, expected);
    }

    @Test
    public void countNegativeStream() throws CustomArrayException {
        int[] array = {2, 4, 1, -6, -234};
        CustomArray customArray = new CustomArray(array);
        int expected = 2;
        int actual = service.countNegativeStream(customArray);
        assertEquals(actual, expected);
    }
}