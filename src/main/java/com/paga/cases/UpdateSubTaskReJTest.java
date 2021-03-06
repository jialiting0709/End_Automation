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
public class UpdateSubTaskReJTest extends AbstractTestNGSpringContextTests{
	 @Autowired
	 ConfigBeanPropUrl configBeanPropUrl;
	 @Test(dependsOnGroups="NewSubTaskReJUUid", groups="UpdateSubTaskReJ",description = "update SubTaskRej")

	 private void test() throws IOException, InterruptedException {
		 System.out.println("update SubTask url:"+configBeanPropUrl.getUpdateSub());
	     String res = getresult();
	     Assert.assertNotNull(res);
	     Thread.sleep(2000);

	    }
	 
	 private String getresult() throws IOException {
	     JSONObject jsonObject = new JSONObject();
	     jsonObject.put("enteredBy","");//
	     jsonObject.put("glName","qqq");
	     jsonObject.put("glType",1);
	     jsonObject.put("id",1);//
	     jsonObject.put("name","0");
	     jsonObject.put("status",2);//
	     jsonObject.put("tkId",CaseRelevanceData.pkValue);
	     jsonObject.put("uniqueKeyInFlow",CaseRelevanceData.subtaskRejuuid);
	     System.out.println(jsonObject.toString());
	     String result = PostGetUtil.getPosttMethod(configBeanPropUrl.getUpdateSub(),jsonObject);
	     return result;
	        
	    }
	

}
