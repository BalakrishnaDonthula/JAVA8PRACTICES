package org.example.streams.groupby;

import org.example.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GroupByTest {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 50000.0, "IT"),
                new Employee("Bob", 60000.0, "HR"),
                new Employee("Charlie", 55000.0, "OPS"),
                new Employee("Diana", 70000.0, "QA"),
                new Employee("Aarush", 70000.0, "QA")
        );

        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach((department, employees1) -> {
                            System.out.println(department);
                            employees1.forEach(System.out::println);
                        }
                );


    }
}
