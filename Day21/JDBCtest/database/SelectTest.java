package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.UserDto;

public class SelectTest {
	
	// 하나의 데이터만을 취득
	/*
	public UserDto search(String id) {
		
		String sql = " SELECT ID, NAME, AGE, JOINDATE "
					+" FROM USERDTO "
					+" WHERE ID = '" + id + "' ";
		
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		UserDto dto = null;
		
		try {
			stmt = conn.createStatement(); // 현재 상태를 생성
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next() == true) {	// DB로부터 넘어 온 데이터가 있음, true 생략가능
				
				String _id = rs.getString("id");
				String _name = rs.getString("name");	// "name" 컬럼명
				int _age = rs.getInt("age");
				String _joindate =rs.getString("joindate");
				
				dto = new UserDto(_id, _name, _age, _joindate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, stmt, rs);
		}
		
		return dto;
	}
	*/
	public UserDto search2(String id) {
		
		String sql = " SELECT ID, NAME, AGE, JOINDATE "
				+" FROM USERDTO "
				+" WHERE ID =  ? ";
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null; // 이것만 수정 
		ResultSet rs = null;
		
		UserDto dto = null;
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);	// ' ' 제거 가능
			
			rs = psmt.executeQuery(); // ()안에 안넣어도됌
			
			if(rs.next() == true) {	// DB로부터 넘어 온 데이터가 있음, true 생략가능

				String _id = rs.getString("id");
				String _name = rs.getString("name");	// "name" 컬럼명
				int _age = rs.getInt("age");
				String _joindate =rs.getString("joindate");

				dto = new UserDto(_id, _name, _age, _joindate);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		
		return dto;
	}

	
	// 다수의 데이터를 취득
	/*
	public List<UserDto> getUsers() {
		
	}
	*/
	
	public List<UserDto> getUsers() {
		
		String sql = " SELECT ID, NAME, AGE, JOINDATE "
					+ " FROM USERDTO ";
				
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<UserDto> list = new ArrayList<UserDto>();
		
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {	// true 생략
				String _id = rs.getString("id");
				String _name = rs.getString("name");
				int _age = rs.getInt("age");
				String _joindate = rs.getString("joindate");
				
				UserDto dto = new UserDto(_id, _name, _age, _joindate);
				list.add(dto);

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		return list;
	}

}
