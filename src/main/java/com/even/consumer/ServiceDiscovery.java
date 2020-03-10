package com.even.consumer;

import com.even.Dto.Invocation;
import com.even.protocol.HttpClientServer;
import com.even.protocol.ProxyFactory;
import com.even.provider.service.HelloService;

import java.net.URISyntaxException;

public class ServiceDiscovery {


    public static void main(String[] args) throws URISyntaxException {
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String result = helloService.sayHello("张三");
        System.out.println("result = " + result);
    }

}
