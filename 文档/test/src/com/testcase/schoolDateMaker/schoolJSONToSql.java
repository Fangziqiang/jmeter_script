package com.testcase.schoolDateMaker;

import org.json.*;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;

import org.apache.commons.io.FileUtils;

public class schoolJSONToSql {


	/**
	 * @param args
	 * @throws IOException
	 * @throws JSONException
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws IOException, JSONException, URISyntaxException {
		// TODO Auto-generated method stub
		//路径中有空格或者+号时，会报 java.io.FileNotFoundException这个错误，所以需要进行处理
		File file = new File(schoolJSONToSql.class.getResource("schools.json").toURI().getPath());
		String content = FileUtils.readFileToString(file);
		JSONObject schools = new JSONObject(content);
		
		//获取data对象
//		JSONObject dataObject = schools.getJSONObject("data");
		
		//获取data对象中的data数组
		JSONArray dataArray = schools.getJSONArray("data");
//		System.out.println("data数组的值为："+dataArray);
		
		for(int i=0;i<dataArray.length();i++) {
			//遍历data数组,获取数组中的子对象
			JSONObject schoolObject = (JSONObject)dataArray.get(i);
			String school_id = schoolObject.getString("school_id");
			String school_name = schoolObject.getString("school_name");

//			System.out.println("insert into t_school ('school_id','school_name') VALUES ('"+school_id+"','"+school_name+"');");
			sqlMaker(school_id,school_name);
		}
		
	}
	
	private static void sqlMaker(String school_id,String school_name) {
		System.out.println("insert into schools (school_id,school_name) VALUES ('"+school_id+"','"+school_name+"');");

	}

}
