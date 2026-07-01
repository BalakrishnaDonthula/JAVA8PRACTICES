package org.example.optional;

import org.example.practice.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestDemo1 {
    static void main() {
        //uniqueFirstChar();
        //findAnyTest();
        //rotateArrayElmentsByNo();
        //getEmployeMaxSalaryOfEachDept();
        givenStringPalindromPossibility();

    }

    private static void givenStringPalindromPossibility() {
        String str = "careracc";

        long oddCount = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream().filter(count -> count.getValue() % 2 != 0).count();

        /*long oddCount = frequency.values()
                .stream()
                .filter(count -> count % 2 != 0)
                .count();*/

        System.out.println(oddCount <= 1);


    }

    private static void getEmployeMaxSalaryOfEachDept() {
        Employee.getEmployees().stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment(), Collectors.maxBy(Comparator.comparing(employee -> employee.getSalary()))))
                .entrySet().stream()
                .forEach(employee -> System.out.println("dept   " + employee.getKey() + "    " + employee.getValue()));
    }

    private static void rotateArrayElmentsByNo() {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 6;
        int n = arr.length;

        List<Integer> rotated = IntStream.range(0, n)
                .mapToObj(i -> arr[(i - k + n) % n])
                .collect(Collectors.toList());

        System.out.println(rotated);

    }

    private static void findAnyTest() {
        List<String> list = Arrays.asList("balu", "test");
        list.stream()
                .filter(x -> x.startsWith("b"))
                .findAny()
                .ifPresent(System.out::println);

    }

    private static void uniqueFirstChar() {
        String str = "Java is a beautiful langauage";
        str.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(word -> word.getValue() == 1)
                .findFirst()
                .ifPresent(word -> System.out.println(word.getKey()));
    }
}
