package jp10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Example03 {

	public static void main(String[] args) throws Exception {
		
/*		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		Connection con=DriverManager.getConnection(url, "scott", "tiger");
		
		Statement stmt=con.createStatement();
		
		String id=args[0];
		
		String sql="DELETE FROM member WHERE id='"+id+"'";
		
		stmt.executeUpdate(sql);
		
		if(stmt !=null) {
			stmt.close();
		}
		if(con !=null) {
			con.close();
		}
*/
		
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection(url, "scott", "tiger");
		
		PreparedStatement pstmt=con.prepareStatement("DELETE FROM member WHERE id=?");
		
		String id=args[0];
		
		pstmt.setString(1, id);
		
		pstmt.executeUpdate();
		
		if(pstmt !=null) {
			pstmt.close();
		}
		if(con !=null) {
			con.close();
		}
		
	}

}
