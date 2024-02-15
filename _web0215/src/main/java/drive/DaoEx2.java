package drive;

import java.util.List;

import dao.BoardDao;
import dto.Board;

public class DaoEx2 {

	public static void main(String[] args) {
		BoardDao dao = BoardDao.getInstance();
		List<Board> list = dao.selectList(); // selectList() 호출해 보세요.
		// list에 들어있는 객체들을 출력해 보세요.
		list.stream().forEach(s->{
			System.out.println(s.getWriter());
		});
//		for (Board board : list) {
//			System.out.println(board.getWriter());
//		}
	}

}
