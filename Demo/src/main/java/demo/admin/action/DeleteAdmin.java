package demo.admin.action;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import demo.admin.dao.AdminDAO;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteAdmin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		AdminDAO adminDAO = new AdminDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			adminDAO.deleteAdmin(id);
		} catch (SQLException e) {
		}
		response.sendRedirect("listadmin");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
