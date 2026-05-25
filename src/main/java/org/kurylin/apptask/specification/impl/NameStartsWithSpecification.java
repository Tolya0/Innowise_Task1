package org.kurylin.apptask.specification.impl;

import org.kurylin.apptask.entity.CustomArray;
import org.kurylin.apptask.specification.ArraySpecification;

public class NameStartsWithSpecification implements ArraySpecification {
    private final String prefix;

    public NameStartsWithSpecification(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        if (customArray == null || customArray.getName() == null || prefix == null) {
            return false;
        }
        return customArray.getName().startsWith(prefix);
    }
}
