package com.recSystem.Entity.DO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
}
