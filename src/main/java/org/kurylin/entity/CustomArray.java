package org.kurylin.entity;

//import java.util.Arrays;

public class CustomArray {
    private int[] array;

    public CustomArray() {
        this.array = new int[0];
    }
    public CustomArray(int[] array) {
        this.array = array.clone();
    }

    public int[] getArray() {
        return array.clone();
    }

    public void setArray(int[] array) {
        this.array = array.clone();
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
        return java.util.Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return java.util.Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return "CustomArray{" + java.util.Arrays.toString(array) + '}';
    }
}
