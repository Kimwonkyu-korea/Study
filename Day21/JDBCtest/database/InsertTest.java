package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTest {
   public InsertTest(){
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         
         System.out.println("Driver Loading Success!");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
   }
   
   public Connection getConnection() {
      
      Connection conn = null;
      try {
         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "HR", "HR");
         
         System.out.println("DB Connection Success!");
         
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
      return conn;
   }
   
   public int insert(String id, String name, int age) {
      String sql = " INSERT INTO USERDTO(ID, NAME, AGE, JOINDATE) "
               + " VALUES('" + id + "', '" + name + "'," + age + ", SYSDATE)";
      
      Connection conn = getConnection();
      Statement stmt = null;
      
      int count = 0;
      
      try {
         stmt = conn.createStatement();
         
         count = stmt.executeUpdate(sql);
         
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
         try {
            if(stmt != null) {
               stmt.close();

            }
            if(stmt != null) {
               conn.close();

            }
         } catch (SQLException e) {
            e.printStackTrace();
         }   
      }     
      return count;    
   }
   
}