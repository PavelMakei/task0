package by.makei.array.validator;

import by.makei.array.validator.impl.NumberValidatorImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;

class NumberValidatorImplTest {

    NumberValidatorImpl numberValidatorImpl = new NumberValidatorImpl();

    @Test
    void PositiveNumberValidatorTest() {
        String given = " 234 -34 234 543";
        assert (numberValidatorImpl.validateStringWithIntegers(given));

    }


    @ParameterizedTest
    @ValueSource(strings = {"23,34 -1230 453231 -12345678 77",
            " 92 2342334 35 567.5",
            "457567 234a 5675768 567 -590",
            "-12345678901 345 543"})
    public void wrongValueInStringNumberValidatorTest(String inputString) {
        assertFalse(numberValidatorImpl.validateStringWithIntegers(inputString));

    }

    @ParameterizedTest
    @NullSource
    void NullSourceNumberValidatorTest(String inputString) {
        assertFalse(numberValidatorImpl.validateStringWithIntegers(inputString));
    }

    @ParameterizedTest
    @EmptySource
    void StringLengthIsZeroFileValidatorTest(String inputString) {
        assertFalse(numberValidatorImpl.validateStringWithIntegers(inputString));
    }


}