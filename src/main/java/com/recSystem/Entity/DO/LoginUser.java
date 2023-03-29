package com.recSystem.Entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class LoginUser {
    private String login;
    @TableId(type = IdType.AUTO)
    private int userId;
    private String email;
    private Boolean authorVerified;
    private String lastLogin;
    private String password;
    private Boolean rememberMe;
    public LoginUser(String username, String password){
        this.login = username;
        this.password = password;
    }
}
