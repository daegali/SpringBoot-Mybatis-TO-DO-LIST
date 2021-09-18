package com.sample.todo.repository;

import com.sample.todo.model.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public int login(User user) throws Exception {
        return sqlSessionTemplate.selectOne("User.login",user);
    }

}
