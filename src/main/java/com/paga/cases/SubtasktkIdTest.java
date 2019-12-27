package com.paga.cases;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paga.config.CaseRelevanceData;
import com.paga.config.TestConfig;
import com.paga.utils.ConfigBeanPropUrl;


@SpringBootTest
public class SubtasktkIdTest extends AbstractTestNGSpringContextTests{
	
    @Autowired
    ConfigBeanPropUrl configBeanPropUrl;

    @Test(dependsOnGroups="startSubtask", groups="subtasktkId",description = "subtask tkId")
	private void subtasktkId() throws IOException, InterruptedException {
		int result = getResult();
		Assert.assertNotNull(result);
		Thread.sleep(3000);
		
	}
	  private int getResult() throws IOException {
	        
	        String url = configBeanPropUrl.getSubtasktkId()+"/"+CaseRelevanceData.pkValue;
	        HttpGet get = new HttpGet(url);	        
	        System.out.println("subtask tkId url: "+url);
	        get.addHeader("username", TestConfig.username);
//	        get.addHeader("username","wang");
	        System.out.println("username====="+TestConfig.username);
	        
//	        get.addHeader("access_token",TestConfig.access_token);
//	        get.addHeader("refresh_token",TestConfig.refresh_token);
//	        get.addHeader("token_type",TestConfig.token_type);
//	        get.addHeader("refreshToken_lifeSpan",TestConfig.refreshToken_lifeSpan);
//	        get.addHeader("jti",TestConfig.jti);

	        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
	        String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
	        System.out.println("接口响应结果："+jsonStr);
	        JSONObject jsonRest= new JSONObject(jsonStr);
	        int subTaskId = jsonRest.getJSONObject("subTask").getInt("id");
	        CaseRelevanceData.subtaskid = subTaskId;
	        System.out.println("subtaskid====="+CaseRelevanceData.subtaskid);
	        return subTaskId;

	    }	

}
