package com.paga.cases;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paga.config.CaseRelevanceData;
import com.paga.utils.ConfigBeanPropUrl;
import com.paga.utils.PostGetUtil;

@SpringBootTest
public class CompleteSubTaskReJTest extends AbstractTestNGSpringContextTests{
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="UpdateSubTaskReJ", groups="CompleteSubTaskReJ",description = "Complete a SubTaskrej")
	public void completeSubTaskREj() throws Exception { 	
		System.out.println("complete subTask url："+configBeanPropUrl.getCompleteSubTask());
		String result = getResult();		
		Assert.assertNotNull(result);
		Thread.sleep(3000);
	}
			
	 private String getResult() throws IOException{
		 JSONObject jsonObj = new JSONObject();
		 JSONObject selfPropsObj = new JSONObject();
		 selfPropsObj.put("pkType", "guidlineSubTask");
		 selfPropsObj.put("pkValue",CaseRelevanceData.pkValue);
		 jsonObj.put("assignee", "wang");
		 jsonObj.put("dueDate", "");
		 jsonObj.put("selfProps", selfPropsObj);		 
		 jsonObj.put("uuid",CaseRelevanceData.subtaskRejuuid);
		 System.out.println(jsonObj.toString());
		 String returnStr = PostGetUtil.getPosttMethod(configBeanPropUrl.getCompleteSubTask(),jsonObj);
		 JSONObject jsonRest= new JSONObject(returnStr);
		 String uuid = jsonRest.getString("uuid");	 
		 return uuid;
	 }
}
