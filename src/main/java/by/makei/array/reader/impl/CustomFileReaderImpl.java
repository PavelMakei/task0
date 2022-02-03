package by.makei.array.reader.impl;

import by.makei.array.exception.CustomArrayException;
import by.makei.array.reader.CustomFileReader;
import by.makei.array.validator.impl.NumberValidatorImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class CustomFileReaderImpl implements CustomFileReader {

    private static final Logger logger = LogManager.getLogger();
    private static final CustomFileReaderImpl instance = new CustomFileReaderImpl();
    private static final String WINDOWS_FILE_SEPARATOR = "\\";
    private static final String URL_FILE_SEPARATOR = "/";
    private CustomFileReaderImpl() {}

    public static CustomFileReaderImpl getInstance() {
        return instance;
    }


    @Override @NotNull
    public List<String> readLinesFromFile(String fileName) throws CustomArrayException {
        final NumberValidatorImpl numberValidatorImpl = NumberValidatorImpl.getInstance();
        String line;
        fileName = fileName.replace(WINDOWS_FILE_SEPARATOR, URL_FILE_SEPARATOR);
        List<String> list = new ArrayList<>();
        File file;
        URL url = getClass().getClassLoader().getResource(fileName);
        file = new File(url.getFile());
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while ((line = bufferedReader.readLine()) != null) {
                if (numberValidatorImpl.validateStringWithIntegers(line)) {
                    list.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            logger.log(Level.ERROR, "Check your file  {}", file.getAbsolutePath());
            throw new CustomArrayException("File can't be read", e);
        } catch (IOException e) {
            logger.log(Level.ERROR, "Check your file  {}", file.getAbsolutePath());
            throw new CustomArrayException("File can't be read", e);
        }

        return list;
    }
}
