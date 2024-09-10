package com.example;

import java.util.ArrayList;
import java.util.List;


public class UserManager  {
    
    private UserPersistence persistence;
    private List<User> users = new ArrayList<>();
    public UserManager(UserPersistence persistence) {
        this.persistence = persistence;
    }

    void addUser(User u) {
        users.add(u);
    }

    void saveUsers() {
        this.persistence.saveUsers(users);
    }

   
}
