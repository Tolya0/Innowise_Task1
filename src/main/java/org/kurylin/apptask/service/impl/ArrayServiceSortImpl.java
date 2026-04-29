package org.kurylin.apptask.service.impl;

import org.kurylin.apptask.entity.CustomArray;
import org.kurylin.apptask.exception.CustomArrayException;
import org.kurylin.apptask.service.ArrayServiceSort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayServiceSortImpl implements ArrayServiceSort {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayServiceSortImpl.class);
    @Override
    public void customSortInsertion(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            LOGGER.error("CustomArray is null");
            throw new CustomArrayException("CustomArray is null");
        }
        int[] array = customArray.getArray();
        if (array == null || array.length == 0) {
            LOGGER.error("Array is empty");
            return;
        }

        LOGGER.info("Starting to sort array using insertion sort " + customArray.toString());
        for (int i = 1; i < array.length; i++) {
            int cur = array[i];
            int j = i - 1;
            while (j >= 0) {
                if (array[j] > cur) {
                    array[j + 1] = array[j];
                    j--;
                }
                else {
                    break;
                }
            }
            array[j + 1] = cur;
        }
        customArray.setArray(array);
        LOGGER.info("Array sorted using insertion sort " + customArray.toString());
    }

    private int partition(int[] array, int low, int high) {
        int mid = low + (high - low) / 2;
        int pivot = array[mid];

        int t = array[mid];
        array[mid] = array[high];
        array[high] = t;

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    @Override
    public void customSortQuick(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            LOGGER.error("CustomArray is null");
            throw new CustomArrayException("CustomArray is null");
        }
        int[] array = customArray.getArray();
        if (array == null || array.length == 0) {
            LOGGER.error("Array is empty");
            return;
        }

        LOGGER.info("Starting to sort array using quick sort " + customArray.toString());
        quickSort(array, 0, array.length - 1);
        customArray.setArray(array);
        LOGGER.info("Array sorted using quick sort " + customArray.toString());
    }
}
