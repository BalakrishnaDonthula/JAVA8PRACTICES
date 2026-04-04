package org.example.java17;

public sealed class SealedTest permits SealedTestA, SealedTestB {
    public void display() {
        System.out.println("This is a sealed class.");
    }
}
