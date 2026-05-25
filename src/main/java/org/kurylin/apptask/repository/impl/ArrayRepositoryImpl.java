package org.kurylin.apptask.repository.impl;

import org.kurylin.apptask.entity.CustomArray;
import org.kurylin.apptask.observer.impl.ArrayObserverImpl;
import org.kurylin.apptask.repository.ArrayRepository;
import org.kurylin.apptask.specification.ArraySpecification;
import org.kurylin.apptask.warehouse.Warehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayRepositoryImpl implements ArrayRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayRepositoryImpl.class);
    private static ArrayRepositoryImpl instance;
    private final List<CustomArray> arrays;

    private ArrayRepositoryImpl() {
        arrays = new ArrayList<>();
    }

    public static ArrayRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new ArrayRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void add(CustomArray customArray) {
        if (customArray != null && !arrays.contains(customArray)) {
            arrays.add(customArray);
            LOGGER.info("CustomArray added to repository: ID={}", customArray.getId());
            customArray.attach(ArrayObserverImpl.getInstance());
            ArrayObserverImpl.getInstance().update(customArray);
        }
    }

    @Override
    public void remove(CustomArray customArray) {
        if (customArray != null) {
            arrays.remove(customArray);
            LOGGER.info("CustomArray removed from repository: ID={}", customArray.getId());
            customArray.detach(ArrayObserverImpl.getInstance());
            Warehouse.getInstance().remove(customArray.getId());
        }
    }

    @Override
    public List<CustomArray> query(ArraySpecification specification) {
        List<CustomArray> result = new ArrayList<>();
        for (CustomArray array : arrays) {
            if (specification.specify(array)) {
                result.add(array);
            }
        }
        LOGGER.info("Query executed. Found {} matches", result.size());
        return result;
    }

    @Override
    public List<CustomArray> sort(Comparator<CustomArray> comparator) {
        List<CustomArray> sortedList = new ArrayList<>(arrays);
        sortedList.sort(comparator);
        LOGGER.info("Repository sorted using comparator: {}", comparator.getClass().getSimpleName());
        return sortedList;
    }

    public void clear() {
        arrays.clear();
    }
}
