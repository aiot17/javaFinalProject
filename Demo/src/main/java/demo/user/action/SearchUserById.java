package demo.user.action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import demo.user.dao.UserDAO;
import demo.user.model.User;

public class SearchUserById extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchUserById() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAO userDAO = new UserDAO();
		int userId = Integer.parseInt(request.getParameter("user_id"));
		System.out.println("UserByID");
		User user = userDAO.searchUserById(userId);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("user_form.jsp");
		request.setAttribute("user", user);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
