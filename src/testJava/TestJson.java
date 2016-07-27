package testJava;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

import testJava.model.TestJsonModel;

public class TestJson {

	public static void main(String[] args) {
//		new TestJson().test();
//		new TestJson().test1();
//		new TestJson().testRandom();
//		TestJson.getNextDay();
		new TestJson().test3();
	}
	
	void test3(){
		String jsapiticket="q";
		String timestamp="a";
		String noncestr="z";
		String url="w";
		
		String[] array = new String[] {jsapiticket, timestamp, noncestr , url};
		StringBuffer sb = new StringBuffer();
		// ×Ö·û´®ÅÅÐò
		Arrays.sort(array);
		for (int i = 0; i < 3; i++) {
			sb.append(array[i]);
		}
		String str = sb.toString();
		System.out.println(str);
	}
	
	void test2(){
		StringBuilder jsonStr = new StringBuilder();
		jsonStr.append("{");
		jsonStr.append("'id':'111'");
		jsonStr.append(",'name':'222'");
		jsonStr.append("}");
		TestJsonModel model = (TestJsonModel)JSONObject.toBean(JSONObject.fromObject(jsonStr),TestJsonModel.class);
		System.out.println(model.getId());
		System.out.println(model.getName());
		System.out.println(model.getAge());
		System.out.println(model);
	}
	
	void testRandom(){
		Random r = new Random();
		System.out.println(r.nextInt(7));
	}
	public static Date getNextDay() {  
		Date date = new Date();
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        calendar.add(Calendar.DAY_OF_MONTH, +1);  
        date = calendar.getTime();  
        System.out.println(date);
        return date;  
    }
	void test() {
		InputStream in3 = null;
		try {
			in3 = new URL("https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code").openStream();
			LineIterator it = IOUtils.lineIterator(in3, "UTF-8");
			System.out.println(it.hasNext());
			if (it.hasNext()) {
				String line = it.nextLine();
				System.out.println(line);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(in3);
		}
		System.out
				.println("--------------------------------------------------");
	}

/*	void test1() {
		StringBuilder jsonStr = new StringBuilder();
		jsonStr.append("{");
		jsonStr.append("'id':'111'");
		jsonStr.append(",'name':'222'");
		jsonStr.append("}");
		//jsonStr.append("{'errcode':-1,'errmsg':'system error, hints: [ req_id: 2rENrA0520ns55 ]'}");
		System.out.println(jsonStr.toString());
		
		JSONObject json = new JSONObject();
		try {
			json = new JSONObject(jsonStr.toString());
			if(jsonStr.indexOf("id") != -1){
				System.out.println(json.getString("id"));
			}
			System.out.println(json.getString("id1ss"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		// System.out.println(json.getString("id"));
	}*/
}
