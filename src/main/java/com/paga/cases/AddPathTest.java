package com.paga.cases;

import java.io.IOException;

import javax.persistence.criteria.CriteriaBuilder.Case;

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
public class AddPathTest extends AbstractTestNGSpringContextTests{
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="condition", groups="addPath",description = "add Path")
	public void addPath() throws Exception { 
		System.out.println("add path url："+configBeanPropUrl.getAddPathss());
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
		criteriasJSO.put("condition", "is not");
		criteriasJSO.put("value", "aaaa");
		criteriasJSO.put("criteriaCode", CaseRelevanceData.criteriaCode);//
//		criteriasJSO.put("criteriaCode",98);
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
		String returnStr = PostGetUtil.getPosttMethod(configBeanPropUrl.getAddPathss(), jsonObj);
		CaseRelevanceData.addPathId = returnStr;
		System.out.println(CaseRelevanceData.addPathId);
		return returnStr;
		  
	}

}
