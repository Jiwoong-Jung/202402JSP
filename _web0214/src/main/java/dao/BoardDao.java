package dao;

public class BoardDao {
	private static BoardDao dao = new BoardDao();
	private BoardDao() {} // 생성자
	public static BoardDao getInstance() {
		return dao;
	}
}
