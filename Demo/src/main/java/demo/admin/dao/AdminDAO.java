package demo.admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demo.admin.model.Admin;

public class AdminDAO {
	// 資料庫連線資料
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=CST";
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private String jdbcUsername = "root";
	private String jdbcPassword = "12345678";

	// MySQL控制語法
	private static final String SELECT_ALL_ADMINS = "select * from admin";
	private static final String SELECT_ADMIN_BY_ACCOUNT_AND_PASSWORD = "select * from admin where account= ? and password=?";
	private static final String SELECT_ADMIN_BY_ID = "select id,name,account,password,email from admin where id = ?";
	private static final String UPDATE_ADMIN_SQL = "update admin set name = ?, account = ?, password = ?, email= ? where id = ?;";
	private static final String INSERT_ADMIN_SQL = "INSERT INTO admin"
			+ "  (name, account, password, email) VALUES " + " (?, ?, ?, ?);";
	private static final String DELETE_ADMIN_SQL = "delete from admin where id = ?;";

	public AdminDAO() {
	}

	// 建立連線MySQL資料庫
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
	
	// 管理員清單
	public List<Admin> selectAllAdmins() {

		List<Admin> admins = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADMINS);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String account = rs.getString("account");
				String password = rs.getString("password");
				String email = rs.getString("email");
				admins.add(new Admin(id, name, account, password, email));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return admins;
	}
	
	// 查詢個別管理員資料
	public Admin selectAdmin(int id) {
		Admin admin = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADMIN_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				String account = rs.getString("account");
				String password = rs.getString("password");
				String email = rs.getString("email");
				admin = new Admin(id, name, account, password, email);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return admin;
	}
	
	// 編輯個別管理員資訊
	public boolean updateAdmin(Admin admin) throws SQLException {
		boolean rowUpdated;
		
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_ADMIN_SQL);) {
			statement.setString(1, admin.getName());
			statement.setString(2, admin.getAccount());
			statement.setString(3, admin.getPassword());
			statement.setString(4, admin.getEmail());
			statement.setInt(5, admin.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	// 新增管理員
	public void insertAdmin(Admin admin) throws SQLException {
		System.out.println(INSERT_ADMIN_SQL);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADMIN_SQL)) {
			preparedStatement.setString(1, admin.getName());
			preparedStatement.setString(2, admin.getAccount());
			preparedStatement.setString(3, admin.getPassword());
			preparedStatement.setString(4, admin.getEmail());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	// 移除個別管理員資料
	public boolean deleteAdmin(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_ADMIN_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	// 帳號驗證
	public boolean loginVerify(String acc, String pass) {
		boolean verify = true;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(SELECT_ADMIN_BY_ACCOUNT_AND_PASSWORD);) {
			preparedStatement.setString(1, acc);
			preparedStatement.setString(2, pass);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				verify = true;
			} else {
				verify = false;
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return verify;
	}

	// 錯誤處理
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
