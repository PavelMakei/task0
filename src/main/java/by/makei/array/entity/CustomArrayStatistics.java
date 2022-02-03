package by.makei.array.entity;

import java.util.Objects;

public class CustomArrayStatistics {
    private int max;
    private int min;
    private double average;

    public CustomArrayStatistics(int min, int max, double average) {
        this.max = max;
        this.min = min;
        this.average = average;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArrayStatistics that = (CustomArrayStatistics) o;
        return max == that.max && min == that.min && Double.compare(that.average, average) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(max, min, average);
    }

    @Override
    public String toString() {
        return "CustomArrayStatistics{" +
                "max=" + max +
                ", min=" + min +
                ", average=" + average +
                '}';
    }
}
