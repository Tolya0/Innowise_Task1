package org.kurylin.apptask.service.impl;

import org.slf4j.Logger;
import org.kurylin.apptask.service.ArrayService;
import org.kurylin.apptask.entity.CustomArray;
import org.kurylin.apptask.exception.CustomArrayException;
import org.slf4j.LoggerFactory;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;

public class ArrayServiceImpl implements ArrayService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayServiceImpl.class);
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


}
