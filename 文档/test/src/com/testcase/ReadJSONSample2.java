package com.testcase;

import org.json.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.commons.io.FileUtils;

public class ReadJSONSample2 {

	public static void main(String[] args) throws IOException, JSONException, URISyntaxException {
		// TODO Auto-generated method stub
		//路径中有空格或者+号时，会报 java.io.FileNotFoundException这个错误，所以需要进行处理
		//File file = new File(ReadJSONSample.class.getResource("wangxiaoer.json").getFile());
		File file = new File(ReadJSONSample.class.getResource("wangxiaoer2.json").toURI().getPath());
		String content = FileUtils.readFileToString(file);
		JSONObject jsonObject = new JSONObject(content);
		
		System.out.println("jsonObject的值为："+jsonObject);
		if(!jsonObject.isNull("nickname")){
			System.out.println("姓名是："+jsonObject.getString("name"));
		}
		
        System.out.println("年龄："+jsonObject.getDouble("age"));
		System.out.println("有没有女朋友："+jsonObject.getBoolean("has_girlfriend"));
        JSONArray majorArray = jsonObject.getJSONArray("major");
		for(int i=0;i<majorArray.length();i++) {
			String m = (String)majorArray.get(i);
			System.out.println("专业-"+(i+1)+m);
		}	
	}

}
