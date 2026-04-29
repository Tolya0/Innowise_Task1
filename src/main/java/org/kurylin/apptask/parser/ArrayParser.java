package org.kurylin.apptask.parser;

import org.kurylin.apptask.exception.CustomArrayException;

public interface ArrayParser {
    int[] parseArray(String array) throws CustomArrayException;
}
