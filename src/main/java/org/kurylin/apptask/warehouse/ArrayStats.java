package org.kurylin.apptask.warehouse;

public class ArrayStats {
    private int min;
    private int max;
    private long sum;
    private double average;

    public ArrayStats(int min, int max, long sum, double average) {
        this.min = min;
        this.max = max;
        this.sum = sum;
        this.average = average;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArrayStats that = (ArrayStats) o;
        if (min != that.min) {
            return false;
        }
        if (max != that.max) {
            return false;
        }
        if (sum != that.sum) {
            return false;
        }
        return Double.compare(that.average, average) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = min;
        result = 31 * result + max;
        result = 31 * result + (int) (sum ^ (sum >>> 32));
        temp = Double.doubleToLongBits(average);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "ArrayStats{" +
                "min=" + min +
                ", max=" + max +
                ", sum=" + sum +
                ", average=" + average +
                '}';
    }
}
