package org.example.java17.records;

public sealed interface Payment permits CreditCard, Upi {
    double getAmount();
}
