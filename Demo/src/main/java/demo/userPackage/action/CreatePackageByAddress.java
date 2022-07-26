package demo.userPackage.action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreatePackageByAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreatePackageByAddress() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userAddress = request.getParameter("user_address");
		System.out.println(userAddress);
		RequestDispatcher dispatcher = request.getRequestDispatcher("package_form.jsp");
		request.setAttribute("userAddress", userAddress);
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
