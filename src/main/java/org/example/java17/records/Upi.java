package org.example.java17.records;

public record Upi() implements Payment {
    @Override
    public double getAmount() {
        return 0;
    }
}
