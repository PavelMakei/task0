package by.makei.array.reader.impl;

import by.makei.array.exception.CustomArrayException;
import by.makei.array.reader.CustomFileReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomFileReaderImplTest {
    public CustomFileReader customFileReader = CustomFileReaderImpl.getInstance();

    @Test
    public void readLinesFromFilePositiveTest() throws CustomArrayException {
        String fileName = "datafile/incomeData.txt";
        List<String> expected = Arrays.asList("23 34 55 18 146 -22", "-5544332 1333 5859632 123", "345 65 0", "345980485 -34534452 5 8767");
        List<String> actual = customFileReader.readLinesFromFile(fileName);
        assertLinesMatch(expected, actual);
    }

    @Test
    public void ReadLinesFromFileNegativeTest() {
        String incorrectFileName = "incorrectFileName.txt";
        assertThrowsExactly(NullPointerException.class,
                () -> customFileReader.readLinesFromFile(incorrectFileName));
    }

    @ParameterizedTest
    @NullSource
    void ReadLinesFromFileNullFileName(String nullFileName) {
        assertThrowsExactly(NullPointerException.class,
                () -> customFileReader.readLinesFromFile(nullFileName));
    }

}