package org.kurylin.apptask.specification.impl;

import org.kurylin.apptask.entity.CustomArray;
import org.kurylin.apptask.specification.ArraySpecification;
import org.kurylin.apptask.warehouse.ArrayStats;
import org.kurylin.apptask.warehouse.Warehouse;

public class SumGreaterThanSpecification implements ArraySpecification {
    private final long threshold;

    public SumGreaterThanSpecification(long threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        if (customArray == null) {
            return false;
        }
        ArrayStats stats = Warehouse.getInstance().get(customArray.getId());
        return stats != null && stats.getSum() > threshold;
    }
}
