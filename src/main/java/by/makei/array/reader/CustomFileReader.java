package by.makei.array.reader;

import by.makei.array.exception.CustomException;
import by.makei.array.validator.NumberValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CustomFileReader {
    private static final CustomFileReader instance = new CustomFileReader();
    private static final Logger logger = LogManager.getLogger();
    private final NumberValidator numberValidator = NumberValidator.getInstance();

    private CustomFileReader() {
    }

    public static CustomFileReader getInstance() {
        return instance;
    }

    public List<String> readLinesFromFile(String fileName) throws CustomException {
        String line;
        List<String> list = new ArrayList<>();
        File file = new File(fileName);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while ((line = bufferedReader.readLine()) != null) {
                if (numberValidator.validateStringWithIntegers(line)) {
                    list.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            logger.log(Level.ERROR, "File \"{}\" has not been found", file.getAbsolutePath());
            throw new CustomException("File \"" + file.getAbsolutePath() + "\" hasn't been found", e);
        } catch (IOException e) {
            logger.log(Level.ERROR, "File \"" + file.getAbsolutePath() + "\" hasn't been read", e);
            throw new CustomException("File \"" + file.getAbsolutePath() + "\" hasn't been read", e);
        }

        return list;
    }
}
