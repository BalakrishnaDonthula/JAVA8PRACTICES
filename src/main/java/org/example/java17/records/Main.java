package org.example.java17.records;

public class Main {
    public static void main(String[] args) {
       CreditCard payment = new CreditCard("12345", 122);
        System.out.println(payment.cardNumber());
    }
}
