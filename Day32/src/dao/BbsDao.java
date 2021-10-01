package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.BbsDto;

public class BbsDao {
	//싱글턴
	
	private static BbsDao dao = null;
	
	private BbsDao() {	// Connet 안해줘도됌
	}
	
	public static BbsDao getInstance() {
		if(dao == null) {
			dao = new BbsDao();
		}
		return dao;
	}
	
	public List<BbsDto> getBbsList() {
		
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
				+    " 		  TITLE, CONTENT, WDATE, "
				+    "        DEL, READCOUNT "
				+ 	 " FROM BBS "
				+ 	 " ORDER BY REF DESC, STEP ASC ";
		
		 Connection conn = null;
	     PreparedStatement psmt = null;
	     ResultSet rs = null;
	     
	     List<BbsDto> list = new ArrayList<BbsDto>();	// 생성
	     
	     
	     try {
	    	conn = DBConnection.getConnection();
	    	System.out.println("1/4 getBbsList success");
	    	
			psmt = conn.prepareStatement(sql);
			System.out.println("2/4 getBbsList success");
			
			rs = psmt.executeQuery();
			System.out.println("3/4 getBbsList success");
			
			while(rs.next()) {	// 다수의 데이터를 가져올 때
				BbsDto dto = new BbsDto(rs.getInt(1), 
										rs.getString(2),
										rs.getInt(3), 
										rs.getInt(4),
										rs.getInt(5), 
										rs.getString(6),
										rs.getString(7), 
										rs.getString(8), 
										rs.getInt(9), 
										rs.getInt(10));
				
				list.add(dto);		// 데이터를 넣어줌
			}
			System.out.println("4/4 getBbsList success");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("getBbsList fail");
		} finally {
			DBClose.close(conn, psmt, rs);
		} 
	     return list;
	}
}
