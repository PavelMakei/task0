package by.makei.array.service.impl;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CustomServiceImplTest {
    CustomServiceImpl service;


    @BeforeMethod
    public void setUp() {
        service = new CustomServiceImpl();
    }

    @Test
    public void testFindMax() {
        int[] array = {2,4,1};
        int expected = 4;
        int actual = service.findMax(array);
        assertEquals(actual,expected);
    }

    @Test
    public void testFindMin() {
    }

    @Test
    public void testFindAverage() {
    }

    @Test
    public void testSumArray() {
    }

    @Test
    public void testCountPositive() {
    }

    @Test
    public void testCountNegative() {
    }

    @Test
    public void testSumPositive() {
    }

    @Test
    public void testSumNegative() {
    }
}