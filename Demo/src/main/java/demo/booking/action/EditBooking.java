package demo.booking.action;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import demo.booking.dao.BookingDAO;
import demo.booking.model.Booking;

import java.io.*;
import java.sql.SQLException;

public class EditBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditBooking() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		BookingDAO bookingDAO = new BookingDAO();		
		
		int id = Integer.parseInt(request.getParameter("id"));
		String user_name = request.getParameter("user_name");
		String activity = request.getParameter("activity");
		String date = request.getParameter("date");
		String site = request.getParameter("site");
		Booking book = new Booking(id, user_name, activity, date, site);
		try {
			bookingDAO.updateBooking(book);
		} catch (SQLException e) {
		}
		response.sendRedirect("listbooking");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
