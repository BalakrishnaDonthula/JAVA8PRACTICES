package org.example.java17.sealedclass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestDemo {
    public static void main(String[] args) {
        /*String str = "hello world";
        Arrays.stream(str.split(" "))
                .flatMap(str -> str.transform(s -> s.r))
                .*/
        stringWordReverse();
        //secondHighest();

    }

    private static void stringWordReverse() {
        String str = "hello world";
        String revWord = Arrays.stream(str.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println(revWord);
    }

    private static void secondHighest() {
        List<Integer> list = Arrays.asList(8, 9, 7, 6);
        list.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
