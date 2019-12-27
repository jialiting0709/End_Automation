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
public class ApproveSubTaskReviewTest extends AbstractTestNGSpringContextTests{
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="write", groups="approveSubTask",description = "approve subTask")
	public void approveSubTask() throws Exception { 
		System.out.println("approve subTask url："+configBeanPropUrl.getApproveSubTask());
		String result = getResult();
		Assert.assertNotNull(result);
		Thread.sleep(3000);
		
	}
	
	private String getResult() throws IOException{
		JSONObject jsonObj = new JSONObject();		
		JSONArray commentsArr = new JSONArray();
		JSONObject commentsJson = new JSONObject();
		commentsJson.put("id", "");//
		commentsJson.put("tkUuid",CaseRelevanceData.subtaskid);
		commentsJson.put("message", "1111");
		commentsArr.put(commentsJson);
		
		JSONObject selfPropsJson = new JSONObject();
		selfPropsJson.put("pkType", "guidlineSubTask");
		selfPropsJson.put("pkValue", CaseRelevanceData.pkValue);
		jsonObj.put("assignee", "wang");
		jsonObj.put("comments", commentsArr);
		jsonObj.put("defineKey", "SubtaskReview");
		jsonObj.put("selfProps", selfPropsJson);
		jsonObj.put("uuid",CaseRelevanceData.subtaskRejcomuuid);
		
		String returnStr = PostGetUtil.getPosttMethod(configBeanPropUrl.getApproveSubTask(), jsonObj);	
		return returnStr;
		  
	}

}
