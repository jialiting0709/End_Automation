package com.paga.cases;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.paga.config.TestConfig;

import com.paga.utils.ConfigBeanPropUrl;

import java.io.IOException;


@SpringBootTest
public class LoginTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ConfigBeanPropUrl configBeanPropUrl;

//    @Autowired
//    private H2LoginCaseRepository h2LoginCaseRepository;

    @BeforeTest(groups = "loginTrue",description = "测试准备工作,获取HttpClient对象",alwaysRun=true)
    public void beforeTest(){
        TestConfig.defaultHttpClient = HttpClients.createDefault();

    }

    @Test(groups = "loginTrue",description = "login")
    public void loginTrue() throws Exception {
//        Optional<LoginCase>  loginCaseOp = h2LoginCaseRepository.findById(1);
//        LoginCase loginCase = loginCaseOp.get();
        //发送请求,获取结果
        String actual = getResult();
        Assert.assertNotNull(actual);
    }

    private String getResult() throws IOException {
        //接口url
        System.out.println("login url："+configBeanPropUrl.getLogin());
        HttpPost post = new HttpPost(configBeanPropUrl.getLogin());
        StringEntity entity = new StringEntity("username=wang&password=1111@ssword-7&grant_type=password", ContentType.APPLICATION_JSON);
        post.addHeader("authorization", "123");
        post.setEntity(entity);
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口的响应结果："+jsonStr);
        JSONObject jsonObject = new JSONObject(jsonStr);
        String username = jsonObject.getString("username");  
        if(username != null || username.length()!= 0){
              TestConfig.username = username;
              System.out.println("TestConfig.username======="+TestConfig.username);
//              TestConfig.access_token = jsonObject.getString("access_token");
//              TestConfig.refresh_token = jsonObject.getString("refresh_token");
//              TestConfig.token_type = jsonObject.getString("token_type");
//              TestConfig.refreshToken_lifeSpan = jsonObject.getString("refreshToken_lifeSpan");
//              TestConfig.jti = jsonObject.getString("jti");

        }
        
        return username;
    }
}
