package mvc.hello;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import mvjsp.board.dao.MemberDao;
import mvjsp.board.model.Member;
import mvjsp.jdbc.connection.ConnectionProvider;

public class MemberFormHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return "/WEB-INF/view/memberForm.jsp";
	}

}
