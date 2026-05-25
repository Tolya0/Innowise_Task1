package org.kurylin.apptask.comparator;

import org.kurylin.apptask.entity.CustomArray;
import java.util.Comparator;

public class ArrayIdComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return Integer.compare(o1.getId(), o2.getId());
    }
}
