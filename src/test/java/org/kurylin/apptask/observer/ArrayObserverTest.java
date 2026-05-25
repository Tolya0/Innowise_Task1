package org.kurylin.apptask.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kurylin.apptask.entity.CustomArray;
import org.kurylin.apptask.entity.CustomArrayFactory;
import org.kurylin.apptask.exception.CustomArrayException;
import org.kurylin.apptask.observer.impl.ArrayObserverImpl;
import org.kurylin.apptask.warehouse.ArrayStats;
import org.kurylin.apptask.warehouse.Warehouse;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayObserverTest {

    @BeforeEach
    void setUp() {
        Warehouse.getInstance().clear();
    }

    @Test
    void testObserverUpdatesWarehouseAutomatically() throws CustomArrayException {
        CustomArray customArray = CustomArrayFactory.createCustomArray(new int[]{1, 2, 3}, "TestArray");

        customArray.attach(ArrayObserverImpl.getInstance());
        customArray.notifyObservers();

        ArrayStats stats = Warehouse.getInstance().get(customArray.getId());
        assertNotNull(stats, "Warehouse should contain stats after notification");
        assertEquals(1, stats.getMin());
        assertEquals(3, stats.getMax());
        assertEquals(6L, stats.getSum());
        assertEquals(2.0, stats.getAverage());

        customArray.setElement(0, 10);

        stats = Warehouse.getInstance().get(customArray.getId());
        assertEquals(2, stats.getMin());
        assertEquals(10, stats.getMax());
        assertEquals(15L, stats.getSum());
        assertEquals(5.0, stats.getAverage());
    }
}
