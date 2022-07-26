package demo.booking.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import demo.user.dao.UserDAO;
import demo.user.model.User;

public class UserSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserSelect() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		UserDAO userDAO = new UserDAO();
		
		List<User> userList = userDAO.searchUserList();
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("user_select.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
