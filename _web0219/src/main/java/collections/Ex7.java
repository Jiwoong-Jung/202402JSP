package collections;

import java.util.List;

import dao.BoardDao;
import dto.Board;

public class Ex7 {

	public static void main(String[] args) {
		BoardDao dao = BoardDao.getInstance();
		List<Board> list = dao.selectList();
		list.stream().forEach(b->{
			System.out.println(b.getTitle()
					          +"-"+b.getContent());
		});
		
//		for (Board board : list) {
//			System.out.println(board.getTitle()+
//		                      "-"+board.getContent());
//		}

	}

}
