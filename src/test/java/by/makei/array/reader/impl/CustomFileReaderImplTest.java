package by.makei.array.reader.impl;

import by.makei.array.reader.CustomFileReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomFileReaderImplTest {
    CustomFileReader customFileReader = new CustomFileReaderImpl();

    @Test
    void readLinesFromFile() {
        String fileName = "datafile/incomeData.txt";
        //customFileReader.readLinesFromFile(fileName);
    }
}