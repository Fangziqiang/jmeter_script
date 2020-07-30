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

import org.apache.commons.io.FileUtils;

public class WriteJSONToExcel2 {


	/**
	 * @param args
	 * @throws IOException
	 * @throws JSONException
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws IOException, JSONException, URISyntaxException {
		// TODO Auto-generated method stub
		//路径中有空格或者+号时，会报 java.io.FileNotFoundException这个错误，所以需要进行处理
		File file = new File(WriteJSONToExcel2.class.getResource("product_list2.json").toURI().getPath());
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
			int school_id=130;
			int product_id = productObject.getInt("product_id");
			String name = productObject.getString("name");
			BigDecimal price = productObject.getBigDecimal("price");
			int remain_num = productObject.getInt("remain_num");
//			System.out.println("product_id:"+product_id+" "+"name:"+name+" "+"price:"+price+" "+"remain_num:"+remain_num);
//			System.out.println("price:"+price);
			System.out.println("insert into product (product_id,name,price,remain_num,school_id) VALUES ('"+product_id+"','"+name+"','"+price+"','"+remain_num+"','"+school_id+"');");

			String filePath = "D:/test.txt";
			//写入的文件的内容
	        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
	        Map<String,Object> map = new HashMap<String,Object>();
            map.put("insert into product (product_id,name,price,remain_num,school_id) VALUES ('"+product_id,"','"+name+"','"+price+"','"+remain_num+"','"+school_id+"');");
            list.add(map);
            try{
	            File file2 = new File(filePath);
	            FileOutputStream fos = null;
	            if(!file2.exists()){
	                file2.createNewFile();//如果文件不存在，就创建该文件
	                fos = new FileOutputStream(file);//首次写入获取
	            }else{
	                //如果文件已存在，那么就在文件末尾追加写入
	                fos = new FileOutputStream(file2,true);//这里构造方法多了一个参数true,表示在文件末尾追加写入
	            }

	            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");//指定以UTF-8格式写入文件

	            //遍历list
	            for(Map<String,Object> map:list){
	                //遍历Map
	                for(Map.Entry<String, Object> entry : map.entrySet()){
	                    //以英文","逗号隔开多个写入的str，每个Map写一行
	                    String str = entry.getKey()+"="+entry.getValue();
	                    osw.write(str+",");
	                }

	                //每写入一个Map就换一行
	                osw.write("\r\n");
	            }
	            //写入完成关闭流
	            osw.close();
	        }catch (Exception e) {
	            e.printStackTrace();
	        }
		}
		
	}

}
