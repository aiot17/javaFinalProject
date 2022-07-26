package demo.userPackage.action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import demo.userPackage.dao.PackageDAO;
import demo.userPackage.model.UserPackage;

public class SearchPackageById extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchPackageById() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PackageDAO packageDAO = new PackageDAO();
		int packageId = Integer.parseInt(request.getParameter("package_id"));

		UserPackage packageList = packageDAO.searchPackageById(packageId);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("package_form.jsp");
		request.setAttribute("aPackage", packageList);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
