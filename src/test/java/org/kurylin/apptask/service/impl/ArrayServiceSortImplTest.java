package org.kurylin.apptask.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kurylin.apptask.entity.CustomArray;
import org.kurylin.apptask.exception.CustomArrayException;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayServiceSortImplTest {

    CustomArray customArray;
    ArrayServiceSortImpl service;

    @BeforeEach
    void setUp() {
        customArray = new CustomArray();
        service = new ArrayServiceSortImpl();
    }

    @Test
    void customSortInsertionPositiveTest() throws CustomArrayException {
        int[] array = {1, 2, -3, 4, -5};
        customArray.setArray(array);

        service.customSortInsertion(customArray);

        int[] expectedArray = {-5, -3, 1, 2, 4};
        assertArrayEquals(expectedArray, customArray.getArray());
    }

    @Test
    void customSortQuickPositiveTest() throws CustomArrayException {
        int[] array = {333, -99, 23, -1, 32, -222};
        customArray.setArray(array);

        service.customSortQuick(customArray);

        int[] expectedArray = {-222, -99, -1, 23, 32, 333};
        assertArrayEquals(expectedArray, customArray.getArray());
    }
}
