package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Bean.PttPushes;

public class PushDao {
	
	String url = "jdbc:sqlserver://localhost:1433;databaseName=MessageQueue";
	String user = "sa";
	String password = "password";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	public void insertData(PttPushes ptt) throws SQLException {
		try {
			String sql = "insert into dbo.PttPush(Push, Userid, PushContent, Ipdatetime) values (?, ?, ?, ?)";
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, ptt.getPush());
			pstmt.setString(2, ptt.getUserid());
			pstmt.setString(3, ptt.getContent());
			pstmt.setString(4, ptt.getIpdatetime());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			conn.close();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;databaseName=MessageQueue";
			String user = "sa";
			String password = "password";
			
			String sql = "insert into dbo.PttPush(Push, Userid, PushContent, Ipdatetime) values (?, ?, ?, ?)";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
			pstmt = conn.prepareStatement(sql);
			
			PttPushes ptt = new PttPushes();
			ptt.setPush("推");
			ptt.setUserid("ArtShen");
			ptt.setContent("MAPPA我大哥 MAPPA 我的超人 謝謝MAPPA");
			ptt.setIpdatetime("04/04 21:40");
			
			pstmt.setString(1, ptt.getPush());
			pstmt.setString(2, ptt.getUserid());
			pstmt.setString(3, ptt.getContent());
			pstmt.setString(4, ptt.getIpdatetime());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmt.close();
			conn.close();
		}
	}
}
