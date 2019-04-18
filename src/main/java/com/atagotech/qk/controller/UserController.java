package com.atagotech.qk.controller;


import com.atagotech.qk.bean.ResponseConfig;
import com.atagotech.qk.bean.common.ResponseBean;
import com.atagotech.qk.bean.data.User;
import com.atagotech.qk.service.impl.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public ResponseBean login(HttpServletRequest request) {
        String _username = request.getParameter("username");
        String _password = request.getParameter("password");

        User user = userService.findByUsername(_username);
        if (_password.equals(user.getPassword())) {
            return new ResponseBean<User>(user);
        } else {
            return new ResponseBean(ResponseConfig.Code.ERROR, "密码错误", null);
        }
    }

    @RequestMapping("showurl")
    @ResponseBody
    public ResponseBean showurl(HttpServletRequest request) {
        return new ResponseBean(ResponseConfig.Code.SUCCESS, ResponseConfig.MSG.SUCCESS, request.getRequestURL());
    }


    @RequestMapping("getUser")
    @ResponseBody
    public ResponseBean getUser(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));
        return new ResponseBean<User>(userService.find(id));
    }

    public String setCookies(HttpServletResponse response) {
        response.addCookie(new Cookie("", ""));
        return "";
    }

    @RequestMapping("addUser")
    public void addUser() {

    }


}