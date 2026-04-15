package org.kurylin.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kurylin.exception.CustomArrayException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ArrayReader {
    private static final Logger LOGGER = LogManager.getLogger(ArrayReader.class);
    public List<String> readArray(String path) throws CustomArrayException {
        try {
            LOGGER.info("Reading array from file: " + path);
            return Files.readAllLines(Paths.get(path));
        }
        catch (IOException e) {
            LOGGER.error("Error reading file: " + path, e);
            throw new CustomArrayException("Error reading file: " + path, e);
        }
    }
}
