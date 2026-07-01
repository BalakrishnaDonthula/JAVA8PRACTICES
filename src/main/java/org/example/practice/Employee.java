package org.example.practice;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String department;
    private double salary;
    private int age;
    private String city;

    public static List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee(1L, "Balakrishna", "IT", 120000, 35, "Hyderabad"),
                new Employee(3L, "Kiran", "IT", 150000, 38, "Hyderabad"),
                new Employee(5L, "Mahesh", "IT", 130000, 32, "Pune"),
                new Employee(8L, "Naresh", "IT", 170000, 37, "Bangalore"),
                new Employee(10L, "Ajay", "IT", 140000, 34, "Hyderabad"),

                new Employee(2L, "Ravi", "HR", 70000, 30, "Bangalore"),
                new Employee(6L, "Anil", "HR", 80000, 29, "Hyderabad"),

                new Employee(4L, "Suresh", "Finance", 90000, 40, "Chennai"),
                new Employee(7L, "Ramesh", "Finance", 110000, 45, "Mumbai"),
                new Employee(12L, "Prasad", "Finance", 115000, 42, "Mumbai"),

                new Employee(9L, "Vijay", "Admin", 60000, 28, "Chennai"),
                new Employee(11L, "Kumar", "Admin", 65000, 31, "Pune"));
    }
}
