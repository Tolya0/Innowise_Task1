package org.kurylin.validator;

import java.util.regex.Pattern;

public class ArrayValidator {
    private static final Pattern VALIDATOR_REGEX = Pattern.compile("-?\\d+(\\s*[,\\s]\\s*-?\\d+)*");
    public boolean isArrayValid(String array){
    return array != null && VALIDATOR_REGEX.matcher(array.strip()).matches();
    }
}
