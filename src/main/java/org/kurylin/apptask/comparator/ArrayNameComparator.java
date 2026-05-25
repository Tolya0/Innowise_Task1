package org.kurylin.apptask.comparator;

import org.kurylin.apptask.entity.CustomArray;
import java.util.Comparator;

public class ArrayNameComparator implements Comparator<CustomArray> {
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
        String name1 = o1.getName();
        String name2 = o2.getName();
        if (name1 == null && name2 == null) {
            return 0;
        }
        if (name1 == null) {
            return -1;
        }
        if (name2 == null) {
            return 1;
        }
        return name1.compareTo(name2);
    }
}
