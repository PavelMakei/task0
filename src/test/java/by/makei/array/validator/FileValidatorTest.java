package by.makei.array.validator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class FileValidatorTest {

    FileValidator fileValidator = new FileValidator();

    @Test
    void positiveValidateFileTest() {
        String fileName = "datafile/incomeData.txt";
        boolean actual = fileValidator.validateFile(fileName);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void fileNameIsNullValidateFileTest() {
        String fileName = null;
        assertFalse(fileValidator.validateFile(fileName));
    }

    @Test
    void fileIsNotExistValidateFileTest() {
        String fileName = " Sdf&%&^76";
        boolean actual = fileValidator.validateFile(fileName);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void fileIsEmptyValidateFileTest() {
        String fileName = "datafile/incomeDataZero.txt";
        boolean actual = fileValidator.validateFile(fileName);
        boolean expected = false;
        assertEquals(expected, actual);
    }

}
