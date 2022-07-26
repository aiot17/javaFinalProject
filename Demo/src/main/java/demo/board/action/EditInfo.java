package demo.board.action;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import demo.board.dao.BoardDAO;
import demo.board.model.Board;

import java.io.*;
import java.sql.SQLException;

public class EditInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditInfo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		BoardDAO boardDAO = new BoardDAO();		
		
		int id = Integer.parseInt(request.getParameter("id"));
		String date = request.getParameter("date");
		String title = request.getParameter("title");
		String info = request.getParameter("info");
		Board book = new Board(id, date, title, info);
		try {
			boardDAO.updateBoard(book);
		} catch (SQLException e) {
		}
		response.sendRedirect("showinfo?id=" + id);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
