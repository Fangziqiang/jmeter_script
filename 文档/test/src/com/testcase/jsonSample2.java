package com.testcase;
import java.util.HashMap;

import org.json.*;

public class jsonSample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JSONObject();
		createJsonByMap();
	}

	private static void JSONObject() {
		// TODO Auto-generated method stub
		JSONObject wangxiaoer = new JSONObject();
		Object nullObject = null;
	
		try{
			wangxiaoer.put("name", "王小二");
			wangxiaoer.put("age", 25);
			wangxiaoer.put("birthday", "1990-01-01");
			wangxiaoer.put("school", "蓝翔");
			wangxiaoer.put("major", new String[] {"理发","挖掘机"});
			wangxiaoer.put("has_girlfriend", false);
			wangxiaoer.put("car", nullObject);
			wangxiaoer.put("house", nullObject);
			wangxiaoer.put("comment", "这是一个注释");
			
			System.out.println(wangxiaoer.toString());
		}catch(JSONException e){
			e.printStackTrace();
		}
	}
	
	
	private static void createJsonByMap(){
		HashMap<String,Object> wangxiaoer = new HashMap<String,Object>();
		Object nullObject = null;
		wangxiaoer.put("name", "王小二");
		wangxiaoer.put("age", 25);
		wangxiaoer.put("birthday", "1990-01-01");
		wangxiaoer.put("school", "蓝翔");
		wangxiaoer.put("major", new String[] {"理发","挖掘机"});
		wangxiaoer.put("has_girlfriend", false);
		wangxiaoer.put("car", nullObject);
		wangxiaoer.put("house", nullObject);
		wangxiaoer.put("comment", "这是一个注释");
	
		System.out.println(new JSONObject(wangxiaoer));
	}
//	使用javabean
	/*
	private static void createJsonByBean(){
		Diaosi wangxiaoer = new Diaosi();
		wangxiaoer.setName("王小二");
		wangxiaoer.setAge(25);
		wangxiaoer.setBirthday("1990-01-01");
		wangxiaoer.setSchool("蓝翔");
		wangxiaoer.setMajor(new String[] {"理发","挖掘机"});
		wangxiaoer.setHas_girlfriend(false);
		wangxiaoer.setCar(null);
		wangxiaoer.setHouse("null");
		wangxiaoer.setComment("这是一个注释");
	
		System.out.println(new JSONObject(wangxiaoer));
	}
	*/

}