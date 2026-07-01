package org.example.optional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class OptionalDemo {
    void main() {
        //findDuplicatNosOfArray();
        //findLengthOfEachWord();
        reversWordsEachString();

    }

    private void reversWordsEachString() {
        String str = "hello world";
        String str1 = Arrays.stream(str.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println(str1);
    }

    private void findLengthOfEachWord() {
        String str = "hello world";
        Arrays.stream(str.split(" "))
                .map(word -> word + " " + word.length())
                .forEach(System.out::println);

    }

    private void findDuplicatNosOfArray() {
        List<Number> numbers = Arrays.asList(1, 2, 3, 2, 5, 6, 1, 8, 5, 10);
        Set<Number> set = new HashSet<>();
        numbers.stream()
                .filter(no -> !set.add(no))
                .forEach(System.out::println);
    }
}
