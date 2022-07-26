package demo.admin.action;

import jakarta.servlet.*;

import jakarta.servlet.http.*;
import demo.admin.dao.AdminDAO;
import demo.admin.model.Admin;

import java.io.*;
import java.util.*;

public class ListAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListAdmin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		AdminDAO adminDAO = new AdminDAO();

		List<Admin> listAdmin = adminDAO.selectAllAdmins();
		request.setAttribute("listAdmin", listAdmin);
		request.getRequestDispatcher("admin_list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
