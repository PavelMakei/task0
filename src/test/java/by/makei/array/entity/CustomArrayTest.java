package by.makei.array.entity;

import by.makei.array.exception.CustomArrayException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomArrayTest {
    CustomArray customArray;

//    @Test @BeforeAll
//    void before() throws CustomArrayException {
//        long id = 0;
//        int[] intArray = {1,2,3,4,5};
//        customArray = new CustomArray(id,intArray);
//    }

    @Test
    public void getIdTest() throws CustomArrayException {
        String id = "0";
        int[] intArray = {123};
        CustomArray customArray = new CustomArray( intArray);
        String actual = customArray.getId();
        String expected = "0";
        assertEquals(actual, expected);
    }

    @Test
    public void setIntArrayTestPositiveTrue() throws CustomArrayException {
        long id = 0;
        int[] intArray = {1, 2, 3, 4, 5};
        CustomArray customArray = new CustomArray( intArray);
        int[] array = {5, 2, 3, 4, 1};
        assert (customArray.setIntArray(array));
    }

    @Test
    public void setIntArrayTestEquals() throws CustomArrayException {
        long id = 0;
        int[] intArray = {1, 2, 3, 4, 5};
        CustomArray customArray = new CustomArray( intArray);
        int[] array = {5, 2, 3, 4, 1};
        customArray.setIntArray(array);
        int[] expected = customArray.getIntArray();
        assertArrayEquals(expected, array);
    }

    @Test
    void newCustomArrayNullableArrayTest() {
        Assertions.assertThrows(CustomArrayException.class, () -> new CustomArray(null));
    }

    @Test
    void newCustomIntArrayZeroLengthTest() {
        int[] array = new int[]{};
        Assertions.assertThrows(CustomArrayException.class, () -> new CustomArray( array));
    }

}