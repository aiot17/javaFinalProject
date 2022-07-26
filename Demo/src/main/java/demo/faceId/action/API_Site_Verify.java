package demo.faceId.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import demo.booking.dao.BookingDAO;
import demo.booking.model.Booking; 

public class API_Site_Verify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public API_Site_Verify() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		BookingDAO bookingDAO = new BookingDAO();

		String activity = request.getParameter("activity");
		String date = request.getParameter("date");
		String period;
		
		List<Booking> sites = new ArrayList<>();
		for (int i = 8; i <= 20; i += 2) {
			period = (i + ":00 - " + (i + 2) + ":00");
			Boolean verify = bookingDAO.siteVerify(period, activity, date);
			sites.add(new Booking(period, verify));	
		}
		request.setAttribute("sites", sites);
		request.getRequestDispatcher("api_site_verify.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
