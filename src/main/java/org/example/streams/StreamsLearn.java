package org.example.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.example.Employee;

public class StreamsLearn {
    public static void main(String[] args) {
        // Create a List of Employee objects with salary
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 50000.0,"IT"),
                new Employee("Bob", 60000.0,"HR"),
                new Employee("Charlie", 55000.0,"OPS"),
                new Employee("Diana", 70000.0,"QA"),
                new Employee("Aarush", 70000.0,"QA")
        );
        employees.stream().filter(employee -> employee.getSalary()>55000)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        //getting the employees count
        long count=employees.stream().filter(employee -> employee.getSalary()>55000).count();
        System.out.println(count);



    }


}
