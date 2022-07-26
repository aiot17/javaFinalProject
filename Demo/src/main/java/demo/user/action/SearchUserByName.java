package demo.user.action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import demo.user.dao.UserDAO;
import demo.user.model.User;

public class SearchUserByName extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchUserByName() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		String userName = request.getParameter("user_name");
		System.out.println("byName"+userName);
		
		List<User> userList = userDAO.searchUserByName(userName);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user_list.jsp");
		request.setAttribute("userList", userList);
		dispatcher.forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
