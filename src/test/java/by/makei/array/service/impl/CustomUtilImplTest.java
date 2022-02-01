package by.makei.array.service.impl;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.CustomArrayException;
import by.makei.array.service.CustomUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CustomUtilImplTest {

    private static final CustomUtil service = CustomUtilImpl.getInstance();
    public CustomArray customArray;
    public int[] testArray = {2,2,5,4,3};

    @BeforeEach
    public void setUp() throws CustomArrayException {
        customArray = new CustomArray(testArray);
    }
    
    @Test
    public void replaceTest() throws CustomArrayException {
        int index = 4;
        int value = 7;
        service.replace(customArray,index,value);
        int[] actual = customArray.getIntArray();
        int[] expected = {2,2,5,4,7};
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void replaceTestPositiveTest() throws CustomArrayException {
        int index = 4;
        int value = 7;
        assert (service.replace(customArray,index,value));
    }

    @Test
    public void replaceTestNegativeTest() throws CustomArrayException {
        int index = 5;
        int value = 7;
        Assertions.assertFalse (service.replace(customArray,index,value));
    }

    @Test
    public void replaceStreamTest() throws CustomArrayException {
        int index = 4;
        int value = 7;
        service.replaceStream(customArray,index,value);
        int[] actual = customArray.getIntArray();
        int[] expected = {2,2,5,4,7};
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void replaceStreamPositiveTest() throws CustomArrayException {
        int index = 4;
        int value = 7;
        assert(service.replaceStream(customArray,index,value));
    }

    @Test
    public void replaceStreamNegativeTest() throws CustomArrayException {
        int index = 5;
        int value = 7;
        Assertions.assertFalse(service.replaceStream(customArray,index,value));
    }

    @Test
    public void replaceAllTest() throws CustomArrayException {
        int index = 2;
        int value = 7;
        service.replaceAll(customArray,index,value);
        int[] actual = customArray.getIntArray();
        int[] expected = {7,7,5,4,3};
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void replaceAllPositiveTest() throws CustomArrayException {
        int index = 2;
        int value = 7;
        assert(service.replaceAll(customArray,index,value));
    }

    @Test
    public void replaceAllStreamTest() throws CustomArrayException {
        int index = 2;
        int value = 7;
        service.replaceAllStream(customArray,index,value);
        int[] actual = customArray.getIntArray();
        int[] expected = {7,7,5,4,3};
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void replaceAllStreamPositiveTest() throws CustomArrayException {
        int index = 2;
        int value = 7;
        assert(service.replaceAllStream(customArray,index,value));
    }
}