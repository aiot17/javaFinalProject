package demo.userPackage.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import demo.userPackage.dao.PackageDAO;
import demo.userPackage.model.UserPackage;

public class SearchPackageByState extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchPackageByState() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PackageDAO packageDAO = new PackageDAO();
		int packageState = Integer.parseInt(request.getParameter("package_state"));
		System.out.println(packageState);
		List<UserPackage> packageList = packageDAO.searchPackageByState(packageState);
		request.setAttribute("packageList", packageList);
		request.getRequestDispatcher("package_list.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
