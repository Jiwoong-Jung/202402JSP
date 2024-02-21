package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.Board;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String uri = request.getRequestURI();
			String path = uri.substring(uri.lastIndexOf("/"));
			if (path.equals("/list.do")) {
				BoardDao dao = BoardDao.getInstance();
				ArrayList<Board> list = dao.selectList();
				// 포워딩 작업
				request.setAttribute("list", list);
				RequestDispatcher dispatcher
				    = request.getRequestDispatcher("/WEB-INF/view/list.jsp");
				dispatcher.forward(request, response);
				
			} else if (path.equals("/view.do")) {
				int num = Integer.parseInt(request.getParameter("num"));
				BoardDao dao = BoardDao.getInstance();
				Board board = dao.selectOne(num, true);
				
				// 포워딩 작업
				request.setAttribute("bd", board);
				RequestDispatcher dispatcher
				    = request.getRequestDispatcher("/WEB-INF/view/view.jsp");
				dispatcher.forward(request, response);
			}
	}

}




