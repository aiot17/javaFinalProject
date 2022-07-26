package demo.admin.action;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import demo.admin.dao.AdminDAO;
import demo.admin.model.Admin;

import java.io.*;
import java.sql.SQLException;

public class CreateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAdmin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		AdminDAO adminDAO = new AdminDAO();
		
		String name = request.getParameter("name");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		Admin newAdmin = new Admin(name, account, password, email);
		try {
			adminDAO.insertAdmin(newAdmin);
		} catch (SQLException e) {
		}
		response.sendRedirect("listadmin");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
