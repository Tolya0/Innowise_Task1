package org.kurylin.apptask.parser.impl;

import org.junit.jupiter.api.Test;
import org.kurylin.apptask.exception.CustomArrayException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayParserImplTest {
    @Test
    void parseArrayPositiveTest() throws CustomArrayException {
        String array = "1, 2, -3, 4, -5";
        ArrayParserImpl parser = new ArrayParserImpl();
        int[] expected = {1, 2, -3, 4, -5};

        int[] res = parser.parseArray(array);

        assertArrayEquals(expected, res, "Arrays are equal");
    }

    @Test
    void parseArrayNegativeTest() throws CustomArrayException {
        String array = "1, a, 3v";
        ArrayParserImpl parser = new ArrayParserImpl();

        assertThrows(CustomArrayException.class, () -> parser.parseArray(array), "Expected CustomArrayException for non-numeric values");
    }

    @Test
    void parseArrayEmptyTest() throws CustomArrayException {
        String array = "";
        ArrayParserImpl parser = new ArrayParserImpl();

        assertThrows(CustomArrayException.class, () -> parser.parseArray(array), "Expected CustomArrayException for empty array");
    }
}
