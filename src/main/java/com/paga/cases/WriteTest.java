package com.paga.cases;

import com.paga.config.CaseRelevanceData;
import com.paga.config.TestConfig;
import com.paga.utils.ConfigBeanPropUrl;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@SpringBootTest
public class WriteTest extends AbstractTestNGSpringContextTests {
	
    @Autowired
    ConfigBeanPropUrl configBeanPropUrl;
    
    @Test(dependsOnGroups = "NewSubTaskReJComUUid", groups = "write",description = "write test")
    private void test() throws IOException, InterruptedException {
       String res = run();
        Assert.assertNotNull(res);
        Thread.sleep(3000);
    }
    private String run() throws IOException {
        StringBuilder sb =new StringBuilder(configBeanPropUrl.getWrite());
        sb.append("/");
        sb.append(CaseRelevanceData.pkValue);
        sb.append("/");
        sb.append(CaseRelevanceData.subtaskid);
        HttpGet get = new HttpGet(sb.toString());
        System.out.println("Test on url: "+sb.toString());
        get.addHeader("username", TestConfig.username);
//        get.addHeader("access_token",TestConfig.access_token);
//        get.addHeader("refresh_token",TestConfig.refresh_token);
//        get.addHeader("token_type",TestConfig.token_type);
//        get.addHeader("refreshToken_lifeSpan",TestConfig.refreshToken_lifeSpan);
//        get.addHeader("jti",TestConfig.jti);

        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口的结果："+jsonStr);
        return jsonStr;

    }
}
