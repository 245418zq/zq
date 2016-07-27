package testJava;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import testJava.model.TestJsonModel;

public class Test1Log {
	private static final Log log = LogFactory.getLog(Test1Log.class);
	
	public static void main(String[] args) {
		Test1Log l = new Test1Log();
		l.test7();
	}
	
	void test7(){
		Date d=new Date();
		d.setDate(d.getDate()-1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String startDate = sdf.format(d);
		String endDate = sdf.format(new Date());
		System.out.println(startDate);
		System.out.println(endDate);
	}
	
	void test6(){
		String reg = "^\\d{1,16}$";
		System.out.println(reg);
		String index="2221113334445556";
		System.out.println(index.matches(reg));
	}
	void test5(){
		String str="A114591813465746HF18319176071";
		System.out.println(str.substring(0, 1));
	}
	void test4(){
		TestJsonModel m=new TestJsonModel();
		m.setAge("12");
		m.setId("1");
		StringBuffer sb = new StringBuffer();
		sb.append("age="+m.getAge());
		sb.append("&name=");
		sb.append("&id="+m.getId());
		sb.append("&name="+m.getName());
		System.out.println(sb.toString());
	}
	
	void test3(){
		String s="�й�1&hellip;&hellip;&hellip;";
		s= StringEscapeUtils.unescapeHtml(s);
		System.out.println(s);
//		try {
//			s= URLDecoder.decode(s, "utf-8");
//			System.out.println(s);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
	}
	void test2(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		System.out.println(sdf.format(new Date()));
	}
	void test1(){
		log.info("-----------start log test------------");
		System.out.println("kkkkkkkkkkkk");
		log.error("----------test log error----------");
		System.out.println("lllllllll");
		log.debug("========start debug log=====");
		System.out.println("debug log");
		log.debug("--------end debug log---------");
		System.out.println("log test");
		log.fatal("---------00000000000-------");
		log.info("=========log info =============");
		log.trace("++++++++++222222222222222222++++++++++");
		log.warn("-------------333333333333----------");
	}
}
