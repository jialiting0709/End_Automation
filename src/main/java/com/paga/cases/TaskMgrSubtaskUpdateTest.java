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
public class TaskMgrSubtaskUpdateTest extends AbstractTestNGSpringContextTests{
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="", groups="taskMgrSubtaskUpdate",description = "TaskMgr Subtask Update")
	public void taskMgrSubtaskUpdate() throws Exception {
		System.out.println("TaskMgr Subtask Update url："+configBeanPropUrl.getUpdateSub());
		String result = getResult();		
		Assert.assertNotNull(result);
				
		
	}
	
	 private String getResult() throws IOException{
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("enteredBy", "wang");
		jsonObj.put("glName", "111");
		jsonObj.put("glType", 123);
		jsonObj.put("id",CaseRelevanceData.pkValue);
		jsonObj.put("name", "0");
		jsonObj.put("status", 2);
		jsonObj.put("tkId", CaseRelevanceData.pkValue);
		jsonObj.put("uniqueKeyInFlow",CaseRelevanceData.taskuuid);
		String returnStr = PostGetUtil.getPosttMethod(configBeanPropUrl.getCompleteSubTask(),jsonObj);
		JSONObject jsonRest= new JSONObject(returnStr);
		return null;
	 }
	
}
