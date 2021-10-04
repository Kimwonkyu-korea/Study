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

	private BbsDao() {	// Connet 안해줘도됌(MemberDao 에서해줌)
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
	// 따로받을 수 있고, BbsDto로 해도된다
	public boolean writeBbs(BbsDto dto) {

		String sql = " INSERT INTO BBS "
				+ "      (SEQ, ID, "
				+ "      REF, STEP, DEPTH, "
				+ "      TITLE, CONTENT, WDATE, DEL, READCOUNT) "
				+ "    VALUES"
				+ "      (SEQ_BBS.NEXTVAL, ?, "
				+ "		 (SELECT NVL(MAX(REF), 0)+1 FROM BBS), 0, 0, "
				+ "      ?, ?, SYSDATE, 0, 0) ";
		// (SELECT NVL(MAX(REF), 0)+1 FROM BBS): 초기값 1, 그 후 제일 큰 값 + 1

		Connection conn = null;			// DB랑 Connection
		PreparedStatement psmt = null; 	// 쿼리적용

		int count = 0; // INSERT 실행 할때 리턴 값

		try {
			conn = DBConnection.getConnection();
			System.out.println("1/3 writeBbs success");

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			System.out.println("2/3 writeBbs success");

			count = psmt.executeUpdate();
			System.out.println("3/3 writeBbs success");

		} catch (SQLException e) {			
			e.printStackTrace();
			System.out.println("writeBbs fail");
		} finally {

			DBClose.close(conn, psmt, null);
		}

		return count>0?true:false;
	}
	
	public BbsDto getBbs(int seq) {
		
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
				+    " 		  TITLE, CONTENT, WDATE, "
				+    "        DEL, READCOUNT "
				+ 	 " FROM BBS "
				+ 	 " WHERE SEQ=? ";
		
		Connection conn = null;
	    PreparedStatement psmt = null;
	    ResultSet rs = null;
	    
	    BbsDto dto = null;
	    
	    try {
	    	conn = DBConnection.getConnection();
	    	System.out.println("1/4 getBbs success");
	    	
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			System.out.println("2/4 getBbs success");
			
			rs = psmt.executeQuery();
			System.out.println("3/4 getBbs success");
			
			if(rs.next()) {
				dto = new BbsDto(rs.getInt(1),	//(컬럼명)
								rs.getString(2),
								rs.getInt(3),
								rs.getInt(4),
								rs.getInt(5),
								rs.getString(6),
								rs.getString(7),
								rs.getString(8),
								rs.getInt(9),
								rs.getInt(10));
			}
			System.out.println("4/4 getBbs success");
			
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("getBbs fail");
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		return dto;
	}
	
	public void readcount(int seq) {
		
		String sql = " UPDATE BBS "
				+ 	 " SET READCOUNT=READCOUNT+1 "
				+ 	 " WHERE SEQ=? ";
		
		Connection conn = null;
	    PreparedStatement psmt = null;
	    
	    
	    try {
	    	conn = DBConnection.getConnection();
	    	System.out.println("1/3 readcount success");
	    	
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seq);
			System.out.println("2/3 readcount success");
			
			psmt.executeUpdate();
			System.out.println("3/3 readcount success");
			
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("readcount fail");
		} finally {
			DBClose.close(conn, psmt, null);
		}
	}
	
	
	public void updatecount(String title, String content) {

		String sql = " UPDATE BBS "
				+ 	 " SET  TITLE = ? "
				+ 	 " 	 	CONTENT = ? "
				+ 	 " WHERE SEQ=? ";
		
		Connection conn = null;
	    PreparedStatement psmt = null;
	    
	    try {
	    	conn = DBConnection.getConnection();
	    	System.out.println("1/3 updatecount success");
	    	
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			psmt.setString(2, content);
			System.out.println("2/3 updatecount success");
			
			psmt.executeUpdate();
			System.out.println("3/3 updatecount success");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("updatecount fail");
		} finally {
			DBClose.close(conn, psmt, null);
		}
	}
	
	// 하나의 함수로 그룹번호, 새로적은 bbs
	public boolean answer(int seq, BbsDto bbs) {
		
		// update
		// REF와 같고 STEP을 늘려라
		String sql1 = " UPDATE BBS "
				+ 	  " SET STEP=STEP+1 "
				+ 	  " WHERE REF = (SELECT REF FROM BBS WHERE SEQ=? ) "
				+ 	  " 		AND STEP > (SELECT STEP FROM BBS WHERE SEQ=? )";
		
		// insert
		String sql2 = " INSERT INTO BBS(SEQ, ID,  "
				+ 	  " 				REF, STEP, DEPTH, "
				+     "					TITLE, CONTENT, WDATE, DEL, READCOUNT) "
				+ 	  " VALUES(SEQ_BBS.NEXTVAL, ?, "
				+ 	  "		   	(SELECT REF FROM BBS WHERE SEQ=? ),"	// REF
				+ 	  "			(SELECT STEP FROM BBS WHERE SEQ=? ) + 1, "  // STEP
				+ 	  "			(SELECT DEPTH FROM BBS WHERE SEQ=? ) + 1, " // DEPTH
				+ 	  "			?, ?, SYSDATE, 0, 0) ";
		
		Connection conn = null;
	    PreparedStatement psmt = null;
	    
	    int count = 0;
	    
	    try {
	    	conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			System.out.println("1/6 answer success");
			
			// update 먼저
			psmt = conn.prepareStatement(sql1);
			psmt.setInt(1, seq);
			psmt.setInt(2, seq);
			System.out.println("2/6 answer success");
			
			count = psmt.executeUpdate();
			System.out.println("3/6 answer success");
			
			// psmt 초기화, 다시 쿼리문 사용
			psmt.clearParameters();
			
			// insert
			psmt = conn.prepareStatement(sql2);
			psmt.setString(1, bbs.getId());
			psmt.setInt(2, seq);
			psmt.setInt(3, seq);
			psmt.setInt(4, seq);
			psmt.setString(5, bbs.getTitle());
			psmt.setString(6, bbs.getContent());
			System.out.println("4/6 answer success");
			
			count = psmt.executeUpdate();
			System.out.println("5/6 answer success");
			
			conn.commit();
			System.out.println("6/6 answer success");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("answer fail");
			// 되돌림
			try {
				conn.rollback();
			} catch (SQLException e1) { e1.printStackTrace();}
		} finally {
			try {
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DBClose.close(conn, psmt, null);
		}
	    return count>0?true:false;
	}
	public List<BbsDto> getBbsSearchList(String choice, String search) {

		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
				+    " 		  TITLE, CONTENT, WDATE, "
				+    "        DEL, READCOUNT "
				+ 	 " FROM BBS ";
				
		String sWord = "";
		if(choice.equals("title")) {	// ' ' 주의
			sWord = " WHERE TITLE LIKE '%" + search + "%' "; 
		}else if(choice.equals("content")) {
			sWord = " WHERE CONTENT LIKE '%" + search + "%' "; 
		}else if(choice.equals("id")) {
			sWord = " WHERE ID= '" + search + "' ";
		}
				
		sql = sql + sWord;		
				
		sql = sql + 	 " ORDER BY REF DESC, STEP ASC ";

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
