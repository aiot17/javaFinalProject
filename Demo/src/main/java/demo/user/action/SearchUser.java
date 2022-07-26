package demo.user.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import demo.user.dao.UserDAO;
import demo.user.model.User;

public class SearchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SearchUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		UserDAO userDAO = new UserDAO();
		
		List<User> userList = userDAO.searchUserList();
		List<User> users = new ArrayList<User>();
		for (var user : userList) {
			var createdDateStr = user.getCreated_date().toString().substring(0, 19);
			user.setCreatedDateStr(createdDateStr);
			users.add(user);
		}
		request.setAttribute("userList", users);
		request.getRequestDispatcher("user_list.jsp").include(request, response);
		// ¤º³¡Âà§}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
