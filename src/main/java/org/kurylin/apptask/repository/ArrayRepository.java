package org.kurylin.apptask.repository;

import org.kurylin.apptask.entity.CustomArray;
import org.kurylin.apptask.specification.ArraySpecification;

import java.util.Comparator;
import java.util.List;

public interface ArrayRepository {
    void add(CustomArray customArray);
    void remove(CustomArray customArray);
    List<CustomArray> query(ArraySpecification specification);
    List<CustomArray> sort(Comparator<CustomArray> comparator);
}
