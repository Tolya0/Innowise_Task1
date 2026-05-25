package org.kurylin.apptask.specification.impl;

import org.kurylin.apptask.entity.CustomArray;
import org.kurylin.apptask.specification.ArraySpecification;

public class SizeLessThanSpecification implements ArraySpecification {
    private final int threshold;

    public SizeLessThanSpecification(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        return customArray != null && customArray.getArray().length < threshold;
    }
}
