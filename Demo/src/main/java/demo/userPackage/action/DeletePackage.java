package demo.userPackage.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import demo.userPackage.dao.PackageDAO;


public class DeletePackage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeletePackage() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PackageDAO packageDAO = new PackageDAO();
		int packageId = Integer.parseInt(request.getParameter("package_id"));
		try {
			packageDAO.deletePackage(packageId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("packagelist");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
