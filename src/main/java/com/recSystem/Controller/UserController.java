package com.recSystem.Controller;

import com.recSystem.Entity.DO.User;
import com.recSystem.Entity.POJO.HttpResponse;
import com.recSystem.Service.UserServiceImpl;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("api/user")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/register")
    @Operation(summary = "注册用户")
    public HttpResponse addUser(@RequestBody User user){
        return userServiceImpl.addUser(user);
    }

    @PostMapping("/login")
    @Operation(summary = "用户登录")
    public HttpResponse loginUser(@RequestBody User user){
//        System.out.println(user.getUsername() + user.getPassword());

        return userServiceImpl.authenticateUser(user);
    }

    @PostMapping("/info")
    @Operation(summary = "获取用户信息")
    public HttpResponse getUser(@RequestHeader String authentication){
        System.out.println("cdc");
        return userServiceImpl.getUserInfo(authentication);
    }

    @PostMapping("/modify")
    @Operation(summary = "修改用户信息")
    public HttpResponse modifyUser(@RequestBody User user){
        return userServiceImpl.modifyUserInfo(user);
    }

    @PostMapping("/get_favorite")
    @Operation(summary = "获取用户收藏")
    public HttpResponse getFavorite(@RequestHeader String authentication, @RequestParam("max_length") int maxLength, @RequestParam("offset") int offset){
        return userServiceImpl.getFavorite(authentication, maxLength, offset);
    }

    @PostMapping("/logout")
    @Operation(summary = "退出登录")
    public HttpResponse userLogOut(@RequestHeader String authentication){
        return userServiceImpl.userLoginOut(authentication);
    }

    @PostMapping("/change_password")
    @Operation(summary = "修改用户信息")
    public HttpResponse modifyUserPassword(@RequestHeader String authentication, @RequestBody HashMap<String,String> map){
        return userServiceImpl.modifyUserPassword(authentication, map);
    }

    @PostMapping("/validate_username")
    @Operation(summary = "检查用户名是否可用")
    public HttpResponse validateUsername(@RequestBody HashMap<String,String> map){
        return userServiceImpl.validateUsername(map);
    }

    @PostMapping("/validate_email")
    @Operation(summary = "检查邮箱是否可用")
    public HttpResponse validateEmail(@RequestBody HashMap<String,String> map){
        return userServiceImpl.validateEmail(map);
    }

    @PostMapping("/verify_author")
    @Operation(summary = "作者认证")
    public HttpResponse validateAuthor(@RequestParam("username") String username){
        return userServiceImpl.verifyAuthor(username);
    }



}
