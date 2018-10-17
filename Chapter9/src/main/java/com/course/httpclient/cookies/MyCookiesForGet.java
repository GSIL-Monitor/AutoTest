package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private ResourceBundle bound;
    //用来存储cookies信息的变量
    private CookieStore store;

    @BeforeTest
    public void beforeTest(){
        bound = ResourceBundle.getBundle("application",Locale.CHINA);
        url = bound.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
         String result;
         String uri = bound.getString("getCookies.uri");
         String testUrl = this.url + uri;

         HttpGet get = new HttpGet(testUrl);
         //HttpClient client = new DefaultHttpClient();
         DefaultHttpClient client = new DefaultHttpClient();
         HttpResponse response = client.execute(get);
         result = EntityUtils.toString(response.getEntity(),"utf-8");
         System.out.println(result);

         //获取cookies信息
        this.store = client.getCookieStore();
        List<Cookie> cookiesList = store.getCookies();

        for(Cookie cookie: cookiesList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("name:" + name +";" + "value:" + value);
        }
    }

    @Test(dependsOnMethods ={"testGetCookies"})
    public void  testGetWithCookies() throws IOException {
        String uri = bound.getString("test.get.with.cookies");
        String testUrl = this.url + uri;
        System.out.println(testUrl);
        HttpGet get = new HttpGet(testUrl);
        HttpClient client = new DefaultHttpClient();
        //设置cookies信息
        ((DefaultHttpClient) client).setCookieStore(this.store);
        HttpResponse response = client.execute(get);
        //获取响应的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode=" + statusCode);

        if(statusCode == 200){
            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }



    }
}
