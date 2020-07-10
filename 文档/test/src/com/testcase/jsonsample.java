package com.testcase;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.*;

public class jsonsample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String response_data = "{\"resultCode\":0,\"resultMessage\":\"\\u64CD\\u4F5C\\u6210\\u529F\",\"businessCode\":0,\"data\":[{\"product\":{\"productId\":\"122872\",\"productName\":\"2018\\u516D\\u5E74\\u7EA7\\u4E00\\u5BF9\\u4E00\",\"subjectIds\":\"848489,848490,848491,848492,848493,848494,848495,848498,848499\",\"gradeIds\":null,\"gradeName\":\"\\u516D\\u5E74\\u7EA7\",\"gradeId\":\"848466\",\"quantity\":10,\"price\":255,\"payment\":2550,\"categoryName\":\"\\u4E00\\u5BF9\\u4E00\",\"category\":\"ONE_ON_ONE_COURSE\",\"belongFeeTypeId\":null,\"productVersionId\":\"848860\",\"productQuarterId\":null,\"allowModifyPrice\":0,\"allowLadderPrice\":1,\"courseTypeId\":null,\"uuid\":\"6ce7c392-36d2-4e53-9e62-6dd6b5657f59\",\"promotionUuid\":\"cb3fb872-4183-4a9f-9d44-ec5e9ff507e9\",\"allowLockingClassTotalhours\":0,\"ladderPrice\":[{\"id\":\"11266\",\"productId\":\"122872\",\"productQuantityStart\":0,\"productQuantityEnd\":0,\"productPrice\":0,\"ladderOrder\":1}],\"subjectDto\":[{\"id\":\"848489\",\"name\":\"\\u82F1\\u8BED\"},{\"id\":\"848490\",\"name\":\"\\u7269\\u7406\"},{\"id\":\"848491\",\"name\":\"\\u5316\\u5B66\"},{\"id\":\"848492\",\"name\":\"\\u6570\\u5B66\"},{\"id\":\"848493\",\"name\":\"\\u8BED\\u6587\"},{\"id\":\"848494\",\"name\":\"\\u751F\\u7269\"},{\"id\":\"848495\",\"name\":\"\\u5730\\u7406\"},{\"id\":\"848498\",\"name\":\"\\u653F\\u6CBB\"},{\"id\":\"848499\",\"name\":\"\\u5386\\u53F2\"}],\"otherProducts\":[{\"productId\":\"122848\",\"productName\":\"2019\\u6750\\u8D39120\",\"subjectIds\":null,\"gradeIds\":null,\"gradeName\":null,\"gradeId\":null,\"quantity\":null,\"price\":120,\"payment\":120,\"categoryName\":\"\\u5176\\u4ED6\",\"category\":\"OTHERS\",\"belongFeeTypeId\":null,\"productVersionId\":null,\"productQuarterId\":null,\"allowModifyPrice\":0,\"allowLadderPrice\":null,\"courseTypeId\":\"848766\",\"uuid\":\"6ce7c392-36d2-4e53-9e62-6dd6b5657f59\",\"promotionUuid\":\"39bc1519-45b6-440c-818d-bc686de017df\",\"allowLockingClassTotalhours\":0,\"ladderPrice\":[],\"subjectDto\":[],\"otherProducts\":[]}]},\"miniClass\":null,\"onScheduleClass\":null},{\"product\":{\"productId\":\"122875\",\"productName\":\"2019\\u516D\\u5E74\\u7EA71\\u5BF92\",\"subjectIds\":\"848492,848493,848489\",\"gradeIds\":\"\",\"gradeName\":\"\\u516D\\u5E74\\u7EA7\",\"gradeId\":\"848466\",\"quantity\":1,\"price\":200,\"payment\":200,\"categoryName\":\"1\\u5BF9N\",\"category\":\"ONE_ON_N_GROUP\",\"belongFeeTypeId\":null,\"productVersionId\":\"848818\",\"productQuarterId\":null,\"allowModifyPrice\":1,\"allowLadderPrice\":0,\"courseTypeId\":\"848756\",\"uuid\":\"0e339ce0-2ce5-41b7-a048-885f0c2ee70e\",\"promotionUuid\":\"a2909b53-45fb-450c-ab3b-f40b0b00780b\",\"allowLockingClassTotalhours\":0,\"ladderPrice\":[],\"subjectDto\":[{\"id\":\"848492\",\"name\":\"\\u6570\\u5B66\"},{\"id\":\"848493\",\"name\":\"\\u8BED\\u6587\"},{\"id\":\"848489\",\"name\":\"\\u82F1\\u8BED\"}],\"otherProducts\":[{\"productId\":\"122867\",\"productName\":\"\\u4E00\\u5BF9N\\u8D44\\u6599\\u8D39250\",\"subjectIds\":null,\"gradeIds\":null,\"gradeName\":null,\"gradeId\":null,\"quantity\":null,\"price\":250,\"payment\":250,\"categoryName\":\"\\u5176\\u4ED6\",\"category\":\"OTHERS\",\"belongFeeTypeId\":null,\"productVersionId\":null,\"productQuarterId\":null,\"allowModifyPrice\":0,\"allowLadderPrice\":null,\"courseTypeId\":null,\"uuid\":\"0e339ce0-2ce5-41b7-a048-885f0c2ee70e\",\"promotionUuid\":\"5dbd9802-7fdf-4b7e-9ed0-48f7cd589342\",\"allowLockingClassTotalhours\":0,\"ladderPrice\":[],\"subjectDto\":[],\"otherProducts\":[]}]},\"miniClass\":null,\"onScheduleClass\":null}]}";
		
//		JSONObject data_obj = new JSONObject(response_data);
		//log.info(response_data);
		String uuid="";
		String promotionUuid="";
		String productId="";
		String miniClassId="";
		try{
			JSONObject data_obj = new JSONObject(response_data);
//			log.info(response_data);
			JSONArray data = data_obj.getJSONArray("data");
//			log.info("data数组长度"+data.length());
			for(int i = 0; i < data.length(); i++){
//				miniClassId = data.getJSONObject(i).get("miniClass").get("miniClassId");
				JSONObject data2_obj = data.getJSONObject(i);
//				String data2_obj_string=JSONObject.toJSONString(data2_obj);
//				log.info(data2_obj_string);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
