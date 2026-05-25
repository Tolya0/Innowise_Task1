package org.kurylin.apptask.warehouse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WarehouseTest {
    private Warehouse warehouse;

    @BeforeEach
    void setUp() {
        warehouse = Warehouse.getInstance();
        warehouse.clear();
    }

    @Test
    void testPutAndGet() {
        ArrayStats stats = new ArrayStats(1, 10, 15L, 5.0);
        warehouse.put(101, stats);

        ArrayStats retrieved = warehouse.get(101);
        assertNotNull(retrieved);
        assertEquals(1, retrieved.getMin());
        assertEquals(10, retrieved.getMax());
        assertEquals(15L, retrieved.getSum());
        assertEquals(5.0, retrieved.getAverage());
    }

    @Test
    void testRemove() {
        ArrayStats stats = new ArrayStats(1, 10, 15L, 5.0);
        warehouse.put(102, stats);
        warehouse.remove(102);

        assertNull(warehouse.get(102));
    }
}
