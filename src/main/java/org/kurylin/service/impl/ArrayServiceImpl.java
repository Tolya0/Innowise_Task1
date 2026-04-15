package org.kurylin.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kurylin.entity.CustomArray;
import org.kurylin.exception.CustomArrayException;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;

public class ArrayServiceImpl implements org.kurylin.service.ArrayService {
    private static final Logger LOGGER = LogManager.getLogger(ArrayServiceImpl.class);
    @Override
    public OptionalInt findMin(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            LOGGER.error("CustomArray is null");
            throw new CustomArrayException("CustomArray is null");
        }
        int[] array = customArray.getArray();
        if (array == null || array.length == 0) {
            LOGGER.error("Array is empty");
            return OptionalInt.empty();
        }

        LOGGER.info("Starting to find min value");
        return IntStream.of(array).min();
    }

    @Override
    public OptionalInt findMax(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            LOGGER.error("CustomArray is null");
            throw new CustomArrayException("CustomArray is null");
        }
        int[] array = customArray.getArray();
        if (array == null || array.length == 0) {
            LOGGER.error("Array is empty");
            return OptionalInt.empty();
        }

        LOGGER.info("Starting to find max value");
        return IntStream.of(array).max();
    }

    @Override
    public OptionalLong calculateSum(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            LOGGER.error("CustomArray is null");
            throw new CustomArrayException("CustomArray is null");
        }
        int[] array = customArray.getArray();
        if (array == null || array.length == 0) {
            LOGGER.error("Array is empty");
            return OptionalLong.empty();
        }

        LOGGER.info("Starting to calculate sum");
        return OptionalLong.of(IntStream.of(array).asLongStream().sum());
    }

    @Override
    public OptionalDouble calculateAverage(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            LOGGER.error("CustomArray is null");
            throw new CustomArrayException("CustomArray is null");
        }
        int[] array = customArray.getArray();
        if (array == null || array.length == 0) {
            LOGGER.error("Array is empty");
            return OptionalDouble.empty();
        }

        LOGGER.info("Starting to calculate average");
        return IntStream.of(array).average();
    }

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
