package com.even.provider.service;

import com.even.Dto.URL;
import com.even.provider.service.impl.HelloSerivceImpl;
import com.even.register.RegisterCenter;

import java.util.ArrayList;
import java.util.List;


public class Provider {

    public static void main(String[] args) {
        //1.本地注册，模拟本地xml配置文件配置本地接口暴露
        LocalRegister localRegister = new LocalRegister();
        localRegister.register(HelloService.class.getName(), HelloSerivceImpl.class);

        //2.远程注册，模拟 xml配置文件进行接口远程暴露
        RegisterCenter registerCenter = new RegisterCenter();
        URL url = new URL("localhost","8080");
        registerCenter.register(HelloService.class.getName(), url);

        //3.tomcat，将服务提供方服务在服务容器中运行

    }
}
