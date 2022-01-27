package by.makei.array.reader;

import java.net.URISyntaxException;
import java.util.List;

public interface CustomFileReader {
    List<String> readLinesFromFile(String fileName) throws URISyntaxException;
}
