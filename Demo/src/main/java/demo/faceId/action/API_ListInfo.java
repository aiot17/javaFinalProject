package demo.faceId.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import demo.board.dao.BoardDAO;
import demo.board.model.Board;

public class API_ListInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public API_ListInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		BoardDAO boardDAO = new BoardDAO();

		List<Board> listInfo = boardDAO.selectDataAfterNow();
		request.setAttribute("listInfo", listInfo);
		request.getRequestDispatcher("api_info_list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
