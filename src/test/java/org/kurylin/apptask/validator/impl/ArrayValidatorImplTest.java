package org.kurylin.apptask.validator.impl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArrayValidatorImplTest {

    private final ArrayValidatorImpl arrayValidator = new ArrayValidatorImpl();

    @Test
    void isArrayValidPositiveTest() {
        String array = "1, 2, -3, 4, -5";

        boolean isValid = arrayValidator.isArrayValid(array);

        assertTrue(isValid, "Expected true for array: " + array);
    }

    @Test
    void isArrayValidWithSpacesPositiveTest() {
        String array = "  2  -3      -5";

        boolean isValid = arrayValidator.isArrayValid(array);

        assertTrue(isValid, "Expected true for array with space as delimiter: " + array);
    }

    @Test
    void isArrayValidNegativeTest() {
        String array = "1, a, 3v";

        boolean isValid = arrayValidator.isArrayValid(array);

        assertFalse(isValid, "Expected false for array with letters: " + array);
    }

    @Test
    void isArrayValidEmptyNegativeTest() {
        String array = "   ";

        boolean isValid = arrayValidator.isArrayValid(array);

        assertFalse(isValid, "Expected false for empty array: " + array);
    }
}
