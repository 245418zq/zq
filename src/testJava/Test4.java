package testJava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test4 {
	public static void main(String[] args) {
		test4();
	}
	static void test4(){
		String s = "2016-05-01";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Date d = new Date();
		try {
			System.out.println(sdf.format(sdf.parse(s)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void test3(){
		Date yesterday = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String month = sdf.format(yesterday);
		yesterday.setMonth(yesterday.getMonth()-1);
		String beforeOneMonth = sdf.format(yesterday);
		yesterday.setMonth(yesterday.getMonth()-1);
		String beforeTwoMonth = sdf.format(yesterday);
		System.out.println(month+"==="+beforeOneMonth+"===="+beforeTwoMonth);
		
	}
	static void test2(){
		String ss= "Inch'on-jikhalsi";
		System.out.println(ss.replaceAll("'", "\\\\'"));
	}
	static void test (){
		Date d = new Date();
		d.setDate(1);
		System.out.println(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(d));
		for(int i=0;i<12;i++){
			d.setMonth(d.getMonth()-1);
			System.out.println(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(d)+"===i=="+i);
		}
//		d.setHours(d.getHours()-14);
//		System.out.println(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(d));
	}

	static void test1(){
		String lat2Str="0";
		String lng2Str="0";
		Double lat2 = Double.parseDouble(lat2Str);
        Double lng2 = Double.parseDouble(lng2Str);
        System.out.println(lat2);
        System.out.println(lng2);
	}
}
