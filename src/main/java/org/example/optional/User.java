package org.example.optional;

public record User(String userId, String userName, Integer age) {
    public User age(int newAge) {
        return new User(this.userId, this.userName, newAge);
    }
}
