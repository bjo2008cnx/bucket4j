package com.github.bucket4j.common.capacity;

import com.github.bucket4j.common.BucketState;
import com.github.bucket4j.common.Stateful;

import java.io.Serializable;
import java.time.Duration;

public interface Capacity extends Serializable, Stateful {

    double getCurrentValue(BucketState state, int offset, long previousAccessTimeNanos, long currentTimeNanos);

    static Capacity constant(double maxValue) {
        return new ConstantCapacity(maxValue, maxValue);
    }

    static Capacity constant(double maxValue, double initialValue) {
        return new ConstantCapacity(maxValue, initialValue);
    }

    static Capacity warmingUp(double coldValue, double hotValue, Duration warmPeriod) {
        return new WarmingUpCapacity(coldValue, hotValue, warmPeriod.toNanos(), coldValue);
    }

    static Capacity warmingUp(double coldValue, double hotValue, Duration warmPeriod, double initialValue) {
        return new WarmingUpCapacity(coldValue, hotValue, warmPeriod.toNanos(), initialValue);
    }

}
