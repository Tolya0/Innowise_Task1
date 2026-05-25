package org.kurylin.apptask.specification.impl;

import org.kurylin.apptask.entity.CustomArray;
import org.kurylin.apptask.specification.ArraySpecification;

public class NameContainsSpecification implements ArraySpecification {
    private final String substring;

    public NameContainsSpecification(String substring) {
        this.substring = substring;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        if (customArray == null || customArray.getName() == null || substring == null) {
            return false;
        }
        return customArray.getName().contains(substring);
    }
}
