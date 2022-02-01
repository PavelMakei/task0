package by.makei.array.validator.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberValidatorImpl {
    private static final NumberValidatorImpl instance = new NumberValidatorImpl();
    private static final Logger logger = LogManager.getLogger();
    private static final String REGEXP_STRING_VALIDATOR = "^\\s*-?\\d{1,10}(\\s+(-?\\d{1,10}))*\\s*$";

    public static NumberValidatorImpl getInstance() {
        return instance;
    }

    /**
     * Returns true if string consists of correct integers and spaces as
     * delimiter.
     * <p>
     * !!!Doesn't check hi and low limits for integer!!!
     *
     * @param str String
     * @return boolean
     */
    public boolean validateStringWithIntegers(String str) {
        if (str != null && str.matches(REGEXP_STRING_VALIDATOR)) {
            return true;
        } else {
            logger.log(Level.INFO, "String {} can not be parsed to int", str);
            return false;
        }
    }
}
