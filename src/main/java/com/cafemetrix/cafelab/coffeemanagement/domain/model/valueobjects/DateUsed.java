package com.cafemetrix.cafelab.coffeemanagement.domain.model.valueobjects;

import java.time.LocalDateTime;

public class DateUsed {
    private final LocalDateTime value;

    public DateUsed(LocalDateTime value) {
        if (value == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        this.value = value;
    }

    public LocalDateTime value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DateUsed that = (DateUsed) obj;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
} 