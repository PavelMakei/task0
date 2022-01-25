package by.makei.array.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberValidator {
    private static final NumberValidator instance = new NumberValidator();
    public static final Logger logger = LogManager.getLogger(NumberValidator.class);
    private final String splitByTabSpase = "\\s+";

    public static NumberValidator getInstance() {
        return instance;
    }

    public boolean validateStringWithIntegers(String str) {
        String[] literals = str.strip().split(splitByTabSpase);
        return checkIfAllLiteralsInt(literals);
    }

    private boolean checkIfAllLiteralsInt(String[] literals) {
        for (String literal : literals) {
            try {
                Integer.parseInt(literal.strip());

            } catch (NumberFormatException e) {
                logger.error("literal " + literal + " can't be parsed to int",e);
                return false;
            }
        }
        return true;

    }
}
