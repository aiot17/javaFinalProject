package demo.rfid.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import demo.rfid.dao.RFIDDAO;
import demo.rfid.model.RFID;

public class SearchRFIDById extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchRFIDById() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		RFIDDAO rfidDao = new RFIDDAO();
		int rfidId = Integer.parseInt(request.getParameter("RFID_id"));
		RFID rfid = rfidDao.getRfidById(rfidId);
		
		request.setAttribute("rfid", rfid);
		request.getRequestDispatcher("rfid_form.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
