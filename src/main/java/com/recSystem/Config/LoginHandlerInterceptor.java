package com.recSystem.Config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.recSystem.Entity.DO.User;
import com.recSystem.Service.UserServiceImpl;
import com.recSystem.Utils.SaltMD5Util;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.baomidou.mybatisplus.core.toolkit.Wrappers.query;

public class LoginHandlerInterceptor  implements HandlerInterceptor {
    //@Autowired
    private UserServiceImpl userService;

    public LoginHandlerInterceptor(UserServiceImpl userService){
        this.userService=userService;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        String s = request.getHeader("Authentication");
        String[] s1 = s.split(",");
        String username = s1[0];
        String password = s1[1];
        String s2 = request.getParameter("rememberMe");

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        // 根据账号和密码查询对应的用户信息

        // User loginUser = query().eq("username",username).one();
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        User loginUser = userService.getOne(wrapper.eq("username", username));
        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }

        if (!StringUtils.isEmpty(loginUser.getUsername())) {
            if(loginUser.getRememberMe()){
                String saltPassword = loginUser.getPassword();
                boolean passwordFlag = SaltMD5Util.verifySaltPassword(password, saltPassword);
                // 如果根据账号查询和校验加密密码失败,则返回错误信息
                if (!passwordFlag) {
                    response.sendRedirect(request.getContextPath() + "/login");
                    return false;
                }
            } else{
                    response.sendRedirect(request.getContextPath() + "/login");
                    return false;
            }

        }
        return true;
    }
}
