package mvjsp.board.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mvjsp.jdbc.JdbcUtil;

public class BoardDao {
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}

	private BoardDao() {
	}
	
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from board");
			rs.next();
			return rs.getInt(1);
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
}
