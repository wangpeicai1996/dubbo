package com.even.register;

import com.even.Dto.URL;
import com.even.provider.service.LocalRegister;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegisterCenter {
    private static Map<String,List<URL>> REGIST = new HashMap<>();

    public void register(String interfaceName,URL url){
        List<URL> urls = REGIST.get(interfaceName);
        if (urls == null) {
            urls = new ArrayList<>();
        }
        urls.add(url);
        REGIST.put(interfaceName, urls);
    }

    public List<URL> get(String interfaceName){
        return REGIST.get(interfaceName);
    }

}
