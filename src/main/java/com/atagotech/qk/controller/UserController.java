package com.atagotech.qk.controller;


import com.atagotech.qk.bean.ResponseConfig;
import com.atagotech.qk.bean.common.EmptyDataBean;
import com.atagotech.qk.bean.common.ResponseBean;
import com.atagotech.qk.bean.data.User;
import com.atagotech.qk.service.impl.UserService;
import com.atagotech.qk.utils.TextUtls;
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
    public ResponseBean login(HttpServletResponse response, HttpServletRequest request) {
        String _username = request.getParameter("username");
        String _password = request.getParameter("password");
        String checkResult = checkParams(_username, _password);

        response.addCookie(new Cookie("aa", "bb"));
        if (!TextUtls.isEmpty(checkResult)) {
            return new ResponseBean(ResponseConfig.Code.ERROR, checkResult);
        }
        User user = userService.findByUsername(_username);
        if (user == null) {

            return new ResponseBean(ResponseConfig.Code.ERROR, "无此用户");
        }
        if (_password.equals(user.getPassword())) {
            return new ResponseBean<User>(user);
        } else {
            return new ResponseBean(ResponseConfig.Code.ERROR, "密码错误");
        }
    }

    private String checkParams(String... params) {
        try {
            String _username = params[0];
            String _password = params[1];
            if (TextUtls.isEmpty(_username)) {
                return "用户名不能为空";
            }
            if (TextUtls.isEmpty(_password)) {
                return "密码不能为空";
            }
            return "";

        } catch (Exception e) {
            return "参数错误";
        }

    }


    @RequestMapping("getcookie")
    @ResponseBody
    public ResponseBean getCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = request.getCookies()[0];
        com.atagotech.qk.bean.data.Cookie cookie1 = new com.atagotech.qk.bean.data.Cookie();
        cookie1.setKey(cookie.getName());
        cookie1.setValue(cookie.getValue());
        return new ResponseBean(ResponseConfig.Code.SUCCESS, ResponseConfig.MSG.SUCCESS, cookie1);
    }


    @RequestMapping("getUser")
    @ResponseBody
    public ResponseBean getUser(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));
        return new ResponseBean<User>(userService.find(id));
    }


    @RequestMapping("addUser")
    public void addUser() {

    }


}