package demo.booking.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import demo.booking.dao.BookingDAO;
import demo.booking.model.Booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class SiteVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SiteVerify() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
//		request.setAttribute("sites", sites);
		out.print("<div class='title site_title'>場地選擇 / Site Select</div>\n");
		out.print("<div class='box site_box'>\n");
		out.print("<table>\n");
		out.print("<tr><th>時段<br />Time Period</th><th class='action'>動作<br />Action</th></tr>\n");
		for (int i = 0; i < sites.size();i++) {
			if (sites.get(i).getVerify() == true) {
				out.print("<tr><td>" + sites.get(i).getPeriod() + "</td><td>已預定 / Booked</td></tr>\n");
			}else {
				out.print("<tr><td>" + sites.get(i).getPeriod() + "</td><td class='action'><button class='btn'>選擇 / Select</button></td></tr>\n");
			}
		}
		out.print("</table>\n");
		out.print("</div>\n");
		out.print("<script>$(\".action\").click(function() {\r\n"
		+ "var site_info = $(this).prev().text()\r\n"
		+ "$('input[name=\"site\"]').val(site_info);\r\n"
		+ "$('.box2').html(' ');\n"
		+ "})</script>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
