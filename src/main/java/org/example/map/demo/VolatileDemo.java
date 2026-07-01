package org.example.map.demo;

public class VolatileDemo {
    private static volatile boolean testFlag = false;

    public static void main(String[] args) {
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            testFlag = true;
            System.out.println("new testFlag becomes true after sleep");
        });
        Thread readerThread = new Thread(() -> {
            while (!testFlag) {
            }
            System.out.println(" testFlag becomes true");
        });
        writerThread.start();
        readerThread.start();

    }
}
