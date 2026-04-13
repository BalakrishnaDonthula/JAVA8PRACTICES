package org.example.streamsexamples;

import org.example.practice.Employee;
import org.example.practice.StreamsLearn3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Example2 {
    public static void main(String[] args) {
        //getEmployeeNames();
        //sortingElemeents();
        //alphabeticalsorted();
        //salarySortEmpls();
        sumOfgivennos();
    }

    private static void sumOfgivennos() {
        List<Integer> numbers = IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList());
        System.out.println(numbers.stream()
                .mapToInt(n -> n)
                .filter(e -> e % 2 != 0)
                .sum());
    }

    private static void salarySortEmpls() {
        Optional.ofNullable(StreamsLearn3.employeeList())
                .orElse(Collections.emptyList())
                .stream().
                sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName))
                .forEach(System.out::println);
    }

    private static void alphabeticalsorted() {
        List<String> names = Arrays.asList("Charlie", "Alice", "Bob");
        names.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    private static void sortingElemeents() {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9);
        /*numbers.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);*/
        numbers.stream()
                .sorted((o1, o2) -> o2 - o1)
                .forEach(System.out::println);


    }

    private static void getEmployeeNames() {
        StreamsLearn3.employeeList()
                .stream().filter(emp -> emp.getSalary() > 90000)
                .map(Employee::getName)
                .forEach(System.out::println);
    }

}
