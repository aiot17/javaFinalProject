package demo.rfid.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import demo.rfid.dao.RFIDDAO;
import demo.rfid.model.RFID;

public class SearchRFID extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchRFID() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		RFIDDAO rfidDao = new RFIDDAO();
		List<RFID> rfidList = rfidDao.searchRFIDList();
		
		request.setAttribute("rfidList", rfidList);
		request.getRequestDispatcher("rfid_list.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
