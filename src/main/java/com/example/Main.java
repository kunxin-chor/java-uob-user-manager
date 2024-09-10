package com.example;


public class Main {
    public static void main(String[] args) {
     

        UserManager userManager = new UserManager("users.json");
        userManager.addUser(new User("Jon Snow", "jonsnow@asd.com"));
        userManager.addUser(new User("Tony Stark", "tony@asd.com"));
        userManager.saveUsers();
    }
}