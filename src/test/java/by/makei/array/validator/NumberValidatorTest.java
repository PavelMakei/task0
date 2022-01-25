package by.makei.array.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberValidatorTest {

    NumberValidator numberValidator = new NumberValidator();

    @Test
    void fileValidatorPositive() {
        String given = " 234 -34 234 543";
        assert(numberValidator.validateStringWithIntegers(given));
    }
    @Test
    void fileValidatorNegative1() {
        String given = " a234 -34 234 543";
        assertFalse(numberValidator.validateStringWithIntegers(given));
    }

    @Test
    void fileValidatorNegative2() {
        String given ="23.34 -34 234 543";
        assertFalse(numberValidator.validateStringWithIntegers(given));
    }
}