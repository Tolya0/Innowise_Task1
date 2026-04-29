package org.kurylin.apptask.parser.impl;


import org.kurylin.apptask.parser.ArrayParser;
import org.slf4j.Logger;
import org.kurylin.apptask.exception.CustomArrayException;
import org.slf4j.LoggerFactory;
import java.util.regex.Pattern;

public class ArrayParserImpl implements ArrayParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayParserImpl.class);
    private static final Pattern ARRAY_DELIMITER_PATTERN = Pattern.compile("[,\\s]+");
    public int[] parseArray(String array) throws CustomArrayException {
        if (array.isBlank()) {
            LOGGER.error("Array is empty");
            throw new CustomArrayException("Array is empty");
        }
        String[] nums = ARRAY_DELIMITER_PATTERN.split(array.strip());
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
