package org.kurylin.apptask.specification.impl;

import org.kurylin.apptask.entity.CustomArray;
import org.kurylin.apptask.specification.ArraySpecification;

public class IdSpecification implements ArraySpecification {
    private final int targetId;

    public IdSpecification(int targetId) {
        this.targetId = targetId;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        return customArray != null && customArray.getId() == targetId;
    }
}
