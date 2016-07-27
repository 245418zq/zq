package testJava;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestString {

	public static void main(String[] args) {
		test3();
	}
	
	static void test0(){
		String str="";
		System.out.println(str == "");
	}
	static void test3(){
		String str="11112.0";
		System.out.println(Long.parseLong(str.replace(".0", "")));
	}
static void test1(){
	String str ="2016-02-23 23";
	System.out.println(str.substring(0, 10));
	System.out.println(str.substring(11));
}
static void test2(){
	Calendar c = Calendar.getInstance();
//	Date d=new Date();
//	d.setDate(d.getDate()-1);
//	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
//	String dateFormat = sdf.format(d);
	System.out.println(c.getTime());
	System.out.println(c.get(c.DAY_OF_WEEK));
	System.out.println(c.get(c.DAY_OF_MONTH));
//	System.out.println(dateFormat);
}
}
