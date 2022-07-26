package demo.rfid.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import demo.rfid.dao.RFIDDAO;

public class DeleteRFID extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteRFID() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RFIDDAO rfiddao = new RFIDDAO();
		int rfidId = Integer.parseInt(request.getParameter("RFID_id"));
		try {
			rfiddao.deleteRFID(rfidId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("RFIDList");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
