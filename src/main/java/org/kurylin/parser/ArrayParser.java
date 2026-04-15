package org.kurylin.parser;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kurylin.exception.CustomArrayException;

import java.util.regex.Pattern;

public class ArrayParser {
    private static final Pattern DELIMITER_REGEX = Pattern.compile("[,\\s]+");
    private static final Logger LOGGER = LogManager.getLogger(ArrayParser.class);
    public int[] parseArray(String array) throws CustomArrayException {
        if (array.isBlank()) {
            LOGGER.error("Array is empty");
            throw new CustomArrayException("Array is empty");
        }
        String[] nums = DELIMITER_REGEX.split(array.strip());
        int[] result = new int[nums.length];
        try {
            LOGGER.info("Starting to parse array: [" + array + "]");
            for (int i = 0; i < nums.length; i++) {
                result[i] = Integer.parseInt(nums[i].strip());
            }
        }
        catch (NumberFormatException e) {
            LOGGER.error("Array contains non-numeric values", e);
            throw new CustomArrayException("Array contains non-numeric values", e);
        }
        return result;
    }
}
