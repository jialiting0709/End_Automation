package com.paga.cases;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
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
public class NewSubTaskDeployedUUidTest extends AbstractTestNGSpringContextTests{

	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="approveSubTask", groups="newSubTaskDeployedUuid",description = "new SubTask uuid")	
	public void newSubTaskDeployedUuid() throws Exception { 	
		System.out.println("taskFlow task url："+configBeanPropUrl.getNewSubTaskuuid());
		String result = getResult();		
		Assert.assertNotNull(result);
		Thread.sleep(3000);
	}
	
	 private String getResult() throws IOException{
		 
		 HttpGet get = new HttpGet(configBeanPropUrl.getNewSubTaskuuid());
		 get.addHeader("username", TestConfig.username);		 
		 HttpResponse response = TestConfig.defaultHttpClient.execute(get);
	     String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");

	     System.out.println("接口的结果："+jsonStr);
	     System.out.println("subtaskid==========="+CaseRelevanceData.subtaskid);
	     JSONObject resObj = new JSONObject(jsonStr);
	     String newSubTaskDeployedUuid = null;
	     JSONArray arr = resObj.getJSONArray("SubtaskDone");	     
	     for(int i=0;i<arr.length();i++){
	    	 int subTaskId = arr.getJSONObject(i).getJSONObject("pk").getJSONObject("subTask").getInt("id");
	    	 if(subTaskId==CaseRelevanceData.subtaskid){
	    		 newSubTaskDeployedUuid = arr.getJSONObject(i).getJSONObject("df").getString("uuid");
	    	 }else{
	    		 continue;
	    	 }
	     }
	     CaseRelevanceData.newSubTaskDeployedUuid = newSubTaskDeployedUuid;
	     System.out.println("subtaskuuid的值为："+newSubTaskDeployedUuid);	     
	     return newSubTaskDeployedUuid;

	 }
}
