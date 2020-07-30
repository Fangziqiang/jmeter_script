package com.testcase.productSqlMaker;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] school = {59,80,10,130,135,31,67,105,13,116,113,69,75,94,34,36,47,12,125,138,21,118,110,73,45,15,100,119,109,131,76,114,14,30,128,39,51,17,66,37,3,74,16,41,8,38,11,102,78,111,120,1,50,79,56,115,54,93,84,4,103,5,83,133,6,108,107,134,82,129,71,7,137,96,136,57,99,101,2,127,18,132,55,139,140,141,142,143,144,145};
		for(int i=0;i<school.length;i++) {
			System.out.println(school[i]);
		}
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://www.baidu.com");
		//请求执行，获取返回对象
		CloseableHttpResponse response = null;

	}

}
