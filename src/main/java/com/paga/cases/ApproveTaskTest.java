package com.paga.cases;

import java.io.IOException;

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

@SpringBootTest
public class ApproveTaskTest extends AbstractTestNGSpringContextTests{
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="newTaskReviewUUid", groups="approveTaskReview",description = " approve task review")
	public void approveSubTask() throws Exception { 
		System.out.println("approve Task review url："+configBeanPropUrl.getApproveTask());
		String result = getResult();
		Assert.assertNotNull(result);
		Thread.sleep(3000);
		
	}
	
	private String getResult() throws IOException{
		
		JSONObject jsonObj = new JSONObject();		
		JSONArray commentsArr = new JSONArray();
		JSONObject commentsJson = new JSONObject();
		commentsJson.put("id", "");
		commentsJson.put("tkUuid",CaseRelevanceData.newReviewtaskuuid);
		commentsJson.put("message", "1111");
		commentsArr.put(commentsJson);
		
		JSONObject selfPropsJson = new JSONObject();
		selfPropsJson.put("deadLine", JSONObject.NULL);
		selfPropsJson.put("owner", JSONObject.NULL);
		selfPropsJson.put("pkType", "guidlineTask");
		selfPropsJson.put("pkValue", CaseRelevanceData.pkValue);
		jsonObj.put("assignee", "wang");
		jsonObj.put("comments", commentsArr);
		jsonObj.put("defineKey", "TaskReview");
		jsonObj.put("dueDate",JSONObject.NULL);
		jsonObj.put("selfProps", selfPropsJson);
		jsonObj.put("uuid",CaseRelevanceData.newReviewtaskuuid);
		System.out.println(jsonObj.toString());
		
		String returnStr = PostGetUtil.getPosttMethod(configBeanPropUrl.getApproveTask(),jsonObj);	
		return returnStr;
		  
	}

}
