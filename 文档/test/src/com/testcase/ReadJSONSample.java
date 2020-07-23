package com.testcase;

import org.json.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.commons.io.FileUtils;

public class ReadJSONSample {


	/**
	 * @param args
	 * @throws IOException
	 * @throws JSONException
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws IOException, JSONException, URISyntaxException {
		// TODO Auto-generated method stub
		//路径中有空格或者+号时，会报 java.io.FileNotFoundException这个错误，所以需要进行处理
		//File file = new File(ReadJSONSample.class.getResource("wangxiaoer.json").getFile());
		File file = new File(ReadJSONSample.class.getResource("wangxiaoer.json").toURI().getPath());
		String content = FileUtils.readFileToString(file);
		JSONObject jsonObject = new JSONObject(content);
		System.out.println("jsonObject的值为："+jsonObject);
		System.out.println("响应信息是："+jsonObject.getString("resultMessage"));
//		System.out.println();
		
		//获取JSON对象中的data数组
		JSONArray dataArray = jsonObject.getJSONArray("data");
//		System.out.println("data数组的值为："+dataArray);
		for(int i=0;i<dataArray.length();i++) {
			//遍历data数组,获取数组中的子对象
			JSONObject dataObject = (JSONObject)dataArray.get(i);
			
			//获取子对象中的product对象
			JSONObject data_productObject = dataObject.getJSONObject("product");
			String uuid = data_productObject.getString("uuid");
			String promotionUuid =data_productObject.getString("promotionUuid");
			
			try {
				JSONObject data_miniClassObject = dataObject.getJSONObject("miniClass");
				String miniClassId = data_miniClassObject.getString("miniClassId");
				if(miniClassId.contentEquals("36285")) {
//					System.out.println("data["+i+"].product.uuid="+uuid);
//					System.out.println("data["+i+"].product.promotionUuid="+promotionUuid);
					System.out.println(uuid);
					System.out.println(promotionUuid);
					System.out.println("nihao");
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
//			String uuid = data_productObject.getString("uuid");
//			String promotionUuid =data_productObject.getString("promotionUuid");
			
			
		
			//打印data数组子对象中的product对象
			//System.out.println("data["+i+"].product="+data_productObject);
			
			//获取product对象中的数组 otherProducts
//			JSONArray otherProductsArray = data_productObject.getJSONArray("otherProducts");
			
//			for(int j=0;j<otherProductsArray.length();j++){
//				JSONObject otherProductsObject = (JSONObject)otherProductsArray.get(j);
//				String other_uuid = otherProductsObject.getString("uuid");
//				String other_promotionUuid =otherProductsObject.getString("promotionUuid");
//				//打印uuid和promotionUuid
//				System.out.println("data["+i+"].product.uuid="+uuid);
//				System.out.println("data["+i+"].product.promotionUuid="+promotionUuid);
////				System.out.println("data["+i+"].product.otherProducts.["+j+"].uuid="+other_uuid);
////				System.out.println("data["+i+"].product.otherProducts.["+j+"].promotionUuid="+other_promotionUuid);
//			}
			
			
			
		}
		
	}

}
