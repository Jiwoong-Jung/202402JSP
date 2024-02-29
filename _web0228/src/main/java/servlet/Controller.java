package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvjsp.board.dao.MemberDao;
import mvjsp.board.model.Member;
import mvjsp.jdbc.connection.ConnectionProvider;

/**
 * Servlet implementation class Controller
 */
//@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			process(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			process(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void process(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		if (path.equals("/list.do")) {
			Connection conn = ConnectionProvider.getConnection();
			MemberDao dao = MemberDao.getInstance();
			ArrayList<Member> list = dao.selectAll(conn);
			request.setAttribute("list", list);
			RequestDispatcher dispatcher 
			         = request.getRequestDispatcher("list_view.jsp");
			dispatcher.forward(request, response);
		} else if (path.equals("/memberForm.do")) {
			response.sendRedirect("memberForm.jsp");
		} else if (path.equals("/memberInput.do")) {
			String id = request.getParameter("id");
			String email = request.getParameter("email");
			String name = request.getParameter("name");
			Connection conn = ConnectionProvider.getConnection();
			MemberDao dao = MemberDao.getInstance();
			Member member = new Member(id, email, name);
			dao.insert(conn, member);
			response.sendRedirect("list.do");
		} else if (path.equals("/updateForm.do")) {
			String mno = request.getParameter("memberno");
			Connection conn = ConnectionProvider.getConnection();
			MemberDao dao = MemberDao.getInstance();
			Member member = dao.select(conn, Integer.parseInt(mno));
			request.setAttribute("member", member);
			RequestDispatcher dispatcher 
	         = request.getRequestDispatcher("updateForm_view.jsp");
			dispatcher.forward(request, response);
		} else if (path.equals("/memberUpdate.do")) {
			String mno = request.getParameter("memberno");
			String id = request.getParameter("id");
			String email = request.getParameter("email");
			String name = request.getParameter("name");
			Connection conn = ConnectionProvider.getConnection();
			MemberDao dao = MemberDao.getInstance();
			Member member = new Member(Integer.parseInt(mno), id, email, name);
			dao.update(conn, member);
			response.sendRedirect("list.do");
		} else if (path.equals("/memberDelete.do")) {
			String memberno = request.getParameter("memberno");
			Connection conn = ConnectionProvider.getConnection();
			MemberDao dao = MemberDao.getInstance();
			dao.delete(conn, Integer.parseInt(memberno));
			response.sendRedirect("list.do");
		}
	}

}







