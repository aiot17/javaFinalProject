package demo.userPackage.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import demo.userPackage.dao.PackageDAO;
import demo.userPackage.model.UserPackage;

public class UpdatePackageState extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdatePackageState() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PackageDAO packageDAO = new PackageDAO();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		int packageId = Integer.parseInt(request.getParameter("package_id"));
		System.out.println(packageId);
		UserPackage userPackage = new UserPackage(packageId);
		try {
			packageDAO.updatePackageState(userPackage);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("packagelist");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
