package org.kurylin.service;

import org.kurylin.entity.CustomArray;
import org.kurylin.exception.CustomArrayException;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public interface ArrayService {
    OptionalInt findMin(CustomArray array) throws CustomArrayException;
    OptionalInt findMax(CustomArray array) throws CustomArrayException;
    OptionalLong calculateSum(CustomArray array) throws CustomArrayException;
    OptionalDouble calculateAverage(CustomArray array) throws CustomArrayException;
    void customSortInsertion(CustomArray array) throws CustomArrayException;
    void customSortQuick(CustomArray array) throws CustomArrayException;
}
