package com.example;

public class Main {
    public static void main(String[] args) {
       
      UserManager userManager = new UserManager(new JsonPersistence("users.json"));
      userManager.addUser(new User("Jon Snow", "jonsnow@asd.com"));
      userManager.addUser(new User("Chua Kang", "pck@ggemail.com"));  
      userManager.saveUsers();
    }
}