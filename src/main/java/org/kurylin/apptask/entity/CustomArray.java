package org.kurylin.apptask.entity;

import org.kurylin.apptask.exception.CustomArrayException;
import org.kurylin.apptask.observer.ArrayObservable;
import org.kurylin.apptask.observer.ArrayObserver;
import org.kurylin.apptask.util.IdGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomArray implements ArrayObservable {
    private int[] array;
    private final int id;
    private final String name;
    private final List<ArrayObserver> observers;

    public CustomArray(int[] array, String name) {
        this.array = array != null ? array.clone() : new int[0];
        this.name = name != null ? name : "";
        this.id = IdGenerator.next();
        this.observers = new ArrayList<>();
    }

    public int[] getArray() {
        return array.clone();
    }

    public void setArray(int[] array) {
        this.array = array != null ? array.clone() : new int[0];
        notifyObservers();
    }

    public void setElement(int index, int value) throws CustomArrayException {
        if (index < 0 || index >= array.length) {
            throw new CustomArrayException("Index out of bounds: " + index);
        }
        array[index] = value;
        notifyObservers();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public void attach(ArrayObserver observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(ArrayObserver observer) {
        if (observer != null) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (ArrayObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomArray that = (CustomArray) o;
        if (id != that.id) {
            return false;
        }
        if (name != null ? !name.equals(that.name) : that.name != null) {
            return false;
        }
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        return "CustomArray{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
