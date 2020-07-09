package com.testcase;

import org.json.*;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class ReadJSONSample {

	public static void main(String[] args) throws IOException, JSONException {
		// TODO Auto-generated method stub
		File file = new File(ReadJSONSample.class.getResource("wangxiaoer.json").getFile());
		String content = FileUtils.readFileToString(file);
		JSONObject jsonObject = new JSONObject(content);
		System.out.println("响应信息是："+jsonObject.getString("resultMessage"));
//		System.out.println();
		JSONArray dataArray = jsonObject.getJSONArray("data");
		for(int i=0;i<dataArray.length();i++) {
			JSONObject product = (JSONObject)dataArray.get(i);
//			String product = (String)dataArray.get(i);
			JSONArray otherProducts = product.getJSONArray("otherProducts");
			for(int j=0;j<otherProducts.length();j++) {
				
			}
			System.out.println(product);
		}
		
	}

}
