package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTest {
	public JdbcTest () {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.println("Driver Loading Success!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			
	}
	
	public Connection getConnection() {
		
		Connection conn = null;
		// 다른 PC에서 사용할 경우 localhost = ip
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HR", "HR");
		
			System.out.println("DB Connection Success!");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return conn;
	}
}
