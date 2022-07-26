package demo.booking.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import demo.booking.dao.BookingDAO;

public class DeleteBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteBooking() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		BookingDAO bookingDAO = new BookingDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			bookingDAO.deleteBooking(id);
		} catch (SQLException e) {
		}
		response.sendRedirect("listbooking");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}