package demo.admin.action;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import demo.admin.dao.AdminDAO;
import demo.admin.model.Admin;

import java.io.*;


public class EditAdminForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditAdminForm() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		AdminDAO adminDAO = new AdminDAO();

		int id = Integer.parseInt(request.getParameter("id"));
		Admin existingAdmin = adminDAO.selectAdmin(id);
		request.setAttribute("admin", existingAdmin);
		request.getRequestDispatcher("update_admin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
