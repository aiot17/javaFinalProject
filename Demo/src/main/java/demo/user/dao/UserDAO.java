package demo.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import demo.user.model.User;

public class UserDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=CST";
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private String jdbcUsername = "root";
	private String jdbcPassword = "12345678";

	// 新增住戶
	private static final String INSERT_USER_SQL = "INSERT INTO user"
			+ " (user_name, facial_recognition, user_address, user_tel, created_date, last_modified_date) values " + "(?, ?, ?, ?, ?, ?);";
	// 修改住戶資料(根據user_id)
	private static final String UPDATE_USER_SQL = "UPDATE user SET user_name = ?, facial_recognition = ?, user_address = ?, user_tel = ?, last_modified_date = ? WHERE user_id = ?;";
	// 刪除住戶(根據user_id)
	private static final String DELETE_USER_SQL = "DELETE FROM user WHERE user_id = ?;";
	// 查詢所有住戶資料
	private static final String SELECT_USER_SQL = "SELECT * FROM user;";
	// 查詢住戶資料(根據user_id)
	private static final String SELECT_USER_BY_USERID = "SELECT * FROM user WHERE user_id = ?";
	// 查詢住戶資料(根據user_name)
	private static final String SELECT_USER_BY_NAME = "SELECT * FROM user WHERE user_name LIKE ?";
	// 查詢住戶資料(根據user_address)
	private static final String SELECT_USER_BY_ADDRESS = "SELECT * FROM user WHERE user_address LIKE ?";
	// 查詢住戶資料(根據人臉識別名稱)
	private static final String SELECT_USER_BY_USERSTRING = "SELECT * FROM user WHERE facial_recognition = ?";
	
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

//	INSERT_USER_SQL = "INSERT INTO user" + " 
//	(user_name, user_address, user_tel, created_date, last_modified_date) 
//	values " + "(?, ?, ?, ?, ?);";

	// 新增住戶資料
	public void createUser(User user) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(INSERT_USER_SQL)) {
			ps.setString(1, user.getUser_name());
			ps.setString(2, user.getFacial_recognition());
			ps.setString(3, user.getUser_address());
			ps.setString(4, user.getUser_tel());
			Long datetime = System.currentTimeMillis();
			Timestamp timestamp = new Timestamp(datetime);
			ps.setTimestamp(5, timestamp);
			ps.setTimestamp(6, timestamp);
			ps.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	// 查詢所有住戶資料
	public List<User> searchUserList() {
		List<User> userList = new ArrayList<User>();
		try {
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(SELECT_USER_SQL);
			{
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					int userId = rs.getInt("user_id");
					String userName = rs.getString("user_name");
					String userFaceId = rs.getString("facial_recognition");
					String userAddress = rs.getString("user_address");
					String userTel = rs.getString("user_tel");
					Timestamp createdDate = rs.getTimestamp("created_date");
					Timestamp lastModifiedDate = rs.getTimestamp("last_modified_date");
					userList.add(new User(userId, userName, userFaceId, userAddress, userTel, createdDate, lastModifiedDate));
				}
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return userList;
	}

	// 透過user_id查詢住戶資料
	public User searchUserById(int userId) {
		User user = null;
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_USERID);) 
		{
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String userName = rs.getString("user_name");
				String userFaceId = rs.getString("facial_recognition");
 				String userAddress = rs.getString("user_address");
				String userTel = rs.getString("user_tel");
				Timestamp createdDate = rs.getTimestamp("created_date");
				Timestamp lastModifiedDate = rs.getTimestamp("last_modified_date");
				user = new User(userId, userName, userFaceId, userAddress, userTel, createdDate, lastModifiedDate);
			}
		} catch (Exception e) {
		}
		return user;
	}

	// 透過user_name查詢住戶資料
	public List<User> searchUserByName(String searchName) {
		List<User> userList = new ArrayList<User>();
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_NAME);) {
			ps.setString(1, "%" + searchName + "%");
			System.out.println(searchName);
			ResultSet rs = ps.executeQuery();
			if (searchName == "") {
				userList = null;
				System.out.println(userList);
				return userList;
			}
			while (rs.next()) {
				int userId = rs.getInt("user_id");
				String userName = rs.getString("user_name");
				String userFaceId = rs.getString("facial_recognition");
				String userAddress = rs.getString("user_address");
				String userTel = rs.getString("user_tel");
				Timestamp createdDate = rs.getTimestamp("created_date");
				Timestamp lastModifiedDate = rs.getTimestamp("last_modified_date");
				userList.add(new User(userId, userName, userFaceId, userAddress, userTel, createdDate, lastModifiedDate));
			}
		} catch (Exception e) {
		}
		if (userList.size() == 0) {
			userList = null;
		}
		return userList;
	}

	// 透過user_address查詢住戶資料
	public List<User> searchUserByAddress(String searchAddress) {
		List<User> userList = new ArrayList<User>();
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_ADDRESS);) {
			ps.setString(1, "%" + searchAddress + "%");
			ResultSet rs = ps.executeQuery();
			if (searchAddress == "") {
				userList = null;
				return userList;
			}
			while (rs.next()) {
				int userId = rs.getInt("user_id");
				String userName = rs.getString("user_name");
				String userFaceId = rs.getString("facial_recognition");
				String userAddress = rs.getString("user_address");
				String userTel = rs.getString("user_tel");
				Timestamp createdDate = rs.getTimestamp("created_date");
				Timestamp lastModifiedDate = rs.getTimestamp("last_modified_date");
				userList.add(new User(userId, userName, userFaceId, userAddress, userTel, createdDate, lastModifiedDate));
			}
		} catch (Exception e) {
		}
		if (userList.size() == 0) {
			userList = null;
		}
		return userList;
	}

	// 透過人臉辨識名稱查詢住戶資料
	public User searchUserFacialRecognition(String userString) {
		User user = null;
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_USERSTRING);) {
			ps.setString(1, userString);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int userId = rs.getInt("user_id");
				String userName = rs.getString("user_name");
				String userAddress = rs.getString("user_address");
				String userTel = rs.getString("user_tel");
				Timestamp createdDate = rs.getTimestamp("created_date");
				Timestamp lastModifiedDate = rs.getTimestamp("last_modified_date");
				user = new User(userId, userName, userString, userAddress, userTel, createdDate, lastModifiedDate);
			}
		} catch (Exception e) {
		}
		return user;
	}

	// 修改住戶資料
	public boolean updateProduct(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(UPDATE_USER_SQL);) {
			ps.setString(1, user.getUser_name());
			ps.setString(2, user.getFacial_recognition());
			ps.setString(3, user.getUser_address());
			ps.setString(4, user.getUser_tel());
			Long datetime = System.currentTimeMillis();
			Timestamp timestamp = new Timestamp(datetime);
			ps.setTimestamp(5, timestamp);
			ps.setInt(6, user.getUser_id());
			rowUpdated = ps.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	// 刪除住戶資料
	public boolean deleteUser(int userId) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(DELETE_USER_SQL);) {
			ps.setInt(1, userId);
			rowDeleted = ps.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	private void printSQLException(SQLException e) {
		// TODO Auto-generated method stub

	}
}
