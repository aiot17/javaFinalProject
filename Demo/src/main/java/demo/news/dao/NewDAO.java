package demo.news.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import demo.news.model.New;

public class NewDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=CST";
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private String jdbcUsername = "root";
	private String jdbcPassword = "12345678";
	
	private static final String SEARCH_NEWS_SQL = "SELECT * FROM news";


	public NewDAO() {
		super();
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public List<New> searchNews() {
		List<New> newsList = new ArrayList<New>();
		try {
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(SEARCH_NEWS_SQL);
			{
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					
					int newId = rs.getInt("new_id");
					String title = rs.getString("title");
					Date date = rs.getDate("date");
					String url = rs.getString("url");
					
					newsList.add(new New(newId, title, date, url));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newsList;
	
	}
	
}
