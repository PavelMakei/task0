package by.makei.array.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberValidator {
    private static final NumberValidator instance = new NumberValidator();
    private static final Logger logger = LogManager.getLogger();

    public static NumberValidator getInstance() {
        return instance;
    }

    public boolean validateStringWithIntegers(String str) {
        if(str == null){
            return false;
        }
        String splitByTabSpase = "\\s+";
        String[] literals = str.strip().split(splitByTabSpase);
        return checkIfAllLiteralsInt(literals);
    }

    private boolean checkIfAllLiteralsInt(String[] literals) {
        for (String literal : literals) {
            try {
                Integer.parseInt(literal.strip());

            } catch (NumberFormatException e) {
                logger.log(Level.INFO, "literal {} can not be parsed to int", literal);
                return false;
            }
        }
        return true;

    }
}
