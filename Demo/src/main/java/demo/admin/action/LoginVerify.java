package demo.admin.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import demo.admin.dao.AdminDAO;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginVerify() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		// 建立物件
		PrintWriter out = response.getWriter();
		AdminDAO adminDAO = new AdminDAO();

		// 宣告變數&取值
		String acc = request.getParameter("acc").toLowerCase();
		String passwd = request.getParameter("passwd");
		HttpSession session = request.getSession();
		String loginAcc = (String) session.getAttribute("loginAcc");

		if (adminDAO.loginVerify(acc, passwd) == true && !acc.equals("root")) {
			if (loginAcc == null || !loginAcc.equals(loginAcc)) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
				session.setAttribute("loginAcc", acc);
			} else {
				request.getRequestDispatcher("login.jsp").include(request, response);
				out.print("<h6 class='alert error_font'>此管理員已登入...");
			}
		} else if (adminDAO.loginVerify(acc, passwd) == true && acc.equals("root")) {
			session.setAttribute("root", acc);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("login.jsp").include(request, response);
			out.print("<h6 class='alert error_font'>管理員帳號或密碼錯誤...");
			out.print("<br />Wrong account or password...</h6>");
		}
	}
}
