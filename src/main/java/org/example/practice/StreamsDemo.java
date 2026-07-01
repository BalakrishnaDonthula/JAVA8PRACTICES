package org.example.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsDemo {
    public static void main(String[] args) {
        String s = "Hello";
        s.concat("World");
        System.out.println(s);


        StringBuilder sb = new StringBuilder();
        sb.append("Balu").append(" World");

        System.out.println(sb);

        //findAllItEmps(Employee.getEmployees());
        //convertListEmpToMap(Employee.getEmployees());
        //findThreeHighestSalaries(Employee.getEmployees());
        //partitionNos();
        //commonListElements();
        //highestNo();
        //duplicateElements();
        //findFirstNonRepeatChar();
        //countTheStringChars();
    }

    private static void countTheStringChars() {
        String str = "Balakrishna";
        str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((character, aLong) -> System.out.println(character + " " + aLong));
    }

    private static void findFirstNonRepeatChar() {
        String str = "Balakrishna";
        str.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .findFirst()
                .ifPresent(System.out::println);
    }

    private static void duplicateElements() {
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8, 2, 1, 4, 6, 7);
        HashSet<Integer> hashSet = new HashSet<>();
        list2.stream()
                .filter(no -> !hashSet.add(no))
                .forEach(System.out::println);
    }

    private static void highestNo() {
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8, 2, 1);
        list2.stream().max(Integer::compareTo).ifPresent(System.out::println);
    }

    private static void commonListElements() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8, 2, 1);

        Set<Integer> set = new HashSet<>(list2);


        list1.stream()
                .filter(common -> set.contains(common))
                .forEach(System.out::println);

    }

    private static void partitionNos() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.stream()
                .collect(Collectors.partitioningBy(x -> x % 2 == 0))
                .forEach((aBoolean, integers) -> System.out.println(aBoolean + " " + integers));
    }

    private static void findThreeHighestSalaries(List<Employee> employees) {
        employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(System.out::println);
    }

    private static void convertListEmpToMap(List<Employee> employees) {
        Map<Long, Employee> employeeMap = employees.stream()
                .collect(Collectors.toMap(Employee::getId, Function.identity(), (existing, replacement) -> existing));
        employeeMap.forEach((id, employee) ->
                System.out.println(id + " -> " + employee));

    }

    private static void findAllItEmps(List<Employee> employees) {
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet()
                .stream()
                .filter(employee -> employee.getKey().equals("IT"))
                .flatMap(employee -> employee.getValue().stream())
                .filter(emp -> emp.getSalary() > 150000)
                .forEach(System.out::println);
    }

}
