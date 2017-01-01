package com.github.bucket4j.common;


import com.github.bucket4j.common.capacity.Capacity;
import com.github.bucket4j.common.refill.Refill;

import java.io.Serializable;
import java.text.MessageFormat;

public class Bandwidth implements Serializable {

    private final Capacity capacity;
    private final int capacityOffset;
    private final Refill refill;
    private final int refillOffset;
    private final double initialValue;

    public Bandwidth(Capacity capacity, int capacityOffset, Refill refill, int refillOffset, double initialValue) {
        this.capacity = capacity;
        this.capacityOffset = capacityOffset;
        this.refill = refill;
        this.refillOffset = refillOffset;
        if (initialValue < 0) {
            String pattern = "{0} is wrong value for initialValue, because initial initialValue should be >= 0";
            String msg = MessageFormat.format(pattern, initialValue);
            throw new IllegalArgumentException(msg);
        }
        this.initialValue = initialValue;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public int getCapacityOffset() {
        return capacityOffset;
    }

    public int getRefillOffset() {
        return refillOffset;
    }

    public Refill getRefill() {
        return refill;
    }

    public double getInitialCapacity() {
        return initialValue;
    }

}
