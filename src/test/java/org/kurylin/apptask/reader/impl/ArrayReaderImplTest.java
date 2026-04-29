package org.kurylin.apptask.reader.impl;

import org.junit.jupiter.api.Test;
import org.kurylin.apptask.exception.CustomArrayException;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

public class ArrayReaderImplTest {
    private static final String ARRAY_FILE_PATH = "src/test/resources/test.txt";

    @Test
    void readArrayPositiveTest() throws CustomArrayException {
        ArrayReaderImpl reader = new ArrayReaderImpl();

        List<String> res = reader.readArray(ARRAY_FILE_PATH);

        assertNotNull(res, "Result should not be null");
        assertEquals(5, res.size(), "Array should contain 5 elements");
    }

    @Test
    void readArrayNegativeTest() {
        ArrayReaderImpl reader = new ArrayReaderImpl();

        assertThrows(CustomArrayException.class, () -> reader.readArray("nonfile.txt"), "Expected CustomArrayException for non-existent file");
    }
}
