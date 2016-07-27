package testJava;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import net.sf.json.JSONObject;
import testJava.model.TestJsonModel;

public class Test0 {

	public static void main(String[] args) {
		Test0 t =new Test0();
		t.test8();
		t.test9();
	}
	void test9(){
		MessageDigest md = null;
		String str ="aaa";
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(str.getBytes());
		byte[] digest = md.digest();
		StringBuffer hexstr = new StringBuffer();
		int shaHex;
		for (int i = 0; i < digest.length; i++) {
			shaHex = ((int)digest[i]) & 0xFF;
			if (shaHex < 16) {
				hexstr.append(0);
			}
			hexstr.append(Integer.toHexString(shaHex));
		}
		System.out.println(hexstr.toString());
		System.out.println(digest.toString());
	}
	void test8(){
		MessageDigest md = null;
		String str ="aaa";
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(str.getBytes());
		byte[] digest = md.digest();
		StringBuffer hexstr = new StringBuffer();
		String shaHex = "";
		for (int i = 0; i < digest.length; i++) {
			shaHex = Integer.toHexString(digest[i] & 0xFF);
			if (shaHex.length() < 2) {
				hexstr.append(0);
			}
			hexstr.append(shaHex);
		}
		System.out.println(hexstr.toString());
		System.out.println(digest.toString());
	}
	void test7(){
		if(1==1){
			System.out.println("11");
		}else if(2==2){
			System.out.println("22");
		}
	}
	void test6(){
		String s= "[A-Za-z0-9]{1,16}";
		String name="2555555kgk";
		System.out.println(name.matches(s));
		System.out.println("¶Ô¶Ô¶Ô".length());
	}
	void test5(){
		TestJsonModel t = new TestJsonModel();
		t.setAge("1");
		t.setName("zz");
		System.out.println(t);
		System.out.println(t.toString());
	}
	void test4(){
		String str = ""+new Date().getTime();
		System.out.println(str);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("pp=="+str);
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
		TestJsonModel model = (TestJsonModel)JSONObject.toBean(JSONObject.fromObject(jsonStr.toString()),TestJsonModel.class);
		System.out.println(model.getId());
		System.out.println(model.getName());
		System.out.println(model.getAge());
		System.out.println(model);
	}
	
	void test(){
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(1435820907);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			System.out.println(sf.parse("2015-07-02 24:24:02").getTime()-sf.parse("2015-07-02 00:00:00").getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		d.setDate(1443320146);
		System.out.println(sf.format(d));
		System.out.println(sf.format(c.getTime()));
	}

}
