package demo.booking.action;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import demo.booking.dao.BookingDAO;
import demo.booking.model.Booking;

import java.io.*;
import java.sql.SQLException;

public class CreateBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateBooking() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		BookingDAO bookingDAO = new BookingDAO();
		
		String user_name = request.getParameter("user_name");
		String activity = request.getParameter("activity");
		String date = request.getParameter("date");
		String site = request.getParameter("site");
		Booking newBooking = new Booking(user_name, activity, date, site);
		try {
			bookingDAO.insertBooking(newBooking);
		} catch (SQLException e) {
		}
		response.sendRedirect("listbooking");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
