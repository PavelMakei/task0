package by.makei.array.validator;

import by.makei.array.validator.impl.FileValidatorImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class FileValidatorImplTest {

    FileValidatorImpl fileValidatorImpl = FileValidatorImpl.getInstance();

    @Test
    void positiveValidateFileTest() {
        String fileName = "datafile/incomeData.txt";
        boolean actual = fileValidatorImpl.validateFile(fileName);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @NullSource
    void NullSourceNumberValidatorTest(String fileName) {
        assertFalse(fileValidatorImpl.validateFile(fileName));;
    }

    @Test
    void fileIsNotExistValidateFileTest() {
        String fileName = " Sdf&%&^76";
        boolean actual = fileValidatorImpl.validateFile(fileName);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void fileIsEmptyValidateFileTest() {
        String fileName = "datafile/incomeDataZero.txt";
        boolean actual = fileValidatorImpl.validateFile(fileName);
        boolean expected = false;
        assertEquals(expected, actual);
    }

}
