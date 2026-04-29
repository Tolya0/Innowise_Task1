package org.kurylin.apptask.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kurylin.apptask.exception.CustomArrayException;

public class CustomArrayFactory {
    private static final Logger LOGGER = LogManager.getLogger(CustomArrayFactory.class);
    public static CustomArray createCustomArray(int[] array) throws CustomArrayException {
        if (array != null) {
            LOGGER.info("CustomArray created successfully");
            return new CustomArray(array);
        } else {
            LOGGER.error("Array is null");
            throw new CustomArrayException("Array is null");
        }
    }
}
