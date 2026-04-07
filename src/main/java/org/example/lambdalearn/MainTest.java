package org.example.lambdalearn;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MainTest {

    private String instanceVar = "instance";       // instance variable
    private static String staticVar = "static";

    public static void main(String[] args) {
        // 1. Lambda expression to print a message
        Runnable printMessage = () -> System.out.println("Hello, Lambda!");
        printMessage.run();

        // 2. Lambda expression to add two numbers
        BinaryOperator<Integer> add = (a, b) -> a + b;
        int result = add.apply(5, 3);
        System.out.println("Sum: " + result);

        // 3. Lambda expression to filter a list of strings
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("Filtered Names: " + filteredNames);

        demo();
    }

    public static void demo() {
        String localVar = "local";                 // local variable
        // localVar = "changed";  ← compiler error if you do this

        // 1. Can access static variables — always
        Runnable r1 = () -> System.out.println(staticVar);

        // 2. Can access instance variables — always
        //Runnable r2 = () -> System.out.println(instanceVar);

        // 3. Can access local variables — only if effectively final
        Runnable r3 = () -> System.out.println(localVar);

        // 4. CANNOT modify local variables — compiler error
        //Runnable r4 = () -> localVar = "changed"; // ERROR

        String name = "Alice";
        //name = "balu";
        Consumer<String> greet = str -> System.out.println(name + " says: " + str);
        greet.accept("Hello!"); // Output: Alice says: Hello!
    }
}
