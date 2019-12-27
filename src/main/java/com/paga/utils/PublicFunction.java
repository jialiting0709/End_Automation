package com.paga.utils;

import java.util.Date;

import org.sqlite.date.DateFormatUtils;

public class PublicFunction {
	
	public static String getStringDate(Long Millisecond){
		long totalMilliSeconds = System.currentTimeMillis()+Millisecond;
        Date date = new Date();
        date.setTime(totalMilliSeconds);
        String format = DateFormatUtils.format(date, "yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		return format;
	}

	public static void main(String[] args) {
//		getStringDate(432000000L);
//		getStringDate(864000000L);
		

	}
	
	

}
