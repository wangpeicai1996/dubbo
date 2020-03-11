package com.even.protocol;

public class ProtocolFactory {

    public static ProtocolIntrface getProtocol(String protocol){
        if ("http".equalsIgnoreCase(protocol)) {
            return new HttpClientServer();
        }else if ("dubbo".equalsIgnoreCase(protocol)) {
            return null;
        }
        return null;
    }

}
