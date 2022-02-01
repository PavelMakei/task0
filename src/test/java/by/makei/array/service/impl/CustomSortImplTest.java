package by.makei.array.service.impl;

import by.makei.array.entity.CustomArray;
import by.makei.array.exception.CustomArrayException;
import by.makei.array.service.CustomSort;
import by.makei.array.service.CustomUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomSortImplTest {
    private static final CustomSort service = CustomSortImpl.getInstance();
    public int id = 0;
    public CustomArray customArray;
    public int[] testArray = {1,2,5,4,3};
    public CustomArray nullableCustomArray = null;

    @BeforeEach
    public void setUp() throws CustomArrayException {
        customArray = new CustomArray(testArray);
    }

    @Test
    public void bubbleSortTest() throws CustomArrayException {
        service.bubbleSort(customArray);
        int[] actual = customArray.getIntArray();
        int[] expected = {1,2,3,4,5};
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void bubbleSortPositiveTest() throws CustomArrayException {
        assert (service.bubbleSort(customArray));
    }

    @Test
    public void bubbleSortThrowException()  {
        Assertions.assertThrows(CustomArrayException.class, () -> service.bubbleSort(nullableCustomArray));
    }

    @Test
   public void selectionSortTest() throws CustomArrayException {
        service.selectionSort(customArray);
        int[] actual = customArray.getIntArray();
        int[] expected = {1,2,3,4,5};
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void selectionSortPositiveTest() throws CustomArrayException {
        assert(service.selectionSort(customArray));
    }

    @Test
    public void selectionSortThrowExceptionTest()  {
        Assertions.assertThrows(CustomArrayException.class, () -> service.selectionSort(nullableCustomArray));
    }

    @Test
    public void insertSortTest() throws CustomArrayException {
        service.insertSort(customArray);
        int[] actual = customArray.getIntArray();
        int[] expected = {1,2,3,4,5};
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void insertSortPositiveTest() throws CustomArrayException {
        assert (service.insertSort(customArray));
    }

    @Test
    public void insertSortThrowException()  {
        Assertions.assertThrows(CustomArrayException.class, () -> service.insertSort(nullableCustomArray));
    }

    @Test
    public void streamSortTest() throws CustomArrayException {
        service.streamSort(customArray);
        int[] actual = customArray.getIntArray();
        int[] expected = {1,2,3,4,5};
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void streamSortPositive() throws CustomArrayException {
        assert (service.streamSort(customArray));
    }

    @Test
    public void streamSortThrowException()  {
        Assertions.assertThrows(CustomArrayException.class, () -> service.streamSort(nullableCustomArray));
    }

}