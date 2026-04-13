package org.example.practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountNumber {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2);
        //  out put should be 1-1,2-3,3-2,5-1,6-1,9-1
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
        }
        //System.out.println(countNumber(list));
        //System.out.println(map);
        getUniqueFirstCharOfString();
    }

    private static void getUniqueFirstCharOfString() {
        String str = "Balakrishna";

        str.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().ifPresent(System.out::println);
    }

    public static Map<Integer, Long> countNumber(List<Integer> list) {
        return list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    }
}
