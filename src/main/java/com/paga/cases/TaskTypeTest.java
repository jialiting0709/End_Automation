package com.paga.cases;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paga.config.CaseRelevanceData;

import com.paga.utils.ConfigBeanPropUrl;
import com.paga.utils.PostGetUtil;

@SpringBootTest
public class TaskTypeTest extends AbstractTestNGSpringContextTests{
	
	//获取configUrl.properties配置文件中的url
    @Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
    
    @Test(dependsOnGroups="loginTrue",groups="taskType",description="TaskType查询")
    public void taskType()throws Exception {
    	//发送请求,获取结果
    	System.out.println("TaskType查询查询接口url："+configBeanPropUrl.getTaskType());
        String name= PostGetUtil.getGetMethod(configBeanPropUrl.getTaskType(), "name");
        //验证状态码
        Assert.assertEquals(name, "Create");
    }   
	
}
