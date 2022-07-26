package demo.rfid.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import demo.rfid.dao.RFIDDAO;
import demo.rfid.model.RFID;

public class UpdateRFID extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateRFID() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		RFIDDAO rfidDao = new RFIDDAO();
		
		
		int rfidId = Integer.parseInt(request.getParameter("rfidId"));
		String rfidAddress = request.getParameter("address");
		String rfidName = request.getParameter("name");
		String rfidNum = request.getParameter("number");
		
		RFID rfid = new RFID(rfidId, rfidAddress, rfidName, rfidNum);
		try {
			rfidDao.updateRFID(rfid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("RFIDList");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
