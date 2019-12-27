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
public class NewTaskDoneUUidTest extends AbstractTestNGSpringContextTests{
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="approveTaskReview", groups="newTaskDoneUUid",description = "task Done new uuid")
	public void newTaskDoneUUid() throws Exception { 
		System.out.println("approve Task review url："+configBeanPropUrl.getApproveTask());
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
	     JSONObject resObj = new JSONObject(jsonStr);
	     String newDonetaskuuid = null;
	     JSONArray arr = resObj.getJSONArray("TaskDone");	     
	     for(int i=0;i<arr.length();i++){
	    	 int taskId = arr.getJSONObject(i).getJSONObject("pk").getJSONObject("task").getInt("id");
	    	 if(taskId==CaseRelevanceData.pkValue){
	    		 newDonetaskuuid = arr.getJSONObject(i).getJSONObject("df").getString("uuid");
	    	 }else{
	    		 continue;
	    	 }
	     }
	     CaseRelevanceData.newDonetaskuuid = newDonetaskuuid;
	     System.out.println("newReviewtaskuuid的值为："+newDonetaskuuid);	     
	     return newDonetaskuuid;

	 }
	

}
