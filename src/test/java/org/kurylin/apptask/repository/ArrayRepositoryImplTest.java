package org.kurylin.apptask.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kurylin.apptask.comparator.ArrayFirstElementComparator;
import org.kurylin.apptask.comparator.ArrayIdComparator;
import org.kurylin.apptask.comparator.ArrayNameComparator;
import org.kurylin.apptask.comparator.ArraySizeComparator;
import org.kurylin.apptask.entity.CustomArray;
import org.kurylin.apptask.entity.CustomArrayFactory;
import org.kurylin.apptask.exception.CustomArrayException;
import org.kurylin.apptask.repository.impl.ArrayRepositoryImpl;
import org.kurylin.apptask.specification.impl.*;
import org.kurylin.apptask.warehouse.Warehouse;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayRepositoryImplTest {
    private ArrayRepositoryImpl repository;

    @BeforeEach
    void setUp() {
        repository = ArrayRepositoryImpl.getInstance();
        repository.clear();
        Warehouse.getInstance().clear();
    }

    @Test
    void testAddAndRemove() throws CustomArrayException {
        CustomArray array = CustomArrayFactory.createCustomArray(new int[]{1, 2}, "Array1");
        repository.add(array);

        List<CustomArray> result = repository.query(new IdSpecification(array.getId()));
        assertEquals(1, result.size());
        assertEquals(array, result.get(0));

        assertNotNull(Warehouse.getInstance().get(array.getId()));

        repository.remove(array);
        result = repository.query(new IdSpecification(array.getId()));
        assertEquals(0, result.size());

        assertNull(Warehouse.getInstance().get(array.getId()));
    }

    @Test
    void testQueries() throws CustomArrayException {
        CustomArray array1 = CustomArrayFactory.createCustomArray(new int[]{1, 2, 3}, "Alpha");
        CustomArray array2 = CustomArrayFactory.createCustomArray(new int[]{10, 20}, "Beta");
        CustomArray array3 = CustomArrayFactory.createCustomArray(new int[]{-5, -10}, "Gamma");

        repository.add(array1);
        repository.add(array2);
        repository.add(array3);

        List<CustomArray> sumQuery = repository.query(new SumGreaterThanSpecification(10));
        assertEquals(1, sumQuery.size());
        assertEquals(array2, sumQuery.get(0));

        List<CustomArray> nameQuery = repository.query(new NameStartsWithSpecification("Al"));
        assertEquals(1, nameQuery.size());
        assertEquals(array1, nameQuery.get(0));

        List<CustomArray> sizeQuery = repository.query(new SizeEqualsSpecification(2));
        assertEquals(2, sizeQuery.size());
        assertTrue(sizeQuery.contains(array2));
        assertTrue(sizeQuery.contains(array3));

        List<CustomArray> minQuery = repository.query(new MinLessThanSpecification(0));
        assertEquals(1, minQuery.size());
        assertEquals(array3, minQuery.get(0));
    }

    @Test
    void testSorting() throws CustomArrayException {
        CustomArray array1 = CustomArrayFactory.createCustomArray(new int[]{5, 6}, "Zeta");
        CustomArray array2 = CustomArrayFactory.createCustomArray(new int[]{1, 2, 3, 4}, "Beta");
        CustomArray array3 = CustomArrayFactory.createCustomArray(new int[]{10}, "Delta");

        repository.add(array1);
        repository.add(array2);
        repository.add(array3);

        List<CustomArray> sortedByName = repository.sort(new ArrayNameComparator());
        assertEquals("Beta", sortedByName.get(0).getName());
        assertEquals("Delta", sortedByName.get(1).getName());
        assertEquals("Zeta", sortedByName.get(2).getName());

        List<CustomArray> sortedBySize = repository.sort(new ArraySizeComparator());
        assertEquals(1, sortedBySize.get(0).getArray().length);
        assertEquals(2, sortedBySize.get(1).getArray().length);
        assertEquals(4, sortedBySize.get(2).getArray().length);

        List<CustomArray> sortedByFirst = repository.sort(new ArrayFirstElementComparator());
        assertEquals(1, sortedByFirst.get(0).getArray()[0]);
        assertEquals(5, sortedByFirst.get(1).getArray()[0]);
        assertEquals(10, sortedByFirst.get(2).getArray()[0]);
    }
}
