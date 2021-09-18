package com.sample.todo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User {

    @Id
    private int userId;

    private String userName;

    private String loginId;

    private String password;


}
