package org.kurylin.apptask.specification.impl;

import org.kurylin.apptask.entity.CustomArray;
import org.kurylin.apptask.specification.ArraySpecification;

public class SizeEqualsSpecification implements ArraySpecification {
    private final int targetSize;

    public SizeEqualsSpecification(int targetSize) {
        this.targetSize = targetSize;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        return customArray != null && customArray.getArray().length == targetSize;
    }
}
