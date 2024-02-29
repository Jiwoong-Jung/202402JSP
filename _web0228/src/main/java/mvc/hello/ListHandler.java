package mvc.hello;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import mvjsp.board.dao.MemberDao;
import mvjsp.board.model.Member;
import mvjsp.jdbc.connection.ConnectionProvider;

public class ListHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = ConnectionProvider.getConnection();
		MemberDao dao = MemberDao.getInstance();
		ArrayList<Member> list = dao.selectAll(conn);
		req.setAttribute("list", list);
		return "/WEB-INF/view/list_view.jsp";
	}

}
