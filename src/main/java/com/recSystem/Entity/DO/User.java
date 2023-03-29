package com.recSystem.Entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {
    private String login;
    @TableId(type = IdType.AUTO)
    private int userId;
    private String email;
    private Boolean authorVerified;
    private String lastLogin;
    private String password;
    private Boolean rememberMe;

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }
}
