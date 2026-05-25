package org.kurylin.apptask.warehouse;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static Warehouse instance;
    private final Map<Integer, ArrayStats> statsMap;

    private Warehouse() {
        statsMap = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public ArrayStats get(int id) {
        return statsMap.get(id);
    }

    public void put(int id, ArrayStats stats) {
        statsMap.put(id, stats);
    }

    public void remove(int id) {
        statsMap.remove(id);
    }

    public void clear() {
        statsMap.clear();
    }
}
