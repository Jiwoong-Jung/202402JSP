package mvjsp.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mvjsp.board.model.Member;
import mvjsp.jdbc.JdbcUtil;

public class MemberDao {
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}

	private MemberDao() {
	}
	
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from member");
			rs.next();
			return rs.getInt(1);
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	public ArrayList<Member> selectAll(Connection conn) {
		ArrayList<Member> list = new ArrayList<>();
		String sql = "select * from member";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Member member = new Member(rs.getInt("memberno"),
						rs.getString("id"),
						rs.getString("email"),
						rs.getString("name"));
				list.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return list;
	}
	
	public int insert(Connection conn, Member member) {
		String sql = "insert into member(memberno, id, email, name) values (seq_member.nextval,?,?,?)";
	    try ( 
	        PreparedStatement pstmt = conn.prepareStatement(sql);            
	    ) {
	        
	        // 쿼리 실행
	    	pstmt.setString(1, member.getId());
	    	pstmt.setString(2, member.getEmail());
	    	pstmt.setString(3, member.getName());
	        return pstmt.executeUpdate();
	    
	    } catch(Exception e) {
	        e.printStackTrace();
	    } 
		return 0;
	}
	
	public int update(Connection conn, Member member) {
		String sql = "update member set email = ?, name = ? where memberno = ?";
	    try ( 
	        PreparedStatement pstmt = conn.prepareStatement(sql);            
	    ) {
	        
	        // 쿼리 실행
	    	pstmt.setInt(3, member.getMemberno());
	    	pstmt.setString(1, member.getEmail());
	    	pstmt.setString(2, member.getName());
	        return pstmt.executeUpdate();
	    
	    } catch(Exception e) {
	        e.printStackTrace();
	    } 
		return 0;
	}
	
	public int delete(Connection conn, Member member) {
		String sql = "delete from member where memberno = ?";
	    try ( 
	        PreparedStatement pstmt = conn.prepareStatement(sql);            
	    ) {
	        
	        // 쿼리 실행
	    	pstmt.setInt(1, member.getMemberno());
	        return pstmt.executeUpdate();
	    
	    } catch(Exception e) {
	        e.printStackTrace();
	    } 
		return 0;
	}
	
	public Member select(Connection conn, int memberno) {
		Member member = null;
		ResultSet rs = null;
		String sql = "select * from member where memberno = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {	
			pstmt.setInt(1, memberno);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				member = new Member(rs.getInt("memberno"),
						            rs.getString("id"),
						            rs.getString("email"),
						            rs.getString("name"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
		}
		return member;
		
	}
}





