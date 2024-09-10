package com.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
            new User("Alice", "alice@example.com"),
            new User("Bob", "bob@example.com")
        );

        UserManager userManager = new UserManager("users.json");
        userManager.saveUsers(users);
    }
}