package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DBClose;
import db.DBConnection;

public class UpdateTest {

	public int update(String name, int age, String id) {
		
		String sql = " UPDATE USERDTO "
				   + " SET NAME = '" + name + "', AGE = " + age + " "
				   + " WHERE ID = '" + id + "' ";
		
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		
		int count = 0;
		
		try {
			stmt = conn.createStatement();
			
			count = stmt.executeUpdate(sql);			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			
			DBClose.close(conn, stmt, null);			
		}
		
		return count;
	}
}





