package by.makei.array.validator.impl;

import by.makei.array.validator.FileValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.URL;


public class FileValidatorImpl implements FileValidator {
    private static final Logger logger = LogManager.getLogger();
    private static final FileValidatorImpl instance = new FileValidatorImpl();

    private FileValidatorImpl(){};

    public static FileValidatorImpl getInstance() {
        return instance;
    }

    public boolean validateFile(String fileName) {
        boolean isValid;
        if (fileName != null) {
            fileName = fileName.replace("\\", "/");
            File file;
            URL url = getClass().getClassLoader().getResource(fileName);
            if (url == null) {
                logger.log(Level.ERROR, "Wrong filename");
                return false;
            }
            file = new File(url.getFile());
            if (file.length() > 0) {
                logger.log(Level.INFO, "File is correct");
                isValid = true;
            } else {
                logger.log(Level.ERROR, "File {} is not exist or has size 0", fileName);
                isValid = false; //can be removed
            }
        } else {
            logger.log(Level.ERROR, "FileName is null");
            isValid = false; //can be removed

        }
        return isValid;
    }
}
