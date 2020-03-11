package com.even.protocol;

import com.even.Dto.Invocation;

import java.net.URISyntaxException;

public interface ProtocolIntrface {
    String send(String host, int port, Invocation invocation) throws URISyntaxException;
}
