package org.kurylin.apptask.observer.impl;

import org.kurylin.apptask.entity.CustomArray;
import org.kurylin.apptask.exception.CustomArrayException;
import org.kurylin.apptask.observer.ArrayObserver;
import org.kurylin.apptask.service.ArrayService;
import org.kurylin.apptask.service.impl.ArrayServiceImpl;
import org.kurylin.apptask.warehouse.ArrayStats;
import org.kurylin.apptask.warehouse.Warehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayObserverImpl implements ArrayObserver {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayObserverImpl.class);
    private static ArrayObserverImpl instance;
    private final ArrayService arrayService;

    private ArrayObserverImpl() {
        this.arrayService = new ArrayServiceImpl();
    }

    public static ArrayObserverImpl getInstance() {
        if (instance == null) {
            instance = new ArrayObserverImpl();
        }
        return instance;
    }

    @Override
    public void update(CustomArray customArray) {
        if (customArray == null) {
            LOGGER.warn("Received update with null CustomArray");
            return;
        }

        try {
            int min = arrayService.findMin(customArray).orElse(0);
            int max = arrayService.findMax(customArray).orElse(0);
            long sum = arrayService.calculateSum(customArray).orElse(0L);
            double average = arrayService.calculateAverage(customArray).orElse(0.0);

            ArrayStats stats = new ArrayStats(min, max, sum, average);
            Warehouse.getInstance().put(customArray.getId(), stats);
            LOGGER.info("Warehouse statistics updated for array ID: {} (name: {})", customArray.getId(), customArray.getName());
        } catch (CustomArrayException e) {
            LOGGER.error("Failed to calculate statistics for CustomArray ID: " + customArray.getId(), e);
        }
    }
}
