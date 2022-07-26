package demo.board.action;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import demo.board.dao.BoardDAO;
import demo.board.model.Board;

import java.io.*;


public class EditInfoForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditInfoForm() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		BoardDAO boardDAO = new BoardDAO();

		int id = Integer.parseInt(request.getParameter("id"));
		Board existingInfo = boardDAO.selectInfo(id);
		request.setAttribute("board", existingInfo);
		request.getRequestDispatcher("update_board.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
