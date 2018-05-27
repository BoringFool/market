package com.zm.myuntil;

import org.json.JSONArray;
import org.json.JSONException;

public class JsonStringToArray {

	/*可以直接用jsonarray来实现*/
	public static String[] turn(String s){
		s=s.substring(1,s.length()-1);
		String[] ss=s.split(",");
		for(int i=0;i<ss.length;i++){
			ss[i]=ss[i].replace("\"", "");
		}
		return ss;
	}
	
	/*取得数组转换而来的json字符串中，指定位置的值*/
	public static String jsonget(String s,int num){
		try {
			JSONArray jarray=new JSONArray(s);
			String st=(String) jarray.get(num);
			return st;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
