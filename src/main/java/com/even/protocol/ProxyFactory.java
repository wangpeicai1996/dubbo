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
                HttpClientServer httpClient = new HttpClientServer();
                Invocation invocation = new Invocation(interfaceName.getName(),method.getName(),args,method.getParameterTypes());
                String result =  httpClient.send("localhost",8080,invocation);
                return result;
            }
        });
    }
 }
