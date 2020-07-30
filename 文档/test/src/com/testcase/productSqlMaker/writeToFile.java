package com.testcase.productSqlMaker;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class writeToFile {
	public static void main(String[] args){
	        //需要写入的文件的路径
	        String filePath = "D:/test.txt";

	        //写入的文件的内容
	        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

	        //添加写入文件的内容：1000个Map集合型数据
	        for(int i = 1;i <= 1000;i++){
	            Map<String,Object> map = new HashMap<String,Object>();
//	            map.put("key_"+i, "value_"+i);
	            
	            list.add(map);
	        }


	        try{
	            File file = new File(filePath);
	            FileOutputStream fos = null;
	            if(!file.exists()){
	                file.createNewFile();//如果文件不存在，就创建该文件
	                fos = new FileOutputStream(file);//首次写入获取
	            }else{
	                //如果文件已存在，那么就在文件末尾追加写入
	                fos = new FileOutputStream(file,true);//这里构造方法多了一个参数true,表示在文件末尾追加写入
	            }

	            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");//指定以UTF-8格式写入文件

	            //遍历list
	            for(Map<String,Object> map: list){
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
