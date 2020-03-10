package com.even.protocol;

import com.alibaba.fastjson.JSONObject;
import com.even.Dto.Invocation;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HttpClientServer {


    public String send(String host, int port, Invocation invocation) throws URISyntaxException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URI uri = new URI("http",null,host,port,"/",null,null);
        HttpPost post = new HttpPost(uri);
        post.setHeader("Accept","application/json");
        post.setHeader(HTTP.CONTENT_TYPE,"application/json");

        StringEntity entity = new StringEntity(JSONObject.toJSONString(invocation),"utf-8");
        post.setEntity(entity);

        try {
            HttpResponse response = httpClient.execute(post);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(response.getEntity());
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
