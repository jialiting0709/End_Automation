package com.paga.cases;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paga.config.CaseRelevanceData;
import com.paga.config.TestConfig;
import com.paga.utils.ConfigBeanPropUrl;

@SpringBootTest
public class CommentsTest extends AbstractTestNGSpringContextTests{
	
    @Autowired
    ConfigBeanPropUrl configBeanPropUrl;
    
    @Test(dependsOnGroups = "addComment", groups = "commentsId",description = "query comments id")
    private void test() throws IOException, InterruptedException {
        String res = run();
        Assert.assertNotNull(res);
        Thread.sleep(3000);
    }
    private String run() throws IOException {
        StringBuilder sb =new StringBuilder(configBeanPropUrl.getComments());
        sb.append("/");
        sb.append(CaseRelevanceData.pkValue);
        sb.append("/");
        sb.append(CaseRelevanceData.subtaskid);
        HttpGet get = new HttpGet(sb.toString());
        System.out.println("query comments id: "+sb.toString());
        get.addHeader("username", TestConfig.username);
//        get.addHeader("access_token",TestConfig.access_token);
//        get.addHeader("refresh_token",TestConfig.refresh_token);
//        get.addHeader("token_type",TestConfig.token_type);
//        get.addHeader("refreshToken_lifeSpan",TestConfig.refreshToken_lifeSpan);
//        get.addHeader("jti",TestConfig.jti);

        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("接口的结果："+jsonStr);
        JSONObject resJson = new JSONObject(jsonStr);
        String commentId = null;
        int i = resJson.getJSONArray("SubtaskReview").length();
        for(int j=0;j<i;j++){
            JSONObject obj = resJson.getJSONArray("SubtaskReview").getJSONObject(j);
            commentId = obj.getString("id");
        }
        CaseRelevanceData.commentId = commentId; 
        System.out.println(CaseRelevanceData.commentId);
        
        return commentId;

    }

}
