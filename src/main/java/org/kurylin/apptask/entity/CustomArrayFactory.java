package org.kurylin.apptask.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.kurylin.apptask.exception.CustomArrayException;

public class CustomArrayFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomArrayFactory.class);
    private static int defaultNameCounter = 1;

    private CustomArrayFactory() {}

    public static CustomArray createCustomArray(int[] array, String name) throws CustomArrayException {
        if (array == null) {
            LOGGER.error("Array parameter is null");
            throw new CustomArrayException("Array parameter cannot be null");
        }
        String finalName = (name == null || name.isBlank()) ? "Array-" + (defaultNameCounter++) : name;
        CustomArray customArray = new CustomArray(array, finalName);
        LOGGER.info("CustomArray created successfully with name: {} and id: {}", finalName, customArray.getId());
        return customArray;
    }

    public static CustomArray createCustomArray(int[] array) throws CustomArrayException {
        return createCustomArray(array, null);
    }
}
