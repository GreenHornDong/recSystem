package com.recSystem.Entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

@Data
public class User {
    private String username;
    @TableId(type = IdType.AUTO)
    private int userId;
    private String email;
    private Boolean authorVerified;
    private String lastLogin;
    private String password;
    private Boolean rememberMe;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
}
