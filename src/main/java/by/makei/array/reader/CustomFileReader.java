package by.makei.array.reader;

import by.makei.array.exception.CustomArrayException;

import java.util.List;

public interface CustomFileReader {
    List<String> readLinesFromFile(String fileName) throws CustomArrayException;
}
