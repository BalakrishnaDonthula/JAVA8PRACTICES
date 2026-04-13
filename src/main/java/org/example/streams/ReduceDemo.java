package org.example.streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ReduceDemo {
    public static void main(String[] args) {
        // Form 1: with identity
        int sum = Stream.of(1, 2, 3, 4, 5)
                .reduce(19, Integer::sum); // 15
        System.out.println(sum);


        List<Integer> nums = List.of(1, 2, 3, 4, 5);

        // Sequential: both return Optional[1]
        Optional<Integer> integer = nums.stream().filter(n -> n > 2).findFirst();
        Optional<Integer> integer1 = nums.stream().filter(n -> n > 2).findAny();
        System.out.println(integer.get() + "  " + integer1.get());
    }
}
