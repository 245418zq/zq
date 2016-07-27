package testJava;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test2 t = new Test2();
		t.test3();
		
	}
	void test3(){
		Date d=new Date();
		d.setHours(d.getHours()-1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(d));
		Date d1 = new Date();
		d1.setDate(d1.getDate()-1);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(d1));
	}

	void test2(){
		String[] str = {"ss","dd","fff","cc",null,"ws","as","qwe"};
		boolean flg =true;
		int i=0;
		while(flg){
			if(i>7){
				flg=false;
			}
			try {
				System.out.println(str[i].toString());
			} catch (Exception e) {
				System.out.println("====cause==="+e.getCause()+" ,i="+i);
//				System.out.println("====message==="+e.getMessage());
//				System.out.println("+++++stackTrace++++++"+e.getStackTrace());
//				System.out.println(e.fillInStackTrace());
			}
			i++;
			System.out.println("i="+i);
		}
	}
	
	void test1(){
		String str ="'1410','1410','18676518040','18676518040','','','/Public/Images/default_avatar.png','','60','60','0','0','1','2015-07-13 15:37:03','','18676518040','0','','','','','1','1','2015-09-29 19:01:21','0','0','0','0','0','','0','','1','','0','0','0','0','0','0',''";
		String[] s = str.split(",");
		for(String s1:s){
			System.out.println(s1);
		}
		System.out.println(s.length+" =="+ s[40]);
	}
	void test(){
		String str = "  ss ss d  d ";
		String s ="'  `ღRONG ♞','  `ღRONG ♞'";
		System.out.println(str.trim());
		System.out.println(s.replace("' ", "'\\0"));
	}
}
