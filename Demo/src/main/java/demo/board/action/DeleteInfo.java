package demo.board.action;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import demo.board.dao.BoardDAO;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteInfo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		BoardDAO boardDAO = new BoardDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			boardDAO.deleteBoard(id);
		} catch (SQLException e) {
		}
		response.sendRedirect("listinfo");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
