package org.kurylin.apptask.specification.impl;

import org.kurylin.apptask.entity.CustomArray;
import org.kurylin.apptask.specification.ArraySpecification;

public class NameEqualsSpecification implements ArraySpecification {
    private final String targetName;

    public NameEqualsSpecification(String targetName) {
        this.targetName = targetName;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        if (customArray == null || customArray.getName() == null) {
            return false;
        }
        return customArray.getName().equals(targetName);
    }
}
