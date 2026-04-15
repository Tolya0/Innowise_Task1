package org.kurylin.reader;

import org.junit.jupiter.api.Test;
import org.kurylin.exception.CustomArrayException;
import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

public class ArrayReaderTest {
    private static final String ARRAY_FILE_PATH = "src/test/resources/test.txt";

    @Test
    void readArrayPositiveTest() throws CustomArrayException {
        ArrayReader reader = new ArrayReader();

        List<String> res = reader.readArray(ARRAY_FILE_PATH);

        assertNotNull(res, "Result should not be null");
        assertEquals(5, res.size(), "Array should contain 5 elements");
    }

    @Test
    void readArrayNegativeTest() {
        ArrayReader reader = new ArrayReader();

        assertThrows(CustomArrayException.class, () -> reader.readArray("nonfile.txt"), "Expected CustomArrayException for non-existent file");
    }
}
