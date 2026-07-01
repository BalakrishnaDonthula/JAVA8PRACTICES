package org.example.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class TestDemo2 {
    static void main() {

        combineArraysAndSort();
        testIntStream();

    }

    private static void testIntStream() {
        IntStream.of(4, 1, 2, 5)
                .sorted()
                .forEach(System.out::println);
    }

    private static void combineArraysAndSort() {
        int[] array1 = {5, 8, 19};
        int[] array2 = {1, 3, 12, 45};

        Integer[] result = IntStream.concat(
                        Arrays.stream(array1),
                        Arrays.stream(array2))
                .boxed()
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);

        System.out.println(Arrays.toString(result));
    }
}
