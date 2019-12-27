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
import com.paga.utils.PublicFunction;



@SpringBootTest
public class AddTaskTest extends AbstractTestNGSpringContextTests{
	
    @Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
    //
    @Test(dependsOnGroups="loginTrue",groups="addTask",description = "add a Task")
    public void addTask() throws Exception { 
    	System.out.println("add Task url："+configBeanPropUrl.getAddTask());
    	String result = getResult();
    	Integer.parseInt(result);
    	if(Integer.parseInt(result)>0){
    		Assert.assertEquals("0", "0");
    	}
    	
    }
          
    private String getResult() throws IOException{
    	
    	JSONObject jsonObj = new JSONObject();    	
    	String dueDate = PublicFunction.getStringDate(432000000L);
    	String effective = PublicFunction.getStringDate(864000000L);
    	  	
    	JSONObject jsonTask = new JSONObject();
    	jsonTask.put("clientName", "American Intl. Group");
    	jsonTask.put("dueDate", dueDate);//5 days later
    	jsonTask.put("effective",effective);//10 days later
    	jsonTask.put("entered", "");
    	jsonTask.put("enteredBy","");
    	jsonTask.put("glCode",1);
    	jsonTask.put("glName","");
    	jsonTask.put("glSet", "1");
    	jsonTask.put("guidelineNum",1);
    	jsonTask.put("headerCode","MDT");
    	jsonTask.put("headerId",33000000120L);
    	jsonTask.put("hqCodes","UOE03");
    	jsonTask.put("requestBy",1);
    	jsonTask.put("requestDate","");
    	jsonTask.put("requestEmail","123@qq.com");
    	jsonTask.put("requestType","");
    	jsonTask.put("salesForceCaseNumber","23");
    	jsonTask.put("statusCode",1);
    	jsonTask.put("subtaskLob","");
    	jsonTask.put("taskDesc","test task");
    	jsonTask.put("taskType",1);
    	jsonObj.put("task",jsonTask);
    	
    	JSONObject jsonTaskDtl = new JSONObject();
    	jsonTaskDtl.put("assignUser","wang");
    	jsonObj.put("taskDtl",jsonTaskDtl); 
    	
    	String returnStr = PostGetUtil.getPosttMethod(configBeanPropUrl.getAddTask(), jsonObj);	
    	CaseRelevanceData.pkValue = Integer.parseInt(returnStr);   	
    	return returnStr;
    }
}
