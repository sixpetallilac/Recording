package com.sky;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@SpringBootTest
public class HttpClientTest {
    @Test
    public void testGet() throws Exception {
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建请求对象（地址）
        HttpGet httpGet = new HttpGet("http://localhost:8080/user/shop/status");

        //发送请求，接受响应结果
        CloseableHttpResponse response = httpClient.execute(httpGet);

        //获取服务端返回的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("状态码：" + statusCode);
        //实体 工具包处理内容
        HttpEntity entity = response.getEntity();
        String body = EntityUtils.toString(entity);
        System.out.println("返回数据为：" + body);

        //关闭流
        response.close();
        httpClient.close();
    }

    @Test
    public void postTest() throws Exception {
        //create
        CloseableHttpClient aDefault = HttpClients.createDefault();
        //set http
        HttpPost httpPost = new HttpPost("http://localhost:8080/admin/employee/login");
        //set entity
        //gson
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("username","admin");
        jsonObject.addProperty("password","123456");
        StringEntity stringEntity = new StringEntity(jsonObject.toString());
        //编码方式、数据格式json
        stringEntity.setContentEncoding("utf-8");
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);
        //execute
        CloseableHttpResponse response = aDefault.execute(httpPost);

        //statusCode
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode:" + statusCode);
        //get status
        HttpEntity entity = response.getEntity();
        String string = EntityUtils.toString(entity);
        System.out.println(string);

        response.close();
        aDefault.close();
    }
}
