package com.sample.todo.logic.user;

import com.sample.todo.dto.UserDto;
import com.sample.todo.mapper.UserMapper;
import com.sample.todo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public void createUser(User user) {
        userMapper.createUser(user);
    }

    public User getUserById(String LoginId) {
        User user = userMapper.getUserById(LoginId);
        return user;
    }

    public int checkId(String LoginId) {
        User user= userMapper.getUserById(LoginId);

        if(user == null) {
            return 0;
        }
        return 1;
    }

    public User loginCheck(UserDto.LoginInfo userdto) {

        User user = userMapper.getUserById(userdto.getLoginId());

        if(userdto.getPassword().equals(user.getPassword())) {
            return user;
        }else{
            return null;
        }
    }

}
