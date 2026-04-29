package org.kurylin.apptask.service;

import org.kurylin.apptask.entity.CustomArray;
import org.kurylin.apptask.exception.CustomArrayException;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public interface ArrayService {
    OptionalInt findMin(CustomArray array) throws CustomArrayException;
    OptionalInt findMax(CustomArray array) throws CustomArrayException;
    OptionalLong calculateSum(CustomArray array) throws CustomArrayException;
    OptionalDouble calculateAverage(CustomArray array) throws CustomArrayException;
}
