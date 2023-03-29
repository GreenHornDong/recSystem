package com.recSystem.Service;

import com.recSystem.Entity.DO.User;
import com.recSystem.Entity.DTO.DataDTO;
import com.recSystem.Entity.DTO.ErrorDTO;
import com.recSystem.Entity.DTO.StatusDTO;
import com.recSystem.Entity.POJO.HttpResponse;
import com.recSystem.Mapper.UserMapper;
import com.recSystem.Utils.SaltMD5Util;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
    //禁止注册待定，为啥呢
    //@Autowired
    private HttpResponse<Object, Object> httpResponse = new HttpResponse<>();

    public <T> HttpResponse<StatusDTO, Object> addUser(User user){
        String token = user.getUsername() + "," + user.getPassword();
        String expireTime = Integer.toString((int) ((System.currentTimeMillis() + 600000)/1000));
        httpResponse.setData(new DataDTO(null, token, expireTime));
        DataDTO data = (DataDTO) httpResponse.getData();


        if (user.getUsername() == null || user.getPassword() == null){
            return new HttpResponse<>(new StatusDTO(20, "用户名或密码不能为空"), null);
        }
        else if(query().eq("username", user.getUsername()).one() != null){
            return new HttpResponse<>(new StatusDTO(21, "用户名已被占用"), null);
        } else if (user.getUsername().length() >= 16 || user.getUsername().length() < 1){
            return new HttpResponse<>(new StatusDTO(22,"用户名长度应在1-16之间"), null);
        }else if (user.getPassword().length() < 8 || user.getPassword().length() > 16){
            return new HttpResponse<>(new StatusDTO(42, "密码格式错误"), null);
        }else {
            //return new HttpResponse(1, "已禁止用户注册");
            user.setPassword(SaltMD5Util.generateSaltPassword(user.getPassword()));
            save(user);
            return new HttpResponse<>(new StatusDTO(0, "注册成功"), data);
        }
    }

    public <T>HttpResponse<StatusDTO, Object> authenticateUser(User user){
            String username = user.getUsername();
            String password = user.getPassword();
            Boolean rememberMe = user.getRememberMe();
            HttpResponse<StatusDTO, String> httpResponse = new HttpResponse<>();

            // 如果账号或者密码为空,返回错误信息
            if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
                return new HttpResponse<>(new StatusDTO(3,"账号和密码都不能为空！"),null);
            }

            //查询是否存在
            User loginUser = query()
                    .eq("username", username)
                    .one();

        if (loginUser == null){
                return new HttpResponse<>(new StatusDTO(1, "用户不存在"), null);
            }

            //判断是否密码正确
            if (!StringUtils.isEmpty(loginUser.getUsername())) {
                // 获取该用户在数据库里面的加密过的密码
                String saltPassword = loginUser.getPassword();
                // 输入的密码和加密后的密码进行比较
                boolean passwordFlag = SaltMD5Util.verifySaltPassword(password, saltPassword);
                // 如果根据账号查询和校验加密密码失败,则返回错误信息
                if (!passwordFlag) {
                    return new HttpResponse<>(new StatusDTO(2, "密码错误"), null);
                }
                // 如果账号状态被禁用了
//                if (loginUser.getStatus().equals(ACCOUNT_DISABLE.getCode())) {
//                    return Result.fail("登录失败,该账号已被引用,请联系管理员！", loginUser);
//                }
                // 存在的话返回查询到的用户信息
            }

// 判断是否勾选了记住我
//            if(user.isRememberMe()) {
//                // 为了演示方便token写死，为用户名：admin的base64编码
//                String loginInfo = username+","+password;
//                Cookie userCookie=new Cookie("loginInfo",loginInfo);
//
//                userCookie.setMaxAge(-1);   //存活期为关闭浏览器cookie消失
//                userCookie.setPath("/");
//                response.addCookie(userCookie);
//            }

            //全部认证成功，返回正确代码并存入last_login时间
            String lastLogin = Integer.toString((int) System.currentTimeMillis());
            loginUser.setLastLogin(lastLogin);
            loginUser.setRememberMe(rememberMe);
            saveOrUpdate(loginUser);
            String token = loginUser.getUsername() + "," + user.getPassword();
            DataDTO data = new DataDTO(token);
            return new HttpResponse<>(new StatusDTO(0, "登录成功"), data);
    }

    public HttpResponse getUserInfo(String authentication){
        String[] s1 = authentication.split(",");
        String username = s1[0];
        User user = query().eq("username", username).one();
        return new HttpResponse<>(new StatusDTO(0, "用户信息获取成功"), user);
    }

    public HttpResponse searchUserById(int userId){
        User user = query().eq("user_id", userId).one();
        if (user == null){
            return new HttpResponse<>(new StatusDTO(1, "作者编码不存在"), null);
        }
        return new HttpResponse<>(new StatusDTO(0, "获取作者信息成功"), user);
    }

    public int searchUserByUsername(String username){
        User user = query().eq("username", username).one();
        return  user.getUserId();
    }

    public HttpResponse modifyUserInfo(User user){
        String username = user.getUsername();
        String email = user.getEmail();
        int userFlag = 0, emailFlag = 0;
        if (username.length() >= 16 || username.length() < 1){
            userFlag = 1;
        }
        if (query().eq("email", email).one() != null){
            emailFlag = 1;
        }
        if (userFlag == 1 && emailFlag == 1){
            List<ErrorDTO> errorDTOS =new ArrayList<ErrorDTO>();
            ErrorDTO error1 = new ErrorDTO("username", "用户名格式不正确");
            ErrorDTO error2 = new ErrorDTO("email", "电子邮件地址已被占用");
            errorDTOS.add(error1);
            errorDTOS.add(error2);
            return new HttpResponse<>(new StatusDTO(2, "两个字段修改失败"), new DataDTO(errorDTOS));
        }
        else if (userFlag == 1){
            List<ErrorDTO> errorDTOS =new ArrayList<ErrorDTO>();
            ErrorDTO error1 = new ErrorDTO("username", "用户名格式不正确");
            errorDTOS.add(error1);
            return new HttpResponse<>(new StatusDTO(1, "一个字段修改失败"), new DataDTO(errorDTOS));
        }else if ( emailFlag == 1){
            List<ErrorDTO> errorDTOS =new ArrayList<ErrorDTO>();
            ErrorDTO error2 = new ErrorDTO("email", "电子邮件地址已被占用");
            errorDTOS.add(error2);
            return new HttpResponse<>(new StatusDTO(1, "一个字段修改失败"), new DataDTO(errorDTOS));
        }else{
            User user1 = query()
                    .eq("username", username)
                    .one();
            user1.setEmail(user.getEmail());
            user1.setUsername(user.getUsername());
            saveOrUpdate(user1);
            return new HttpResponse<>(new StatusDTO(0, "用户信息修改成功"), null);
        }
    }


    public HttpResponse userLoginOut(String authentication){
        String[] s1 = authentication.split(",");
        String username = s1[0];
        User user = query().eq("username", username).one();
        user.setRememberMe(false);
        saveOrUpdate(user);
        return new HttpResponse<>(new StatusDTO(0, "成功退出登录"), null);
    }

    public HttpResponse modifyUserPassword(String authentication, HashMap<String, String> map){
        String oldPassword = map.get("old_password");
        String newPassword = map.get("new_password");
        String[] s1 = authentication.split(",");
        String username = s1[0];

        User user = query().eq("username", username).one();
        String saltPassword = user.getPassword();
        // 输入的密码和加密后的密码进行比较
        boolean passwordFlag = SaltMD5Util.verifySaltPassword(oldPassword, saltPassword);
        // 如果根据账号查询和校验加密密码失败,则返回错误信息
        if (!passwordFlag) {
            return new HttpResponse<>(new StatusDTO(1, "旧密码不匹配"), null);
        }
        if (newPassword.length() < 8 || newPassword.length() > 16) {
            return new HttpResponse<>(new StatusDTO(2, "新密码格式错误"), null);
        }
        user.setPassword(SaltMD5Util.generateSaltPassword(newPassword));
        saveOrUpdate(user);
        return new HttpResponse<>(new StatusDTO(0, "密码修改成功"), null);
    }

    public HttpResponse validateUsername(HashMap<String, String> map){
        String username = map.get("username");

        if (query().eq("username", username).one() != null){
            return new HttpResponse<>(new StatusDTO(1, "用户名已被占用"), null);
        }else if (username.length() >= 16 || username.length() < 1){
            return new HttpResponse<>(new StatusDTO(2, "用户名格式错误"), null);
        }else {
            return new HttpResponse<>(new StatusDTO(0, "用户名可用"), null);
        }
    }

    public HttpResponse validateEmail(HashMap<String, String> map){
        String email = map.get("email");

        if (query().eq("email", email).one() != null){
            return new HttpResponse<>(new StatusDTO(1, "电子邮件地址已被占用"), null);
        }else if (email.length() < 3){
            return new HttpResponse<>(new StatusDTO(2, "电子邮件地址格式错误"), null);
        }else {
            return new HttpResponse<>(new StatusDTO(0, "电子邮件地址可用"), null);
        }
    }

    public HttpResponse verifyAuthor(String username){
        User author = query().eq("username", username).one();
        if (author == null){
            return new HttpResponse<>(new StatusDTO(1, "数据库中无符合的作者信息"), null);
        }else if (author.getEmail() == null){
            return new HttpResponse<>(new StatusDTO(2, "缺少必要的验证信息"), null);
        }else {
            return new HttpResponse<>(new StatusDTO(0, "电子邮件地址可用"), null);
        }
    }

    public HttpResponse getFavorite(String authentication, int maxLength, int offset){
        UserToPaperImpl userToPaper = new UserToPaperImpl();
        return userToPaper.getFavorite(authentication, maxLength, offset);
    }
}
