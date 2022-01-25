package by.makei.array.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class FileValidator {
    public static final Logger logger = LogManager.getLogger(FileValidator.class);

    public boolean validateFile(String fileName) {
        if (fileName == null) {
            logger.fatal("fileName is null");
            return false;
        }
        File file = new File(fileName);
        boolean result;
        result = (file.exists() && file.length() > 0);
        if (result) {
            logger.info("fileName is correct");
            return true;
        } else {
            logger.fatal("fileName isn't exist or has size 0");
            return false;
        }
    }
}
