package by.makei.array.reader.impl;

import by.makei.array.reader.CustomFileReader;
import by.makei.array.validator.NumberValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class CustomFileReaderImpl implements CustomFileReader {
    //TODO don't need to be Singleton? private static final CustomFileReaderImpl instance = new CustomFileReaderImpl();
    private static final Logger logger = LogManager.getLogger();

    public CustomFileReaderImpl() {} //TODO

    //TODO
//    public static CustomFileReaderImpl getInstance() {
//        return instance;
//    }

    @Override
    public List<String> readLinesFromFile(String fileName) {
        final NumberValidator numberValidator = NumberValidator.getInstance();
        String line;
        List<String> list = new ArrayList<>();
        File file;
        URL url = getClass().getClassLoader().getResource(fileName);
        try {
            file = Paths.get(url.toURI()).toFile();
        } catch (URISyntaxException e) {
            logger.log(Level.FATAL, "Check your file");
            throw new RuntimeException("File can't be read", e);
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while ((line = bufferedReader.readLine()) != null) {
                if (numberValidator.validateStringWithIntegers(line)) {
                    list.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            logger.log(Level.FATAL, "Check your file  {}", file.getAbsolutePath());
            throw new RuntimeException("File can't be read", e);
        } catch (IOException e) {
            logger.log(Level.FATAL, "Check your file  {}", file.getAbsolutePath());
            throw new RuntimeException("File can't be read", e);
        }


        return list;
    }
}
