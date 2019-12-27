package com.paga.cases;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paga.config.CaseRelevanceData;
import com.paga.config.TestConfig;
import com.paga.utils.ConfigBeanPropUrl;

@SpringBootTest
public class PreviewTest extends AbstractTestNGSpringContextTests{
	 @Autowired
	    ConfigBeanPropUrl configBeanPropUrl;
	    
	    @Test(dependsOnGroups = "addPath", groups = "preview",description = "rule preview")
	    private void preview() throws IOException, InterruptedException {
	       String res = run();
	        Assert.assertNotNull(res);
	        Thread.sleep(3000);
	    }
	    private String run() throws IOException {
	        StringBuilder sb =new StringBuilder(configBeanPropUrl.getPreview());
	        sb.append("/");
	        sb.append(CaseRelevanceData.addPathId);
	        HttpGet get = new HttpGet(sb.toString());
	        System.out.println("rule preview url: "+sb.toString());
	        get.addHeader("username", TestConfig.username);
//	        get.addHeader("username","wang");
//	        get.addHeader("access_token",TestConfig.access_token);
//	        get.addHeader("refresh_token",TestConfig.refresh_token);
//	        get.addHeader("token_type",TestConfig.token_type);
//	        get.addHeader("refreshToken_lifeSpan",TestConfig.refreshToken_lifeSpan);
//	        get.addHeader("jti",TestConfig.jti);

	        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
	        String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
	        System.out.println("接口的结果："+jsonStr);
	        JSONArray ar = new JSONArray(jsonStr);
	        String rest1 = ar.getString(3);
	        String rest2 = ar.getString(4);
//	        String rest3 = ar.getString(5);
//	        String rest4 = ar.getString(6);
//	        String rest5 = ar.getString(7);
	        System.out.println(rest1);
	        System.out.println(rest2);
//	        System.out.println(rest3);
//	        System.out.println(rest4);
//	        System.out.println(rest5);
	        return jsonStr;	        

	    }
}
