package demo.faceId.action;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import demo.faceId.model.FaceId;
import demo.faceId.model.Token;

public class Pi extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Pi() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String faceId = request.getParameter("user");
		System.out.println("阿仁哥傳來的辨識結果："+faceId);
		FaceId.setFaceId(faceId);
		
		Token nToken = new Token();
		String token = nToken.verify();
		FaceId.setToken(token);
		
		PrintWriter pw = response.getWriter();
		pw.print(token);
		System.out.println(token);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
