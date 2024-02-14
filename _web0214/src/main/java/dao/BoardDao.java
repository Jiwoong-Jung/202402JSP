package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Board;

public class BoardDao {
	private static BoardDao dao = new BoardDao();
	private BoardDao() {} // 생성자
	public static BoardDao getInstance() {
		return dao;
	}
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
        		"jdbc:mysql://localhost:3306/project1", "root", "mysql");
		return conn;
	}
	
	public ArrayList<Board> selectList() {
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select * from board order by num desc";
		PreparedStatement pstmt;
		try {
			pstmt = this.getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Board board = new Board(rs.getInt("num"), rs.getString("writer"), 
						rs.getString("title"), rs.getString("content"),
						rs.getString("regtime"), 0);
				list.add(board);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
		
	}
	
}






