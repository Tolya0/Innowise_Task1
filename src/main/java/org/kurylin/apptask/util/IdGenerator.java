package org.kurylin.apptask.util;

public class IdGenerator {
    private static int id = 0;

    private IdGenerator() {

    }

    public static int next() {
        return id++;
    }
}
