package com.atagotech.qk.controller;


import com.atagotech.qk.bean.ResponseConfig;
import com.atagotech.qk.bean.common.ResponseBean;
import com.atagotech.qk.bean.data.User;
import com.atagotech.qk.service.impl.UserService;
import com.atagotech.qk.utils.RequestUtils;
import com.atagotech.qk.utils.TextUtls;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

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

    @RequestMapping("showurl")
    @ResponseBody
    public void showurl(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String reqUrl = req.getRequestURL().toString();//得到请求的URL地址
        String reqUri = req.getRequestURI();//得到请求的资源
        String queryString = req.getQueryString();//得到请求的URL地址中附带的参数
        String remoteAddr = req.getRemoteAddr();//得到来访者的IP地址
        String remoteHost = req.getRemoteHost();
        int remotePort = req.getRemotePort();
        String remoteUser = req.getRemoteUser();
        String method = req.getMethod();//得到请求URL地址时使用的方法
        String pathInfo = req.getPathInfo();
        String localAddr = req.getLocalAddr();//获取WEB服务器的IP地址
        String localName = req.getLocalName();//获取WEB服务器的主机名


        Map<String, String[]> params = req.getParameterMap();
        String pa = "";
        Set<String> set = params.keySet();
        for (String key : set) {
            pa += "key:" + key + "----value:";
            String[] vs = params.get(key);
            for (String v : vs) {
                pa += v + "==";
            }
        }

        resp.setCharacterEncoding("UTF-8");//设置将字符以"UTF-8"编码输出到客户端浏览器
        //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        resp.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.write("获取到的客户机信息如下：");
        out.write("<br/>");
        out.write("请求的URL地址：" + reqUrl);
        out.write("<br/>");
        out.write("请求的资源：" + reqUri);
        out.write("<br/>");
        out.write("请求的URL地址中附带的参数：" + queryString);
        out.write("<br/>");
        out.write("来访者的IP地址：" + remoteAddr);
        out.write("<br/>");
        out.write("来访者的主机名：" + remoteHost);
        out.write("<br/>");
        out.write("使用的端口号：" + remotePort);
        out.write("<br/>");
        out.write("remoteUser：" + remoteUser);
        out.write("<br/>");
        out.write("请求使用的方法：" + method);
        out.write("<br/>");
        out.write("pathInfo：" + pathInfo);
        out.write("<br/>");
        out.write("localAddr：" + localAddr);
        out.write("<br/>");
        out.write("localName：" + localName);
        out.write("<br/>");
        out.write("参数" + req.getParameterMap().size() + pa);
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