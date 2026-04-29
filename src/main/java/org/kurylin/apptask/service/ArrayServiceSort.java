package org.kurylin.apptask.service;

import org.kurylin.apptask.entity.CustomArray;
import org.kurylin.apptask.exception.CustomArrayException;

public interface ArrayServiceSort {
    void customSortInsertion(CustomArray array) throws CustomArrayException;
    void customSortQuick(CustomArray array) throws CustomArrayException;
}
