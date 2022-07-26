package demo.admin.action;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import demo.admin.dao.AdminDAO;
import demo.admin.model.Admin;

import java.io.*;
import java.sql.SQLException;

public class EditAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditAdmin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		AdminDAO adminDAO = new AdminDAO();		
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		Admin book = new Admin(id, name, account, password, email);
		try {
			adminDAO.updateAdmin(book);
		} catch (SQLException e) {
		}
		response.sendRedirect("admininfo?id=" + id);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
