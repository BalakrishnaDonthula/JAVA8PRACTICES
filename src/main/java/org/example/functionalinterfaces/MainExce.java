package org.example.functionalinterfaces;

import org.example.practice.Employee;
import org.example.practice.StreamsLearn3;

import java.util.Collections;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public class MainExce {
    public static void main(String[] args) {
        Test1 add = (a, b) -> a + b;
        System.out.println(add.calculate(4, 5));  // 20

        // T = input type, R = return type
        Function<String, Integer> strLength = str -> str.length();
        System.out.println(strLength.apply("hello"));


        // Real world — transform Employee to DTOŚŚŚ
        Function<Employee, EmployeeDTO> toDTO = emp ->
                new EmployeeDTO(emp.getId(), emp.getName(), emp.getDepartment(), emp.getSalary(), emp.getJoiningDate());
        Employee employee = Optional.ofNullable(StreamsLearn3.employeeList())
                .flatMap(employees -> employees.stream().findFirst())
                .orElse(null);
        System.out.println(toDTO.apply(employee));


        // Composing functions

        Function<Integer, Integer> doubleIt = n -> n * 2;
        Function<Integer, Integer> addTen = n -> n + 10;

        // andThen — execute first, then next
        Function<Integer, Integer> doubleThenAdd = doubleIt.andThen(addTen);
        System.out.println(doubleThenAdd.apply(5));  // (5*2)+10 = 20

        // compose — execute second first, then this
        Function<Integer, Integer> addThenDouble = doubleIt.compose(addTen);
        System.out.println(addThenDouble.apply(5));  // (5+10)*2 = 30

        BiFunction<String, Integer, String> repeat =
                (str, times) -> str.repeat(times);

        System.out.println(repeat.apply("Balu ", 3));
        // Java Java Java

        IntFunction<String> intToStr = i -> "Value: " + i;
        System.out.println(intToStr.apply(5));  // Value: 5


        Predicate<Integer> isAdult = age -> age >= 18;
        System.out.println(isAdult.test(20));


    }
}
