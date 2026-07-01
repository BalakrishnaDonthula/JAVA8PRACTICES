package org.example.map.demo;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    // public static volatile int counter = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 1; i <= 10000; i++) {
                atomicInteger.incrementAndGet();
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
            System.out.println("volatile counter====" + atomicInteger);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
