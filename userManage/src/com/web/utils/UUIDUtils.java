package com.web.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class UUIDUtils {
	/**
	 * 随机生成一个id
	 * @return
	 */
	public static String getId(){
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	
	/**
	 * 随机生成一个数字id
	 * @return
	 */
	public static String getNumId(){    
	    String temp="";   
	    //获取当前时间戳         
	    SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");    
	    temp = sf.format(new Date());    
	    return temp;    
	}    
	/**
	 * 生成随机码
	 * @return
	 */
	public static String getCode(){
		return getId();
	}
	
	public static void main(String[] args) {
		System.out.println(getId());
		System.out.println(getNumId());
	}
	
}
