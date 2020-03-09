package com.even.provider.service.impl;

import com.even.provider.service.HelloService;

public class HelloSerivceImpl implements HelloService {
    @Override
    public String sayHello(String username) {
        System.out.println("服务方调用===" + username);
        return "调用成功";
    }
}
