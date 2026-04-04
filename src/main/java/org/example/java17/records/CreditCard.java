package org.example.java17.records;

public record CreditCard(String cardNumber, double amount) implements Payment {
        @Override
        public double getAmount() {
            return amount;
        }
        public String getCardDetails(){
            return "Card Number: " + cardNumber + ", Amount: " + amount;
        }
}
