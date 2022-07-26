package demo.admin.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import demo.admin.dao.AdminDAO;
import demo.admin.model.Admin;

public class AdminInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AdminInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		AdminDAO adminDAO = new AdminDAO();

		int id = Integer.parseInt(request.getParameter("id"));
		Admin existingAdmin = adminDAO.selectAdmin(id);
		request.setAttribute("admin", existingAdmin);
		request.getRequestDispatcher("admin_info.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
