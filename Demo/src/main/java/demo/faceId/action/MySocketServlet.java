/*
 * 
 * 
 * 如有需要使用，請將web.xml的MySocketServlet打開
 * 
 * 
*/
package demo.faceId.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import demo.faceId.model.FaceId;
import demo.faceId.model.Token;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

class SocketServer extends Thread {
	private Socket socket;
	
	public SocketServer(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			System.out.println("run");
			BufferedReader bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			String line = null;
			line = bfr.readLine(); // 抓到透過socket傳來的字串存至line變數
			System.out.println(line);

			FaceId.setFaceId(line);  // 將line變數存至靜態資料成員
			
			Token nToken = new Token();
			String token = nToken.verify();  // 產生token
			FaceId.setToken(token);
			System.out.println(token);
			
			pw.println(token);  // 將token回傳至socket
			pw.flush();
			bfr.close();
			pw.close();
			socket.close();
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}
	}
}

/**
 * Servlet implementation class MySocketServlet
 */
public class MySocketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MySocketServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		new Thread() {
			public void run() {
				try {
					ServerSocket server = new ServerSocket(30000);
					Socket socket = null;
					while (true) {
						socket = server.accept();
						SocketServer ss = new SocketServer(socket);
						ss.start();
					}
				} catch (IOException ex) {
					System.out.println(ex.getMessage());
				}
			}
		}.start();
		System.out.println("_______________________hello world___________________________");
	}
}