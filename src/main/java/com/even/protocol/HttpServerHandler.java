package com.even.protocol;

import com.alibaba.fastjson.JSONObject;

import com.even.Dto.Invocation;
import com.even.provider.service.LocalRegister;
import org.apache.commons.io.IOUtils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp) throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        //请求的处理逻辑
        Invocation invocation = JSONObject.parseObject(req.getInputStream(),Invocation.class);
        String interfaceName = invocation.getInterfaceName();

        Class implClass = LocalRegister.get(interfaceName);
        Method method = implClass.getMethod(invocation.getMethodName(),invocation.getParamType());
        try {
            String result = (String) method.invoke(implClass.newInstance(),invocation.getParams());
            IOUtils.write(result,resp.getOutputStream(),"GBK");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
