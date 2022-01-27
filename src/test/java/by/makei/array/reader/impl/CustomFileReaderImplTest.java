package by.makei.array.reader.impl;

import by.makei.array.reader.CustomFileReader;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomFileReaderImplTest {
    CustomFileReader customFileReader = new CustomFileReaderImpl();

    @Test
    void readLinesFromFilePositiveTest() {
        String fileName = "datafile/incomeData.txt";
        List<String> expected = Arrays.asList("23 34 55 18 146 -22", "-5544332 1333 5859632 123", "345 65 0");;
        List<String> actual = customFileReader.readLinesFromFile(fileName);
        assertLinesMatch(expected,actual);
    }

    @Test
    void testReadLinesFromFile() {
        String incorrectFileName = "incorrectFileName.txt";
        assertThrowsExactly(NullPointerException.class,
                () ->customFileReader.readLinesFromFile("incorrectFileName.txt"));

    }
}