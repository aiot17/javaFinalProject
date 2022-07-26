package demo.rfid.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import demo.rfid.dao.RFIDDAO;
import demo.rfid.model.RFID;

public class CreateRFID extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateRFID() {
        super();

    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		RFIDDAO rfiddao = new RFIDDAO();
		
		String userAddress = request.getParameter("address");
		String rfidName = request.getParameter("name");
		String rfidNum = request.getParameter("number");
		RFID rfid = new RFID(userAddress, rfidName, rfidNum);
		try {
			rfiddao.createRFID(rfid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("RFIDList");
	}

}
