package by.makei.array.service.impl;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.CustomArrayException;
import by.makei.array.service.CustomMath;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Math service utils")
class CustomMathImplTest {

    public static final CustomMath service = CustomMathImpl.getInstance();
    public int[] array = {2, 4, 1, 7,-7};



    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    @Nested
    @DisplayName("OldSchool")
    class OldSchool {

        @Test
        @Order(3)
        public void FindMaxPositiveTest() throws CustomArrayException {
            CustomArray customArray = new CustomArray(array);
            int expected = 7;
            int actual = service.findMax(customArray);
            assertEquals(expected, actual);
        }

        @Test()
        @Order(2)
        public void FindMaxNegativeTest() throws CustomArrayException {
            CustomArray customArray = new CustomArray(array);
            int expected = 2;
            int actual = service.findMax(customArray);
            assertFalse(actual == expected);
        }

        @Test
        @Order(4)
        public void findAveragePositiveTest() throws CustomArrayException {
            CustomArray customArray = new CustomArray(array);
            double expected = 1.4;
            double actual = service.findAverage(customArray);
            assertEquals(expected, actual, 0.01);
        }

        @Test
        @Order(6)
        public void findMinPositiveTest() throws CustomArrayException {
            CustomArray customArray = new CustomArray(array);
            int expected = -7;
            int actual = service.findMin(customArray);
            assertEquals(expected, actual);
        }

        @Test
        @Order(7)
        public void sumArrayTrowExceptionTest() throws CustomArrayException {
            int[] array = {2, 4, 1, Integer.MIN_VALUE, Integer.MIN_VALUE};
            CustomArray customArray = new CustomArray(array);
            Assertions.assertThrows(CustomArrayException.class, () -> service.sumArray(customArray));
        }

        @Test
        @Order(8)
        public void countPositiveTest() throws CustomArrayException {
            int[] array = {2, 4, 1, -6, -234};
            CustomArray customArray = new CustomArray(array);
            int expected = 3;
            int actual = service.countPositive(customArray);
            assertEquals(expected, actual);
        }

        @Test
        @Order(9)
        public void countNegativeTest() throws CustomArrayException {
            int[] array = {2, 4, 1, -6, -234};
            CustomArray customArray = new CustomArray(array);
            int expected = 2;
            int actual = service.countNegative(customArray);
            assertEquals(expected, actual);
        }

        @Test
        @Order(1)
        public void sumArrayPositiveTest() throws CustomArrayException {
            CustomArray customArray = new CustomArray(array);
            int expected = 7;
            int actual = service.sumArray(customArray);
            assertEquals(expected, actual);
        }

    }

    @Nested
    @DisplayName("Stream")
    class StreamTest {

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
            CustomArray customArray = new CustomArray(array);
            int expected = 7;
            int actual = service.findMaxStream(customArray);
            assertEquals(expected, actual);
        }

        @Test
        public void findMinStream() throws CustomArrayException {
            CustomArray customArray = new CustomArray(array);
            int expected = -7;
            int actual = service.findMinStream(customArray);
            assertEquals(expected, actual);
        }

        @Test
        public void sumArrayStreamPositiveTest() throws CustomArrayException {
            CustomArray customArray = new CustomArray(array);
            int expected = 7;
            int actual = service.sumArrayStream(customArray);
            assertEquals(expected, actual);
        }

        @Test
        public void countPositiveStreamTest() throws CustomArrayException {
            int[] array = {2, 4, 1, -6, -234};
            CustomArray customArray = new CustomArray(array);
            int expected = 3;
            int actual = service.countPositiveStream(customArray);
            assertEquals(expected, actual);
        }

        @Test
        public void countNegativeStreamTest() throws CustomArrayException {
            int[] array = {2, 4, 1, -6, -234};
            CustomArray customArray = new CustomArray(array);
            int expected = 2;
            int actual = service.countNegativeStream(customArray);
            assertEquals(expected, actual);
        }
    }
}