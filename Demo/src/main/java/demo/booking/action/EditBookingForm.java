package demo.booking.action;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import demo.booking.dao.BookingDAO;
import demo.booking.model.Booking;

import java.io.*;


public class EditBookingForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditBookingForm() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		BookingDAO bookingDAO = new BookingDAO();

		int id = Integer.parseInt(request.getParameter("id"));
		Booking existingBooking = bookingDAO.selectBooking(id);
		request.setAttribute("booking", existingBooking);
		request.getRequestDispatcher("update_booking.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
