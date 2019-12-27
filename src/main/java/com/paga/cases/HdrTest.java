package com.paga.cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.paga.utils.ConfigBeanPropUrl;

@SpringBootTest
public class HdrTest extends AbstractTestNGSpringContextTests{
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="allHdr",groups="getHdr",description="HQ Header查询")
	public void getHdr()throws Exception {
		
		
	}

}
