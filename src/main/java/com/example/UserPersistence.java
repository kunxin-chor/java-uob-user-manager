package com.example;

import java.util.List;

public interface UserPersistence {

    void saveUsers(List<User> users);

    List<User> findUsers(String userName);

}