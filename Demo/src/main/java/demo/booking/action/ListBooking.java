package demo.booking.action;

import jakarta.servlet.*;

import jakarta.servlet.http.*;
import demo.booking.dao.BookingDAO;
import demo.booking.model.Booking;

import java.io.*;
import java.util.*;

public class ListBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListBooking() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		BookingDAO bookingDAO = new BookingDAO();

		List<Booking> listBooking = bookingDAO.selectAllBookings();
		request.setAttribute("listBooking", listBooking);
		request.getRequestDispatcher("booking_list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
