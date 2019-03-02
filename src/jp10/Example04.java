package jp10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Example04 {

	public static void main(String[] args) throws Exception{

/*		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		Connection con=DriverManager.getConnection(url, "scott", "tiger");
		
		Statement stmt=con.createStatement();
		
		ResultSet rs=stmt.executeQuery("SELECT*FROM member");
		
		while(rs.next()) {
			
			int no=rs.getInt(1);
			String id=rs.getString(2);
			String pwd=rs.getString(3);
			
			System.out.println("회원정보==> 번호 : "+no+",  id : "+id+",  pwd : "+pwd);
		}
		
		rs.close();
		stmt.close();
		con.close();
*/		

		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection(url, "scott", "tiger");
		
		PreparedStatement pstmt=con.prepareStatement("SELECT*FROM member");
		
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next()) {
			
			int no=rs.getInt(1);
			String id=rs.getString(2);
			String pwd=rs.getString(3);
			
			System.out.println("회원정보==> 번호 : "+no+",  id : "+id+",  pwd : "+pwd);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
	}

}
