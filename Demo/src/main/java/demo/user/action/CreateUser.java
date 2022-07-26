package demo.user.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import demo.user.dao.UserDAO;
import demo.user.model.User;


public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateUser() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		String userName = request.getParameter("userName");
		String userFaceId = request.getParameter("userFaceId");
		String userAddress = request.getParameter("userAddress");
		String userTel = request.getParameter("userTel");
		User user = new User(userName, userFaceId, userAddress, userTel);
		try {
			userDAO.createUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("userlist");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
