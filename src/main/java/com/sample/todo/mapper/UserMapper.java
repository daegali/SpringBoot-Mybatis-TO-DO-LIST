package com.sample.todo.mapper;

import com.sample.todo.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {


    void createUser(User user);
    User getUserById(String loginId);
    List<User> getUserAll = null;
    void updateUser(User user);
    void removeUserById(String userId);
}
