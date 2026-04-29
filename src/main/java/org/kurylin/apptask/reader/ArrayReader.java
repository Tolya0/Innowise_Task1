package org.kurylin.apptask.reader;

import org.kurylin.apptask.exception.CustomArrayException;

import java.util.List;

public interface ArrayReader {
    List<String> readArray(String path) throws CustomArrayException;
}
