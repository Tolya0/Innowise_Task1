package org.kurylin.apptask.specification;

import org.kurylin.apptask.entity.CustomArray;

@FunctionalInterface
public interface ArraySpecification {
    boolean specify(CustomArray customArray);
}
