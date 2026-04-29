package org.kurylin.apptask.validator.impl;

import org.kurylin.apptask.validator.ArrayValidator;

import java.util.regex.Pattern;

public class ArrayValidatorImpl implements ArrayValidator {
    private static final Pattern ARRAY_VALIDATION_PATTERN = Pattern.compile("-?\\d+(\\s*[,\\s]\\s*-?\\d+)*");
    public boolean isArrayValid(String array){
    return array != null && ARRAY_VALIDATION_PATTERN.matcher(array.strip()).matches();
    }
}
