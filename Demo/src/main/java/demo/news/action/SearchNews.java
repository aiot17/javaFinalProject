package demo.news.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import demo.news.action.SearchNews;
import demo.news.dao.NewDAO;
import demo.news.model.New;

public class SearchNews extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchNews() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NewDAO newDAO = new NewDAO();
		
		request.setCharacterEncoding("UTF-8");
		response.setIntHeader("Refresh", 300);
		response.setContentType("text/html;charset=utf-8");
		System.out.println("測試時間");
		Date now = new Date();
		System.out.println(now);
		List<New> newsList = newDAO.searchNews();
		
		request.setAttribute("newsList", newsList);
		request.getRequestDispatcher("news_list.jsp").include(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}
