package com.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public void loadUsers() {
        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            Type userListType = new TypeToken<List<User>>(){}.getType();
            users = gson.fromJson(reader, userListType);
           
        } catch (IOException e) {
            e.printStackTrace();
        
        }
    }
}