package com.paga.cases;

import com.paga.config.CaseRelevanceData;
import com.paga.utils.ConfigBeanPropUrl;
import com.paga.utils.PostGetUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@SpringBootTest
public class RejectSubtaskTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private ConfigBeanPropUrl configBeanPropUrl;

    @Test(dependsOnGroups = "commentsId",groups = "rejectTask",description = "reject a subtask")
   
    public void rejectTask() throws Exception{
    System.out.println("reject a subtask url:"+configBeanPropUrl.getRejectSubTask());   	
    String result = getResult();
        JSONObject res = new JSONObject(result);
        Assert.assertNotNull(res);
    }
    private String getResult() throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("assignee","");
        jsonObject.put("defineKey","SubtaskReview");
        JSONArray array = new JSONArray();
        JSONObject subObj = new JSONObject();
        subObj.put("id",CaseRelevanceData.commentId);
        subObj.put("tkUuid",CaseRelevanceData.newReviewSubTaskuuid);
        subObj.put("message","234");
        array.put(subObj);
        jsonObject.put("comments",array);
        JSONObject sObj = new JSONObject();
        sObj.put("pkType","guidlineSubTask");
        sObj.put("pkValue",CaseRelevanceData.pkValue);
        jsonObject.put("selfProps",sObj);
        jsonObject.put("uuid", CaseRelevanceData.newReviewSubTaskuuid);
        
        return PostGetUtil.getPosttMethod(configBeanPropUrl.getRejectSubTask(),jsonObject);

    }
}
