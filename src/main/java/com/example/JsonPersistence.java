package com.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonPersistence implements UserPersistence {
    private String filePath;
  public JsonPersistence(String filePath) {
    this.filePath = filePath;
  }
 
    @Override
    public void saveUsers(List<User> users) {
        try (FileWriter writer = new FileWriter(filePath)) {
            Gson gson = new Gson();
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   @Override
public List<User> findUsers(String userName) {
        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            Type userListType = new TypeToken<List<User>>(){}.getType();
            List<User> users = gson.fromJson(reader, userListType);

            if (userName == null || userName.isEmpty()) {
                return users; // Return all users if no username is provided
            }

            // Filter users by username
            return users.stream()
                        .filter(user -> user.getName().equals(userName))
                        .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Handle error or return an empty list depending on your design
        }
    }
}
