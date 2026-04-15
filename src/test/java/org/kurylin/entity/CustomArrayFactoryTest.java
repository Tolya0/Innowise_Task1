package org.kurylin.entity;

import org.junit.jupiter.api.Test;
import org.kurylin.exception.CustomArrayException;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayFactoryTest {
    @Test
    void createCustomArrayPositiveTest() throws CustomArrayException {
        int[] array = {1, 2, -3, 4, -5};

        CustomArray customArray = CustomArrayFactory.createCustomArray(array);

        assertArrayEquals(array, customArray.getArray());
    }

    @Test
    void createCustomArrayNegativeTest() throws CustomArrayException {
        int[] array = null;

        assertThrows(CustomArrayException.class, () -> CustomArrayFactory.createCustomArray(array));
    }
}
