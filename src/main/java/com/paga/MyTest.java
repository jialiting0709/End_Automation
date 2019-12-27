package com.paga;

import com.google.common.collect.Lists;
import org.testng.TestNG;

import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        TestNG tng = new TestNG();
        List<String> suites = Lists.newArrayList();
        //获取工程根路径
        String root = System.getProperty("user.dir");
        //添加要执行的testng.xml
        suites.add(root+"/config/testng.xml");
        tng.setTestSuites(suites);
        tng.run();
    }
}
