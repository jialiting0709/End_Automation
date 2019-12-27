package com.paga.cases;

import java.io.IOException;

import org.apache.http.client.methods.HttpPost;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paga.config.CaseRelevanceData;
import com.paga.utils.ConfigBeanPropUrl;
import com.paga.utils.PostGetUtil;
import com.paga.utils.PublicFunction;

@SpringBootTest
public class StartTaskTest extends AbstractTestNGSpringContextTests{
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="addTask", groups="startTask",description = "start a new task in workbench")
	public void startTask() throws Exception { 
		System.out.println("start task url："+configBeanPropUrl.getStartTask());
		String result = getResult();
		JSONObject jsonRes = new JSONObject(result);
		CaseRelevanceData.taskuuid  = jsonRes.getString("uuid");
		Assert.assertEquals("TaskNew", jsonRes.getString("defineKey"));
		Thread.sleep(5000);
				
	}
	
	 private String getResult() throws IOException{
		 JSONObject jsonObj = new JSONObject();
		 JSONObject selfPropsObj = new JSONObject();
		 JSONArray jsonArr = new JSONArray();
		 selfPropsObj.put("comments", jsonArr);
		 selfPropsObj.put("deadLine",PublicFunction.getStringDate(864000000L));//到期时间
		 selfPropsObj.put("owner", "wang");
		 selfPropsObj.put("pkType", "guidlineTask");
		 selfPropsObj.put("pkValue", CaseRelevanceData.pkValue);//taskId	
		 jsonObj.put("selfProps",selfPropsObj);
		 		 
		 String returnStr = PostGetUtil.getPosttMethod(configBeanPropUrl.getStartTask(), jsonObj);	 		 
		 return returnStr;
	 }
	

}
