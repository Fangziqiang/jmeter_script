



![1594040088873](.\img\1594040088873.png)

标准的JSON数据表示

数据结构

​	Object

​	使用花括号{}包含的键值对结构，Key必须是string，value为任何基本类型或数据结构

​	Array

​	使用中括号[]来起始，并用逗号，来分割元素

基本类型

string、number、true、false、null

```json
{
    "name":"王小二",
    "age":25,
    "birthdat":"1990-01-01",
    "school":"蓝翔",
    "major":["理发","挖掘机"],
    "has_girlfriend":false,
    "car":null,
    "house":null,
    "comment":"这里是注释"
}
```

JSON使用

jsonsample：

```java
import java.util.HashMap;

import org.json.*;

public class jsonSample {

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

}

```

从文件读取JSON

```java
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

```

从文件读取JSON判断null

```java
if(!jsonObject.isNull("name")){
}
```

实例应用：

在运营系统中，新生报读时，新增合同需要添加面授课信息，在面授课信息中，有uuid和promotionUuid这两个字段不是固定的值，每查询一次课程信息接口，这两个字段的值都会改变，所以需要从课程信息接口实时提取到这两个字段的信息。下面说一下如何提取：

请求课程信息接口，获取面授课基本信息，截取部分课程json数据作为测试数据，保存到json文件中，假设保存的json文件名为wangxiaoer.json，json文件需要和代码放在同一文件夹，json数据如下：

```json
{
    "resultCode": 0,
    "resultMessage": "操作成功",
    "businessCode": 0,
    "data": [
        {
            "product": {
                "productId": "122872",
                "productName": "2018六年级一对一",
                "subjectIds": "848489,848490,848491,848492,848493,848494,848495,848498,848499",
                "gradeIds": null,
                "gradeName": "六年级",
                "gradeId": "848466",
                "quantity": 10,
                "price": 255,
                "payment": 2550,
                "categoryName": "一对一",
                "category": "ONE_ON_ONE_COURSE",
                "belongFeeTypeId": null,
                "productVersionId": "848860",
                "productQuarterId": null,
                "allowModifyPrice": 0,
                "allowLadderPrice": 1,
                "courseTypeId": null,
                "uuid": "6ce7c392-36d2-4e53-9e62-6dd6b5657f59",
                "promotionUuid": "cb3fb872-4183-4a9f-9d44-ec5e9ff507e9",
                "allowLockingClassTotalhours": 0,
                "ladderPrice": [
                    {
                        "id": "11266",
                        "productId": "122872",
                        "productQuantityStart": 0,
                        "productQuantityEnd": 0,
                        "productPrice": 0,
                        "ladderOrder": 1
                    }
                ],
                "subjectDto": [
                    {
                        "id": "848489",
                        "name": "英语"
                    },
                    {
                        "id": "848492",
                        "name": "数学"
                    },
                    {
                        "id": "848493",
                        "name": "语文"
                    }
                ],
                "otherProducts": [
                    {
                        "productId": "122848",
                        "productName": "2019材费120",
                        "subjectIds": null,
                        "gradeIds": null,
                        "gradeName": null,
                        "gradeId": null,
                        "quantity": null,
                        "price": 120,
                        "payment": 120,
                        "categoryName": "其他",
                        "category": "OTHERS",
                        "belongFeeTypeId": null,
                        "productVersionId": null,
                        "productQuarterId": null,
                        "allowModifyPrice": 0,
                        "allowLadderPrice": null,
                        "courseTypeId": "848766",
                        "uuid": "6ce7c392-36d2-4e53-9e62-6dd6b5657f59",
                        "promotionUuid": "39bc1519-45b6-440c-818d-bc686de017df",
                        "allowLockingClassTotalhours": 0,
                        "ladderPrice": [],
                        "subjectDto": [],
                        "otherProducts": []
                    }
                ]
            },
            "miniClass": null,
            "onScheduleClass": null
        },
        {
            "product": {
                "productId": "122875",
                "productName": "2019六年级1对2",
                "subjectIds": "848492,848493,848489",
                "gradeIds": "",
                "gradeName": "六年级",
                "gradeId": "848466",
                "quantity": 1,
                "price": 200,
                "payment": 200,
                "categoryName": "1对N",
                "category": "ONE_ON_N_GROUP",
                "belongFeeTypeId": null,
                "productVersionId": "848818",
                "productQuarterId": null,
                "allowModifyPrice": 1,
                "allowLadderPrice": 0,
                "courseTypeId": "848756",
                "uuid": "0e339ce0-2ce5-41b7-a048-885f0c2ee70e",
                "promotionUuid": "a2909b53-45fb-450c-ab3b-f40b0b00780b",
                "allowLockingClassTotalhours": 0,
                "ladderPrice": [],
                "subjectDto": [
                    {
                        "id": "848492",
                        "name": "数学"
                    },
                    {
                        "id": "848493",
                        "name": "语文"
                    },
                    {
                        "id": "848489",
                        "name": "英语"
                    }
                ],
                "otherProducts": [
                    {
                        "productId": "122867",
                        "productName": "一对N资料费250",
                        "subjectIds": null,
                        "gradeIds": null,
                        "gradeName": null,
                        "gradeId": null,
                        "quantity": null,
                        "price": 250,
                        "payment": 250,
                        "categoryName": "其他",
                        "category": "OTHERS",
                        "belongFeeTypeId": null,
                        "productVersionId": null,
                        "productQuarterId": null,
                        "allowModifyPrice": 0,
                        "allowLadderPrice": null,
                        "courseTypeId": null,
                        "uuid": "0e339ce0-2ce5-41b7-a048-885f0c2ee70e",
                        "promotionUuid": "5dbd9802-7fdf-4b7e-9ed0-48f7cd589342",
                        "allowLockingClassTotalhours": 0,
                        "ladderPrice": [],
                        "subjectDto": [],
                        "otherProducts": []
                    }
                ]
            },
            "miniClass": null,
            "onScheduleClass": null
        }
    ]
}
```

需要提取以上数据中的uuid和promotionUuid，因为使用的是基础的org.json库，所以需要一步步对json数据进行解析，以后如果学习了其他高效的方法，再进行补充。

直接上代码：

```java
package com.testcase;

import org.json.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.commons.io.FileUtils;

public class ReadJSONSample {

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
			
			//打印data数组子对象中的product对象
			//System.out.println("data["+i+"].product="+data_productObject);
			
			//获取product对象中的数组 otherProducts
			JSONArray otherProductsArray = data_productObject.getJSONArray("otherProducts");
			
			for(int j=0;j<otherProductsArray.length();j++){
				JSONObject otherProductsObject = (JSONObject)otherProductsArray.get(j);
				String uuid = otherProductsObject.getString("uuid");
				String promotionUuid =otherProductsObject.getString("promotionUuid");
				//打印uuid和promotionUuid
				System.out.println("data["+i+"].product.otherProducts.["+j+"].uuid="+uuid);
				System.out.println("data["+i+"].product.otherProducts.["+j+"].promotionUuid="+promotionUuid);
			}	
		}
	}
}

```











