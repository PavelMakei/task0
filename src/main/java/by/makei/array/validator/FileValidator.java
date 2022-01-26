package by.makei.array.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;


public class FileValidator {
    private static final Logger logger = LogManager.getLogger();

    public boolean validateFile(String fileName) {
        boolean isValid;
        if (fileName == null) {
            logger.fatal("fileName is null");
            isValid = false;
        } else {
            File file = new File(fileName);
            if (file.exists() && file.length() > 0) {
                logger.log(Level.INFO, "FileName is correct");
                isValid = true;
            } else {
                logger.log(Level.ERROR, "File {} is not exist or has size 0", fileName);
                isValid = false;
            }
        }
        return isValid;
    }
}
