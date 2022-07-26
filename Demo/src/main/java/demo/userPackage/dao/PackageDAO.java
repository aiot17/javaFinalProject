package demo.userPackage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.oracle.wls.shaded.java_cup.runtime.Scanner;

import demo.userPackage.model.UserPackage;

public class PackageDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=CST";
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private String jdbcUsername = "root";
	private String jdbcPassword = "12345678";

	// 搜尋包裹
	private static final String SELECT_PACKAGE_SQL = "SELECT * FROM package ORDER BY created_date DESC;";
	// 搜尋包裹(透過package_id)
	private static final String SELECT_PACKAGE_BY_ID = "SELECT * FROM package WHERE package_id = ?;";
	// 搜尋包裹(透過package_state)
	private static final String SELECT_PACKAGE_BY_STATE = "SELECT * FROM package WHERE package_state = ?;";
	// 新增包裹
	private static final String INSERT_PACKAGE_SQL = "INSERT INTO package"
			+ " (user_address, user_name, package_number, package_state, created_date, last_modified_date) values "
			+ "(?, ?, ?, ?, ?, ?);";
	// 修改包裹資訊(透過package_id)
	private static final String UPDATE_PACKAGE_SQL = "UPDATE package SET user_address = ?, user_name = ?, package_number = ?, last_modified_date = ? WHERE package_id = ?";
	// 修改包裹狀態(透過package_id)
	private static final String UPDATE_PACKAGE_STATE_SQL = "UPDATE package SET package_state = ?, last_modified_date = ? WHERE package_id = ?;";
	// 刪除包裹(透過package_id)
	private static final String DELETE_PACKAGE_SQL = "DELETE FROM package WHERE package_id = ?;";
	// 搜尋包裹(透過地址)
	private static final String SELECT_PACKAGE_BY_ADDRESS = "SELECT * FROM package WHERE user_address = ? ORDER BY package_state;";
	
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

	public List<UserPackage> searchPackageList() {
		List<UserPackage> packageList = new ArrayList<UserPackage>();

		try {
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(SELECT_PACKAGE_SQL);
			{
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					int packageId = rs.getInt("package_id");
					String userAddress = rs.getString("user_address");
					String userName = rs.getString("user_name");
					String packageNumber = rs.getString("package_number");
					int packageState = rs.getInt("package_state");
					Timestamp createdDate = rs.getTimestamp("created_date");
					Timestamp lastModifiedDate = rs.getTimestamp("last_modified_date");

					packageList.add(new UserPackage(packageId, userAddress, userName, packageNumber, packageState,
							createdDate, lastModifiedDate));
				}
			}
		} catch (SQLException e) {
			printSQLException(e);
		}

		return packageList;
	}
	// 搜尋包裹(透過地址)
	public List<UserPackage> searchPackageByAddress(String userAddress) {
		List<UserPackage> packageList = new ArrayList<UserPackage>();
		try {
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(SELECT_PACKAGE_BY_ADDRESS);
			{
				ps.setString(1, userAddress);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					int packageId = rs.getInt("package_id");
					int packageState = rs.getInt("package_state");
					String userName = rs.getString("user_name");
					String packageNumber = rs.getString("package_number");
					Timestamp createdDate = rs.getTimestamp("created_date");
					Timestamp lastModifiedDate = rs.getTimestamp("last_modified_date");
					packageList.add(new UserPackage(packageId, userAddress, userName, packageNumber, packageState,
							createdDate, lastModifiedDate));
				}
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return packageList;
	}

	public UserPackage searchPackageById(int packageId) {
		UserPackage pagckage = null;
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(SELECT_PACKAGE_BY_ID);) {
			ps.setInt(1, packageId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String userName = rs.getString("user_name");
				String userAddress = rs.getString("user_address");
				String packageNumber = rs.getString("package_number");
				pagckage = new UserPackage(packageId, userAddress, userName, packageNumber);
			}
		} catch (Exception e) {
		}
		return pagckage;
	}

	public List<UserPackage> searchPackageByState(int packageState) {
		List<UserPackage> packageList = new ArrayList<UserPackage>();
		try {
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(SELECT_PACKAGE_BY_STATE);
			{
				ps.setInt(1, packageState);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					int packageId = rs.getInt("package_id");
					String userAddress = rs.getString("user_address");
					String userName = rs.getString("user_name");
					String packageNumber = rs.getString("package_number");
					Timestamp createdDate = rs.getTimestamp("created_date");
					Timestamp lastModifiedDate = rs.getTimestamp("last_modified_date");
					packageList.add(new UserPackage(packageId, userAddress, userName, packageNumber, packageState,
							createdDate, lastModifiedDate));
				}
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return packageList;
	}

	public void createPackage(UserPackage userPackage) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(INSERT_PACKAGE_SQL)) {
			ps.setString(1, userPackage.getUser_name());
			ps.setString(2, userPackage.getUser_address());
			ps.setString(3, userPackage.getPackage_number());
			ps.setInt(4, 0);
			Long datetime = System.currentTimeMillis();
			Timestamp timestamp = new Timestamp(datetime);
			ps.setTimestamp(5, timestamp);
			ps.setTimestamp(6, timestamp);
			ps.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public boolean updatePackageState(UserPackage userPackage) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(UPDATE_PACKAGE_STATE_SQL);) {
			ps.setInt(1, 1);
			Long datetime = System.currentTimeMillis();
			Timestamp timestamp = new Timestamp(datetime);
			ps.setTimestamp(2, timestamp);
			ps.setInt(3, userPackage.getPackage_id());
			rowUpdated = ps.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	public boolean updatePackage(UserPackage userPackage) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(UPDATE_PACKAGE_SQL);) {
			ps.setString(1, userPackage.getUser_address());
			ps.setString(2, userPackage.getUser_name());
			
			ps.setString(3, userPackage.getPackage_number());
			Long datetime = System.currentTimeMillis();
			Timestamp timestamp = new Timestamp(datetime);
			ps.setTimestamp(4, timestamp);
			ps.setInt(5, userPackage.getPackage_id());

			rowUpdated = ps.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	public boolean deletePackage(int packageId) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(DELETE_PACKAGE_SQL);) {
			ps.setInt(1, packageId);
			rowDeleted = ps.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	private void printSQLException(SQLException e) {
	}
}
