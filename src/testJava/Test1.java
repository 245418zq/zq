package testJava;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;

public class Test1 {

	public static void main(String[] args) {
		Test1 t = new Test1();
		t.test6();
	}
	void test6(){
		String str ="12330987722";
		String reg = "^[\\d]{11}";
		Pattern p = Pattern.compile(reg);
		System.out.println(str.matches(reg));
		System.out.println(p.matcher(str).matches());
	}
	void test5(){
		Calendar c = Calendar.getInstance();
		Date d= new Date();
		System.out.println(d.getHours());
		System.out.println(d.getMinutes());
		System.out.println(c.get(Calendar.HOUR_OF_DAY));
		System.out.println(c.get(Calendar.MINUTE));
	}
	void test4(){
		for(int i=0;i<10;i++){
			try {
				test3(i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	void test3(int i){
		String str1=null;
		 if(i>3){
				System.out.println(str1.toString());
		 }
		 System.out.println(i);
		String str ="'ssssdsds'''a撒大苏打水";
		if(str.indexOf("'") == 0){
			System.out.println(str.indexOf("'"));
		}
		System.out.println(str.replace("'", "\\\'"));
	}
	void test2(){
		String str ="";
		System.out.println(Integer.parseInt(str.trim()));
	}
	
	void test1(){
		StringBuilder jsonStr = new StringBuilder();
		jsonStr.append("{'status':'0','result':{'location':{'lat':'39.984154','lng':'116.30749'}}}");
		try {
			JSONObject json = new JSONObject(jsonStr.toString());
			System.out.println(json.getJSONObject("result").getJSONObject("location"));
			//System.out.println(new JSONObject(json.getString("result")).getString("location"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	void test0(){
		String str="上海";
		String code= "&auml;&cedil;&aelig;&micro;&middot;&aring;&cedil;";
		String s=null;
		try {
			System.out.println(URLEncoder.encode(str, "gbk"));
			System.out.println(URLEncoder.encode(str, "utf-16"));
			System.out.println(URLEncoder.encode(str, "ISO-8859-1"));
			System.out.println(URLEncoder.encode(str, "us-ascii"));
			System.out.println(URLDecoder.decode(URLEncoder.encode(str, "utf-8"), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
