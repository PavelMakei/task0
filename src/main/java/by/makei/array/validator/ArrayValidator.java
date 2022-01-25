package by.makei.array.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayValidator {
    private static final ArrayValidator instance = new ArrayValidator();
    public static final Logger logger = LogManager.getLogger(ArrayValidator.class);

    private ArrayValidator() {
    }

    public static ArrayValidator getInstance() {
        return instance;

    }

    public boolean validateArrayBeforeService(int[] array) {

        if (array != null && array.length >= 1) {
            logger.info("Array is correct");
            return true;
        } else {
            logger.error("Array is invalid. Array is null or less then 1");
            return false;
        }
    }
}
