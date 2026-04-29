package org.kurylin.apptask.reader.impl;


import org.kurylin.apptask.reader.ArrayReader;
import org.slf4j.Logger;
import org.kurylin.apptask.exception.CustomArrayException;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ArrayReaderImpl implements ArrayReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayReaderImpl.class);
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
