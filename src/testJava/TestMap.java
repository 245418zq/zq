package testJava;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestMap {
	public static void main(String[] args) {
		TestMap t = new TestMap();
		t.test2();
	}
	
	void test2(){
		BigDecimal bd = new BigDecimal(221);
		BigDecimal bd1 = new BigDecimal(22987);
		BigDecimal d = bd.divide(bd1,4,BigDecimal.ROUND_HALF_UP);
		System.out.println(d);
	}
	
	void test1(){
		Map map=(Map)new HashMap();
		System.out.println(map.get("11"));
		System.out.println(map.get("11").toString());
	}
	void test(){
		Map<String,Object> map  =new HashMap<String,Object>();
		String str = (String)map.get("kk");
		//int count = (int)map.get("kk");
		String obj = map.get("ll")==null?""+0:map.get("ll").toString();
		System.out.println(str);
		System.out.println(map.get("ll")==null?+0:(int)map.get("ll"));
		System.out.println(obj);
		//System.out.println(count);
		System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		System.out.println(new Date().getTime());
		System.out.println(new Date().getSeconds());
		System.out.println(new Date().getTimezoneOffset());
		System.out.println(System.currentTimeMillis());
	}
}
