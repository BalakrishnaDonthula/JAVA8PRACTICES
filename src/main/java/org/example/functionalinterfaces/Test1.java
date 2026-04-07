package org.example.functionalinterfaces;

@FunctionalInterface
public interface Test1 {
    int calculate(int a, int b);  // exactly ONE abstract method

    // These are allowed — don't count as abstract
    default void log() {
        System.out.println("Calculating...");
    }

    static Test1 add() {
        return (a, b) -> a + b;
    }
}
