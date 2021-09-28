package com.sample.todo.mapper;

import com.sample.todo.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    void createUser(User user);
    User getUserById(String loginId);
}
