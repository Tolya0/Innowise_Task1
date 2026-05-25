package org.kurylin;

import org.kurylin.apptask.comparator.ArrayIdComparator;
import org.kurylin.apptask.entity.CustomArray;
import org.kurylin.apptask.entity.CustomArrayFactory;
import org.kurylin.apptask.exception.CustomArrayException;
import org.kurylin.apptask.repository.impl.ArrayRepositoryImpl;
import org.kurylin.apptask.specification.impl.SumGreaterThanSpecification;
import org.kurylin.apptask.warehouse.Warehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Starting Task 1 Part 2 Demonstration");

        try {
            CustomArray array1 = CustomArrayFactory.createCustomArray(new int[]{1, 2, 3, 4, 5}, "FirstArray");
            CustomArray array2 = CustomArrayFactory.createCustomArray(new int[]{10, 20, 30}, "SecondArray");
            CustomArray array3 = CustomArrayFactory.createCustomArray(new int[]{-5, 0, 5}, "ThirdArray");

            ArrayRepositoryImpl repository = ArrayRepositoryImpl.getInstance();

            repository.add(array1);
            repository.add(array2);
            repository.add(array3);

            LOGGER.info("Initial Warehouse Stats for ID {}: {}", array1.getId(), Warehouse.getInstance().get(array1.getId()));
            LOGGER.info("Initial Warehouse Stats for ID {}: {}", array2.getId(), Warehouse.getInstance().get(array2.getId()));
            LOGGER.info("Initial Warehouse Stats for ID {}: {}", array3.getId(), Warehouse.getInstance().get(array3.getId()));

            LOGGER.info("Querying arrays with Sum > 10...");
            List<CustomArray> queryResult = repository.query(new SumGreaterThanSpecification(10));
            for (CustomArray array : queryResult) {
                LOGGER.info("Found: {}", array);
            }

            LOGGER.info("Sorting arrays by ID...");
            List<CustomArray> sortedResult = repository.sort(new ArrayIdComparator());
            for (CustomArray array : sortedResult) {
                LOGGER.info("Sorted item: {}", array);
            }

            LOGGER.info("Mutating elements of FirstArray...");
            array1.setElement(0, 100);

            LOGGER.info("Updated Warehouse Stats for ID {}: {}", array1.getId(), Warehouse.getInstance().get(array1.getId()));

        } catch (CustomArrayException e) {
            LOGGER.error("An error occurred during demonstration", e);
        }
    }
}
