package testJava;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test3 {

	public static void main(String[] args) {
		test1();
	}
	
	static void  test1(){
		//unix_timestamp��mysql�� ʱ�����java��ת��Ϊ�������ͣ���Ҫ����1000����ת��
		Timestamp t = new Timestamp(Long.parseLong("1461911945"));
		Date d = new Date(t.getTime()*1000);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d));
	}
}
