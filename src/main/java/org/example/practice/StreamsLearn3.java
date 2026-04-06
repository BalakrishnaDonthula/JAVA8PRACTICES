package org.example.practice;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class StreamsLearn3 {
    public static void main(String[] args) {
        List<Employee> employees = employeeList();
        Map<Integer, List<Employee>> byYear = employees.stream()
                .collect(Collectors.groupingBy(e ->
                        e.getJoiningDate().getYear()
                ));

        /*byYear.forEach((year, emps) -> {
            System.out.println(year + " → " + emps.stream()
                    .map(Employee::getName)
                    .collect(Collectors.joining(", ")));
        });*/

        Map<Integer, List<String>> namesByYear = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getJoiningDate().getYear(),
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ));
        // System.out.println(namesByYear);
        Map<Integer, Long> countByYear = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getJoiningDate().getYear(),
                        Collectors.counting()
                ));
        //System.out.println(countByYear);

        Map<Integer, Double> AvgSalByYear = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getJoiningDate().getYear(),
                        Collectors.averagingDouble(value -> value.getSalary())
                ));
        //System.out.println(AvgSalByYear);

        Map<Integer, Double> totalSalByYear = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getJoiningDate().getYear(),
                        Collectors.summingDouble(value -> value.getSalary())
                ));
        //System.out.println(totalSalByYear);

        Map<Integer, List<Employee>> sortedByYear = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getJoiningDate().getYear(),
                        TreeMap::new,   // keeps keys sorted
                        Collectors.toList()
                ));
        //System.out.println(sortedByYear);

        Map<Integer, Optional<Employee>> topEarnerByYear = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> e.getJoiningDate().getYear(),
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));

       /* topEarnerByYear.forEach((year, emp) ->
                System.out.println(year + " → " + emp.map(Employee::getName).orElse("None"))
        );*/

        List<Employee> sorted = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .toList();
        System.out.println(sorted);


    }

    private static List<Employee> employeeList() {
        List<Employee> employees = List.of(
                new Employee(1L, "Alice", "Engineering", 85000, LocalDate.of(2020, 3, 15)),
                new Employee(2L, "Bob", "Marketing", 62000, LocalDate.of(2020, 7, 20)),
                new Employee(3L, "Charlie", "Engineering", 91000, LocalDate.of(2021, 1, 10)),
                new Employee(4L, "Diana", "HR", 55000, LocalDate.of(2021, 6, 25)),
                new Employee(5L, "Eve", "Engineering", 78000, LocalDate.of(2022, 2, 14)),
                new Employee(6L, "Frank", "Marketing", 67000, LocalDate.of(2022, 9, 5)),
                new Employee(7L, "Grace", "HR", 59000, LocalDate.of(2023, 4, 18)),
                new Employee(8L, "Henry", "Engineering", 95000, LocalDate.of(2023, 11, 3))
        );
        return employees;
    }
}
