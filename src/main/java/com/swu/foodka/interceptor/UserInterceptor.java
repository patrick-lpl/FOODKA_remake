package com.swu.foodka.interceptor;

import com.swu.foodka.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 用户登陆拦截器
public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User)request.getSession().getAttribute("user");
        if(user != null)
            return true;
        else {
            response.sendRedirect("static/userLogin.html");
            return false;
        }
    }

}
