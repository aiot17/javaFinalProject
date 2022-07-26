package demo.userPackage.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import demo.userPackage.dao.PackageDAO;
import demo.userPackage.model.UserPackage;

public class CreatePackage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreatePackage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PackageDAO packageDAO = new PackageDAO();
		String userName = request.getParameter("userName");
		String userAddress = request.getParameter("userAddress");
		String packageNumber = request.getParameter("packageNumber");
		UserPackage userPackage = new UserPackage(userName, userAddress, packageNumber);
		
		try {
			packageDAO.createPackage(userPackage);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("packagelist");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
