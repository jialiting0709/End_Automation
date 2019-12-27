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
public class UpdatePathTest extends AbstractTestNGSpringContextTests{
    @Autowired
    ConfigBeanPropUrl configBeanPropUrl;
    
	@Test(dependsOnGroups="", groups="updatePath",description = "update Path")
	public void updatePath() throws Exception { 
		System.out.println("update path url："+configBeanPropUrl.getUpdatePath());
		String result = getResult();
		Assert.assertNotNull(result);
		Thread.sleep(3000);
		
	}
	
	private String getResult() throws IOException{
		JSONObject jsonObj = new JSONObject();		
		JSONArray criteriaGroupsArr = new JSONArray();
		JSONObject criteriaJS = new JSONObject();
		criteriaJS.put("group", 0);
		criteriaJS.put("groupType", "0");
		JSONArray criteriasArr = new JSONArray();
		JSONObject criteriasJSO = new JSONObject();
		criteriasJSO.put("condition", "is not one of");
		criteriasJSO.put("value", "aa");
//		criteriasJSO.put("criteriaCode", CaseRelevanceData.criteriaCode);
		criteriasJSO.put("criteriaCode",2);
		criteriasArr.put(criteriasJSO);
		criteriaJS.put("criterias", criteriasArr);
		criteriaGroupsArr.put(criteriaJS);
		jsonObj.put("criteriaGroups", criteriaGroupsArr);
		
		JSONObject jsonSubTaskPathVo = new JSONObject();
		jsonSubTaskPathVo.put("paglsubtaskid", CaseRelevanceData.subtaskid);
		jsonSubTaskPathVo.put("pathapprovaltext", "approvaltext");
		jsonSubTaskPathVo.put("pathinitrenewal", 1);
		jsonSubTaskPathVo.put("pathinstruction", "instructions");
		jsonSubTaskPathVo.put("pathname", "path name");
		jsonSubTaskPathVo.put("pathsummary", "summary");
		jsonSubTaskPathVo.put("pathtype", 1);
		jsonSubTaskPathVo.put("statuscode", 1);	
		jsonObj.put("pathseqnum", 1);	
		jsonObj.put("subTaskPathVo",jsonSubTaskPathVo);
		System.out.println(jsonObj.toString());
		String returnStr = PostGetUtil.getPosttMethod(configBeanPropUrl.getUpdatePath(), jsonObj);
		CaseRelevanceData.addPathId = returnStr;
		System.out.println(CaseRelevanceData.addPathId);
		return returnStr;
		  
	}

}
