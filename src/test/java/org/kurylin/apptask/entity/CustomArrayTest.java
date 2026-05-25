package org.kurylin.apptask.entity;

import org.junit.jupiter.api.Test;
import org.kurylin.apptask.exception.CustomArrayException;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayTest {

    @Test
    void testConstructorAndGetters() {
        int[] expectedArray = {1, 2, 3};
        CustomArray customArray = new CustomArray(expectedArray, "TestArray");

        assertArrayEquals(expectedArray, customArray.getArray());
        assertEquals("TestArray", customArray.getName());
        assertTrue(customArray.getId() >= 0);
    }

    @Test
    void testNullArrayProtection() {
        CustomArray customArray = new CustomArray(null, null);
        assertNotNull(customArray.getArray());
        assertEquals(0, customArray.getArray().length);
        assertEquals("", customArray.getName());
    }

    @Test
    void testSetArray() {
        CustomArray customArray = new CustomArray(new int[]{1, 2}, "Array");
        customArray.setArray(new int[]{3, 4, 5});
        assertArrayEquals(new int[]{3, 4, 5}, customArray.getArray());
    }

    @Test
    void testSetElement() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new int[]{1, 2, 3}, "Array");
        customArray.setElement(1, 10);
        assertArrayEquals(new int[]{1, 10, 3}, customArray.getArray());
    }

    @Test
    void testSetElementOutOfBounds() {
        CustomArray customArray = new CustomArray(new int[]{1, 2}, "Array");
        assertThrows(CustomArrayException.class, () -> customArray.setElement(5, 10));
    }

    @Test
    void testEqualsAndHashCode() {
        int[] arr1 = {1, 2};
        int[] arr2 = {1, 2};
        CustomArray customArray1 = new CustomArray(arr1, "Array");
        CustomArray customArray2 = new CustomArray(arr2, "Array");

        assertNotEquals(customArray1, customArray2);
        assertNotEquals(customArray1.hashCode(), customArray2.hashCode());
    }
}
