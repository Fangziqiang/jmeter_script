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
			wangxiaoer.put("name", "��С��");
			wangxiaoer.put("age", 25);
			wangxiaoer.put("birthday", "1990-01-01");
			wangxiaoer.put("school", "����");
			wangxiaoer.put("major", new String[] {"��","�ھ��"});
			wangxiaoer.put("has_girlfriend", false);
			wangxiaoer.put("car", nullObject);
			wangxiaoer.put("house", nullObject);
			wangxiaoer.put("comment", "����һ��ע��");
			
			System.out.println(wangxiaoer.toString());
		}catch(JSONException e){
			e.printStackTrace();
		}
	}
	
	
	private static void createJsonByMap(){
		HashMap<String,Object> wangxiaoer = new HashMap<String,Object>();
		Object nullObject = null;
		wangxiaoer.put("name", "��С��");
		wangxiaoer.put("age", 25);
		wangxiaoer.put("birthday", "1990-01-01");
		wangxiaoer.put("school", "����");
		wangxiaoer.put("major", new String[] {"��","�ھ��"});
		wangxiaoer.put("has_girlfriend", false);
		wangxiaoer.put("car", nullObject);
		wangxiaoer.put("house", nullObject);
		wangxiaoer.put("comment", "����һ��ע��");
	
		System.out.println(new JSONObject(wangxiaoer));
	}
//	ʹ��javabean
	/*
	private static void createJsonByBean(){
		Diaosi wangxiaoer = new Diaosi();
		wangxiaoer.setName("��С��");
		wangxiaoer.setAge(25);
		wangxiaoer.setBirthday("1990-01-01");
		wangxiaoer.setSchool("����");
		wangxiaoer.setMajor(new String[] {"��","�ھ��"});
		wangxiaoer.setHas_girlfriend(false);
		wangxiaoer.setCar(null);
		wangxiaoer.setHouse("null");
		wangxiaoer.setComment("����һ��ע��");
	
		System.out.println(new JSONObject(wangxiaoer));
	}
	*/

}