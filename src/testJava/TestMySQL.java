package testJava;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestMySQL {

	public static void main(String[] args) {
		TestMySQL t= new TestMySQL();
		t.test();
	}

	void test() {
		String url = "jdbc:mysql://120.25.91.101:3306/mysql";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
		} catch (Exception e) {
			System.out.println("无法加载驱动");
		}
		try {
			Connection con = DriverManager.getConnection(url, "root", "9GXslH@vLD");
			if (!con.isClosed())
				System.out.println("success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
