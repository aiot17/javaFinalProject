package demo.board.action;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import demo.board.dao.BoardDAO;
import demo.board.model.Board;

import java.io.*;
import java.sql.SQLException;

public class CreateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		BoardDAO boardDAO = new BoardDAO();
		
		String date = request.getParameter("date");
		String title = request.getParameter("title");
		String info = request.getParameter("info");
		Board newBoard = new Board(date, title, info);
		try {
			boardDAO.insertBoard(newBoard);
		} catch (SQLException e) {
		}
		response.sendRedirect("listinfo");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
