package com.github.bucket4j.impl;

import com.github.bucket4j.Capacity;

import java.time.Duration;

public class WarmupCapacity implements Capacity {

    private final double fromValue;
    private final double toValue;
    private final long warmupNanos;

    public WarmupCapacity(long fromValue, long toValue, Duration warmupDuration) {
        this.fromValue = fromValue;
        this.toValue = toValue;
        this.warmupNanos = warmupDuration.toNanos();
    }

    @Override
    public double getInitialValue(long initializationTimeNanos) {
        return fromValue;
    }

    @Override
    public double getMaxValue(long previousAccessTimeNanos, long previousMaxValue, long currentTimeNanos) {
            double timeSinceLastRefill = currentTimeNanos - previousAccessTimeNanos;
            if (timeSinceLastRefill > warmupNanos) {
                // became cold due to was unused for a long time
                return fromValue;
            }
            if (toValue == previousMaxValue) {
                // already hot
                return toValue;
            }
            double capacityIncrement = timeSinceLastRefill * (toValue - fromValue) / warmupNanos;
            return Math.min(toValue, previousMaxValue + capacityIncrement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WarmupCapacity that = (WarmupCapacity) o;

        if (Double.compare(that.fromValue, fromValue) != 0) return false;
        if (Double.compare(that.toValue, toValue) != 0) return false;
        return warmupNanos == that.warmupNanos;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(fromValue);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(toValue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (warmupNanos ^ (warmupNanos >>> 32));
        return result;
    }

}
