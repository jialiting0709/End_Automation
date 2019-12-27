package com.paga.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.paga.config.TestConfig;

public class PostGetUtil {
	
	  public static String getGetMethod(String url,String key) throws IOException {	    	
	    	HttpGet get = new HttpGet(url);
	    	get.addHeader("username",TestConfig.username);
//	    	get.addHeader("access_token",TestConfig.access_token);
//	    	get.addHeader("refresh_token",TestConfig.refresh_token);
//	    	get.addHeader("token_type",TestConfig.token_type);
//	    	get.addHeader("refreshToken_lifeSpan",TestConfig.refreshToken_lifeSpan);
//	    	get.addHeader("jti",TestConfig.jti);
	    	
	    	HttpResponse response = TestConfig.defaultHttpClient.execute(get);
	    	
	    	String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
	    	System.out.println("接口的响应结果："+jsonStr);
	    	JSONArray jsonArray = new JSONArray(jsonStr);
	    	String name = jsonArray.getJSONObject(0).getString(key);
	    	return name;
	    	  	
	    }
	  
	  public static String getPosttMethod(String url,JSONObject param) throws IOException {
		  HttpPost post = new HttpPost(url);
		  post.addHeader("username",TestConfig.username);
//		  post.addHeader("username","wang");
		  System.out.println("TestConfig.username："+TestConfig.username);
//	      post.addHeader("access_token",TestConfig.access_token);
//	      post.addHeader("refresh_token",TestConfig.refresh_token);
//	      post.addHeader("token_type",TestConfig.token_type);
//	      post.addHeader("refreshToken_lifeSpan",TestConfig.refreshToken_lifeSpan);
//	      post.addHeader("jti",TestConfig.jti);
	      post.setHeader("Content-Type","application/json");
	      StringEntity entity = new StringEntity(param.toString(),"utf-8");
	      post.setEntity(entity);
	      HttpResponse response = TestConfig.defaultHttpClient.execute(post);
	      String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
	      System.out.println("接口的响应结果："+jsonStr);
		  return jsonStr;
		 
	  }    

}
