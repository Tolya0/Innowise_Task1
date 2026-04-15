package org.kurylin.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kurylin.entity.CustomArray;
import org.kurylin.exception.CustomArrayException;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayServiceImplTest {
    CustomArray customArray;
    ArrayServiceImpl service;

    @BeforeEach
    void setUp() {
        customArray = new CustomArray();
        service = new ArrayServiceImpl();
    }

    @Test
    void findMinPositiveTest() throws CustomArrayException {
        int[] array = {1, 2, -3, 4, -5};
        customArray.setArray(array);

        OptionalInt res = service.findMin(customArray);

        assertTrue(res.isPresent());
        assertEquals(-5, res.getAsInt());
    }

    @Test
    void findMinEmptyArrayTest() throws CustomArrayException {
        int[] array = new int[0];
        customArray.setArray(array);

        OptionalInt res = service.findMin(customArray);

        assertFalse(res.isPresent());
    }

    @Test
    void findMinNullArrayTest() throws CustomArrayException {
        assertThrows(CustomArrayException.class, () -> service.findMin(null));
    }

    @Test
    void findMaxPositiveTest() throws CustomArrayException {
        int[] array = {11, 0, -3, 40, -5};
        customArray.setArray(array);

        OptionalInt res = service.findMax(customArray);

        assertTrue(res.isPresent());
        assertEquals(40, res.getAsInt());
    }

    @Test
    void calculateSumPositiveTest() throws CustomArrayException {
        int[] array = {1, 2, -3, 4, -5};
        customArray.setArray(array);

        OptionalLong res = service.calculateSum(customArray);

        assertTrue(res.isPresent());
        assertEquals(-1, res.getAsLong());
    }

    @Test
    void calculateAveragePositiveTest() throws CustomArrayException {
        int[] array = {1, 2, -3, 4, -5};
        customArray.setArray(array);

        OptionalDouble res = service.calculateAverage(customArray);

        assertTrue(res.isPresent());
        assertEquals(-0.2, res.getAsDouble());
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
