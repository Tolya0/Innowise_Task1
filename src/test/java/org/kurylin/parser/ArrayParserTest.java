package org.kurylin.parser;

import org.junit.jupiter.api.Test;
import org.kurylin.exception.CustomArrayException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayParserTest {
    @Test
    void parseArrayPositiveTest() throws CustomArrayException {
        String array = "1, 2, -3, 4, -5";
        ArrayParser parser = new ArrayParser();
        int[] expected = {1, 2, -3, 4, -5};

        int[] res = parser.parseArray(array);

        assertArrayEquals(expected, res, "Arrays are equal");
    }

    @Test
    void parseArrayNegativeTest() throws CustomArrayException {
        String array = "1, a, 3v";
        ArrayParser parser = new ArrayParser();

        assertThrows(CustomArrayException.class, () -> parser.parseArray(array), "Expected CustomArrayException for non-numeric values");
    }

    @Test
    void parseArrayEmptyTest() throws CustomArrayException {
        String array = "";
        ArrayParser parser = new ArrayParser();

        assertThrows(CustomArrayException.class, () -> parser.parseArray(array), "Expected CustomArrayException for empty array");
    }
}
