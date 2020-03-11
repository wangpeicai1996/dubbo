package com.even.protocol;

import com.even.Dto.Invocation;
import com.even.provider.service.HelloService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static <T> T getProxy(Class interfaceName){
        return (T) Proxy.newProxyInstance(interfaceName.getClassLoader(), new Class[]{interfaceName}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //此处指定协议，可读取配置文件
                ProtocolIntrface httpClient = ProtocolFactory.getProtocol("http");

                Invocation invocation = new Invocation(interfaceName.getName(),method.getName(),args,method.getParameterTypes());

                //此处host,port信息应该从注册中心获取，然后通过负载均衡确定调用地址
                // TODO

                String result =  httpClient.send("localhost",8080,invocation);
                return result;
            }
        });
    }
 }
