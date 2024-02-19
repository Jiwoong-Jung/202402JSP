package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.Board;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 지정된 글 번호 얻기
	    int num = Integer.parseInt(request.getParameter("num")); 

		// 게시글 데이터를 담을 변수 정의
		String writer  = "";
		String title   = "";
		String content = "";
		String regtime = "";
		int    hits    = 0;
		
	/*	String memberId = (String)session.getAttribute("MEMBERID");
		if (memberId == null) {
			response.sendRedirect("sessionLoginForm.jsp");
		}*/
		BoardDao dao = BoardDao.getInstance();
		Board board = dao.selectOne(num, true);
		
	    request.setAttribute("board", board);
	    RequestDispatcher dispatcher 
	       = request.getRequestDispatcher("/WEB-INF/view/view.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
