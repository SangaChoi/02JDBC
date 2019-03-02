package jp10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Example02 {

	public static void main(String[] args) throws Exception{
		
/*		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		Class.forName(driver);
		
		Connection con=DriverManager.getConnection(url, "scott", "tiger");
		
		Statement stmt=con.createStatement();
		
		String no=args[0];
		String id=args[1];
		String pwd=args[2];
		
		String sql1="INSERT INTO member VALUES('"+no+"','"+id+"','"+pwd+"')";
		
		stmt.executeUpdate(sql1);
		
		if(stmt !=null) {
			stmt.close();
		}
		if(con !=null) {
			con.close();
		}
*/
		
		if(args.length !=3) {
			System.out.println("no, id, pwd°ª");
			return;
		}
		
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection(url, "scott", "tiger");
		
		PreparedStatement pstmt=con.prepareStatement("INSERT INTO member VALUES(?,?,?)");
		
		int no=Integer.parseInt(args[0]);
		String id=args[1];
		String pwd=args[2];
		
		pstmt.setInt(1, no);
		pstmt.setString(2, id);
		pstmt.setString(3, pwd);
		
		pstmt.executeUpdate();
		
		if(pstmt !=null) {
			pstmt.close();
		}
		if(con !=null) {
			con.close();
		}
		

	}

}
