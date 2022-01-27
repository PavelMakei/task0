package by.makei.array.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberValidatorTest {

    NumberValidator numberValidator = new NumberValidator();

    @Test
    void PositiveNumberValidatorTest() {
        String given = " 234 -34 234 543";
        assert(numberValidator.validateStringWithIntegers(given));

    }
    @Test
    void wrongValueNumberValidatorTest() {
        String given = " a234 -34 234 543";
        assertFalse(numberValidator.validateStringWithIntegers(given));
    }

    @Test
    void wrongValueDotNumberValidatorTest() {
        String given ="23.34 -34 234 543";
        assertFalse(numberValidator.validateStringWithIntegers(given));
    }

    @Test
    void maxValueLimitBrokeNumberValidatorTest() {
        String given ="23 -34 23345345987345 543";
        assertFalse(numberValidator.validateStringWithIntegers(given));
    }

    @Test
    void minValueLimitBrokeNumberValidatorTest() {
        String given ="23 -34 -23345345987345 543";
        assertFalse(numberValidator.validateStringWithIntegers(given));
    }

    @Test
    void StringIsNullNumberValidatorTest() {
        String given = null;
        assertFalse(numberValidator.validateStringWithIntegers(given));
    }

    @Test
    void StringLengthIsZeroFileValidatorTest() {
        String given = "";
        assertFalse(numberValidator.validateStringWithIntegers(given));
    }


}