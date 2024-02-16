package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MemberDao {
	private static Connection conn;
	private static MemberDao dao = new MemberDao();
	private MemberDao() {} // 생성자
	public static MemberDao getInstance() {
		MemberDao.getConnection();
		return dao;
	}
	
	private static void getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
	        		"jdbc:mysql://localhost:3306/project1", "root", "mysql");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}		
	}
}
