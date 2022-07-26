package demo.userPackage.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import demo.userPackage.dao.PackageDAO;
import demo.userPackage.model.UserPackage;

public class SearchPackage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchPackage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		PackageDAO packageDAO = new PackageDAO();
		
		List<UserPackage> packageList = packageDAO.searchPackageList();
		request.setAttribute("packageList", packageList);
		request.getRequestDispatcher("package_list.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
