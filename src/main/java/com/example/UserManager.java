package com.example;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UserManager {
    private String filePath;

    public UserManager(String filePath) {
        this.filePath = filePath;
    }

    public void saveUsers(List<User> users) {
        try (FileWriter writer = new FileWriter(filePath)) {
            Gson gson = new Gson();
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}