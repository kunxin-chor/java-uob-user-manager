package com.example;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    List<User> users = new ArrayList<User>();
    private String filePath;

    public UserManager(String filePath) {
        this.filePath = filePath;
    }

    void addUser(User u) {
        users.add(u);
    }

    public void saveUsers() {
        try (FileWriter writer = new FileWriter(filePath)) {
            Gson gson = new Gson();
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}