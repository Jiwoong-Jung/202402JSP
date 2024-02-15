package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Board;

public class BoardDao {
	private static Connection conn;
	private static BoardDao dao = new BoardDao();
	private BoardDao() {} // 생성자
	public static BoardDao getInstance() {
		BoardDao.getConnection();
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
	
	public ArrayList<Board> selectList() {
		ArrayList<Board> list = new ArrayList<>();
		String sql = "select * from board order by num desc";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Board board = new Board(rs.getInt("num"), rs.getString("writer"), 
						rs.getString("title"), rs.getString("content"),
						rs.getString("regtime"), rs.getInt("hits"));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Board selectOne(int num, boolean inc) {
		Board board = null;
		String sql = "select * from board where num = ?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				board = new Board(rs.getInt("num"), rs.getString("writer"), 
						rs.getString("title"), rs.getString("content"),
						rs.getString("regtime"), rs.getInt("hits"));

			}
			if (inc) {
				pstmt.executeUpdate("update board set hits=hits+1 where num="+num);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
		
	}
	
	public int delete(int num) {
		int result = 0;
		try ( 
		        PreparedStatement pstmt = conn.prepareStatement(
		        		"delete from board where num=" + num);
		    ) {
		        // 쿼리 실행
				result = pstmt.executeUpdate();
		        
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
		return result;
	}
	
	public int insert(Board board) {
		String sql = "insert into board(writer, title, content, regtime, hits) values (?,?,?,now(),0)";
	    try ( 
	        PreparedStatement pstmt = conn.prepareStatement(sql);            
	    ) {
	        // 현재 시간 얻기
//	        String curTime = LocalDate.now() + " " + 
//	                         LocalTime.now().toString().substring(0, 8);
	        
	        // 쿼리 실행
	    	pstmt.setString(1, board.getWriter());
	    	pstmt.setString(2, board.getTitle());
	    	pstmt.setString(3, board.getContent());
	        return pstmt.executeUpdate();
	    
	    } catch(Exception e) {
	        e.printStackTrace();
	    } 
		return 0;
	}
	
	public int update(Board board) {
		//
		return 0;
	}
	
}






