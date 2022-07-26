package demo.board.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import demo.board.dao.BoardDAO;
import demo.board.model.Board;

public class ShowInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ShowInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		BoardDAO boardDAO = new BoardDAO();

		int id = Integer.parseInt(request.getParameter("id"));
		Board existingInfo = boardDAO.selectInfo(id);
		request.setAttribute("board", existingInfo);
		request.getRequestDispatcher("showinfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
