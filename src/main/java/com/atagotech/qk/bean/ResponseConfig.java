package com.atagotech.qk.bean;

public class ResponseConfig {
    public static final class Code {
        public static final int SUCCESS = 2;
        public static final int ERROR = -1;
        public static final int AUTH_FAIL=-401;

    }

    public static final class MSG {
        public static final String SUCCESS = "请求成功";
        public static final String AUTH_FAIL="apikey校验失败";
        public static final String LOGIN_ERROR="账号已在其他地方重新登录，被挤下线";

    }
}