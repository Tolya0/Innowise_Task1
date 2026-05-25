package org.kurylin.apptask.specification.impl;

import org.kurylin.apptask.entity.CustomArray;
import org.kurylin.apptask.specification.ArraySpecification;
import org.kurylin.apptask.warehouse.ArrayStats;
import org.kurylin.apptask.warehouse.Warehouse;

public class AverageEqualsSpecification implements ArraySpecification {
    private final double targetAverage;

    public AverageEqualsSpecification(double targetAverage) {
        this.targetAverage = targetAverage;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        if (customArray == null) {
            return false;
        }
        ArrayStats stats = Warehouse.getInstance().get(customArray.getId());
        return stats != null && Double.compare(stats.getAverage(), targetAverage) == 0;
    }
}
