package com.testcase.productSqlMaker;

import org.json.*;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.client.*;

import org.apache.commons.io.FileUtils;

public class WriteJSONToExcel {


	/**
	 * @param args
	 * @throws IOException
	 * @throws JSONException
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws IOException, JSONException, URISyntaxException {
		// TODO Auto-generated method stub
		//路径中有空格或者+号时，会报 java.io.FileNotFoundException这个错误，所以需要进行处理
		File file = new File(WriteJSONToExcel.class.getResource("product_list2.json").toURI().getPath());
		String content = FileUtils.readFileToString(file);
		JSONObject productList = new JSONObject(content);
//		System.out.println("productList的值为："+productList);
		
		//获取data对象
		JSONObject dataObject = productList.getJSONObject("data");
		
		//获取data对象中的data数组
		JSONArray dataArray = dataObject.getJSONArray("data");
//		System.out.println("data数组的值为："+dataArray);
		
		for(int i=0;i<dataArray.length();i++) {
			//遍历data数组,获取数组中的子对象
			JSONObject productObject = (JSONObject)dataArray.get(i);
//			System.out.println(productObject);
			int school_id=145;
			int product_id = productObject.getInt("product_id");
			String name = productObject.getString("name");
			BigDecimal price = productObject.getBigDecimal("price");
			int remain_num = productObject.getInt("remain_num");
//			System.out.println("product_id:"+product_id+" "+"name:"+name+" "+"price:"+price+" "+"remain_num:"+remain_num);
//			System.out.println("price:"+price);
			System.out.println("insert into product (product_id,name,price,remain_num,school_id) VALUES ('"+product_id+"','"+name+"','"+price+"','"+remain_num+"','"+school_id+"');");

		}
		
	}

}
