package testJava;

import java.text.SimpleDateFormat;
import java.util.Date;

public class tests {

	public static void main(String[] args) {
		test0();
	}

	static void test0(){
		Date d= new Date(1462053597*1000);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d));
	}
}
