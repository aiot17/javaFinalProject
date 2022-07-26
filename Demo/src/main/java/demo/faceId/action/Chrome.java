package demo.faceId.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import demo.faceId.dao.FaceIdDAO;
import demo.faceId.model.FaceId;
import demo.user.dao.UserDAO;
import demo.user.model.User;

public class Chrome extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Chrome() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		UserDAO userDao = new UserDAO();
		FaceIdDAO faceIdDAO = new FaceIdDAO();
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		
		String token = request.getParameter("user");
		
		System.out.println("大衛傳過來的:"+token);	
		
		if(FaceId.getToken().equals(token)) {
			System.out.println("比對成功");
			String faceId = FaceId.getFaceId();

		    User user = userDao.searchUserFacialRecognition(faceId);
		    
		    int total = faceIdDAO.countPackage(user.getUser_address());
		    session.setAttribute("total", total);
			System.out.println(user.getUser_name());
			session.setAttribute("user", user);
			System.out.println("將登入者的資訊存入session");
			response.sendRedirect("mainPageLogin.jsp");
		}else {
			System.out.println("比對失敗...");
			pw.println("比對失敗，請洽管理員");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
