package jp10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Example01 {

	public static void main(String[] args) {
		
		Connection con=null;
		Statement stmt=null;
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con=DriverManager.getConnection(url, "scott", "tiger");
			
			stmt=con.createStatement();
			
			String createSql=
					"CREATE TABLE member"+
					"(no NUMBER,"+
					"id VARCHAR2(10),"+
					"pwd VARCHAR2(10))";
			
			stmt.executeUpdate(createSql);
			
		}catch(ClassNotFoundException e) {
			System.out.println("\n==>Driver Loading시 Exceptio 발생\n");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("\n==>JDBC 절차 중 Exception 발생 : "+e.getErrorCode());
			e.printStackTrace();
		}finally {
			try {
			if(stmt !=null)
				stmt.close();
			if(con !=null)
				con.close();
			}catch(SQLException e) {
				System.out.println("\n==>JDBC 절차 중 Exception 발생 : "+e.getErrorCode());
				e.printStackTrace();
			}			
		}

	}

}
