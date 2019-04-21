package com.atagotech.qk.utils;

import com.atagotech.qk.bean.common.ResponseBean;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

public class RequestUtils {
    public static ResponseBean<String> validApiKey(HttpServletRequest req){
        return new ResponseBean();
    }
//    public static String getRequestContent(HttpServletRequest request) {
//        StringBuilder builder = new StringBuilder();
//        builder.append("cookie:").append(parseCookies(request.getCookies())).append("\n");
//        builder.append("header:").append(parseHeaders(request.getHeaderNames())).append("\n");
//        builder.append("requesturi:").append(request.getRequestURI()).append("\n");
//        builder.append("params:").append(parseParams(request.getParameterNames(), request.getParameterMap())).append("\n");
//        return builder.toString();
//    }
//
//    private static String parseParams(Enumeration<String> parameterNames, Map<String, String[]> parameterMap) {
//        String params = "";
//        while (parameterNames.hasMoreElements()) {
//            String name = parameterNames.nextElement();
//            params += name + "--->" + parameterMap.get(name) + ";";
//        }
//        return params;
//    }
//
//    private static String parseHeaders(Enumeration<String> headerNames) {
//        String head = "";
//        while (headerNames.hasMoreElements()) {
//            head += headerNames.nextElement() + ",";
//        }
//        return head;
//    }
//
//    private static String parseCookies(Cookie[] cookies) {
//        String cookieString = "";
//        for (Cookie cookie : cookies) {
//            cookieString += "key-->" + cookie.getName() + ";value-->" + cookie.getValue() + ";";
//        }
//        return cookieString;
//    }
}
