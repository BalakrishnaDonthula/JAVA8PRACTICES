package org.example.lambdalearn;

public class ThisDemo {
    private String name = "OuterClass";

    public void demo() {

        // Anonymous class — THIS refers to anonymous class instance
        Runnable anon = new Runnable() {
            private String name = "AnonymousClass";

            @Override
            public void run() {
                System.out.println(this.name);  // AnonymousClass
            }
        };

        // Lambda — THIS refers to enclosing class instance
        Runnable lambda = () -> {
            System.out.println(this.name);  // OuterClass
        };
    }

    public static void main(String[] args) {
        ThisDemo demo = new ThisDemo();
        demo.demo();
        Runnable r = () -> System.out.println("Lambda");
        System.out.println(r.getClass().getName());
    }

}
