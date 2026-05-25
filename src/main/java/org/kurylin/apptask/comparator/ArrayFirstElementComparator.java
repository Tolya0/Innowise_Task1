package org.kurylin.apptask.comparator;

import org.kurylin.apptask.entity.CustomArray;
import java.util.Comparator;

public class ArrayFirstElementComparator implements Comparator<CustomArray> {
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
        int[] a1 = o1.getArray();
        int[] a2 = o2.getArray();
        if (a1.length == 0 && a2.length == 0) {
            return 0;
        }
        if (a1.length == 0) {
            return -1;
        }
        if (a2.length == 0) {
            return 1;
        }
        return Integer.compare(a1[0], a2[0]);
    }
}
