package com.paga.cases;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paga.config.CaseRelevanceData;
import com.paga.config.TestConfig;
import com.paga.utils.ConfigBeanPropUrl;

@SpringBootTest
public class RuleZipTest extends AbstractTestNGSpringContextTests{
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="newSubTaskDeployedUuid", groups="ruleZip",description = "rule zip")
	private void ruleZip() throws IOException, InterruptedException {
		String result = getResult();
		Assert.assertNotNull(result);
		Thread.sleep(3000);
		
	}
	  private String getResult() throws IOException {
	        StringBuilder sb =new StringBuilder(configBeanPropUrl.getRuleZip());
	        sb.append("/");
	        sb.append(CaseRelevanceData.pkValue);
	        sb.append("/");
	        sb.append(CaseRelevanceData.subtaskid);
	        HttpGet get = new HttpGet(sb.toString());
	        System.out.println("rule zip url: "+sb.toString());
	        get.addHeader("username", TestConfig.username);
//	        get.addHeader("access_token",TestConfig.access_token);
//	        get.addHeader("refresh_token",TestConfig.refresh_token);
//	        get.addHeader("token_type",TestConfig.token_type);
//	        get.addHeader("refreshToken_lifeSpan",TestConfig.refreshToken_lifeSpan);
//	        get.addHeader("jti",TestConfig.jti);

	        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
	        String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
	        System.out.println(jsonStr);
	        return jsonStr;

	    }	
}
	

