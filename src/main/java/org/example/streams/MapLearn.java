package org.example.streams;

public class MapLearn {
    public static void main(String[] args) {
        // Map is a functional interface that takes a function as an argument and applies it to each element of the stream
        // It returns a new stream with the results of applying the function to each element

        // Example: Convert a list of strings to uppercase
        var strings = java.util.List.of("hello", "world", "java", "streams");
        var upperCaseStrings = strings.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println(upperCaseStrings); // Output: [HELLO, WORLD, JAVA, STREAMS]

        // Example: Get the length of each string in the list
        var lengths = strings.stream()
                .map(String::length)
                .toList();
        System.out.println(lengths); // Output: [5, 5, 4, 7]
    }
}
