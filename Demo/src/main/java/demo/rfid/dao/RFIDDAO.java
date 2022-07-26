package demo.rfid.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import demo.rfid.model.RFID;

public class RFIDDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=CST";
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private String jdbcUsername = "root";
	private String jdbcPassword = "12345678";

	// 新增RFID
	private static final String INSERT_RFID_SQL = "INSERT INTO rfid"
			+ " (user_address, rfid_name, rfid_num, created_date, last_modified_date) values " + "(?, ?, ?, ?, ?);";
	// 搜尋RFID
	private static final String SELECT_RFID_SQL = "SELECT * FROM rfid;";
	// 搜尋RFID(透過rfid_id)
	private static final String SELECT_RFID_BY_RFIDID = "SELECT * FROM rfid WHERE rfid_id = ?";
	// 修改RFID
	private static final String UPDATE_RFID_SQL = "UPDATE rfid SET user_address = ?, rfid_name = ?, rfid_num = ?, last_modified_date = ? WHERE rfid_id = ?;";
	// 刪除RFID(透過rfid_id)
	private static final String DELETE_RFID_SQL = "DELETE FROM rfid WHERE rfid_id = ?;";
	// 抓地址(透過RFID)
	private static final String SELECT_ADDRESS_BY_RFID = "SELECT * FROM rfid WHERE rfid_num = ?;";
	
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

	public void createRFID(RFID rfid) throws SQLException {
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(INSERT_RFID_SQL)) {
			ps.setString(1, rfid.getUserAddress());
			ps.setString(2, rfid.getRfidName());
			ps.setString(3, rfid.getRfidNum());
			Long datetime = System.currentTimeMillis();
			Timestamp timestamp = new Timestamp(datetime);
			System.out.println(timestamp);
			ps.setTimestamp(4, timestamp);
			ps.setTimestamp(5, timestamp);
			ps.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public List<RFID> searchRFIDList() {
		List<RFID> fridList = new ArrayList<RFID>();
		System.out.println("�I�sSQL");
		try {
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(SELECT_RFID_SQL);
			{
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					int rfidId = rs.getInt("rfid_id");
					String userAddress = rs.getString("user_address");
					String fridName = rs.getString("rfid_name");
					String fridNum = rs.getString("rfid_num");
					Timestamp createdDate = rs.getTimestamp("created_date");
					Timestamp lastModifiedDate = rs.getTimestamp("last_modified_date");
					fridList.add(new RFID(rfidId, userAddress, fridName, fridNum, createdDate, lastModifiedDate));
				}
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return fridList;
	}
	// 搜尋RFID用戶(透過前端逼逼)
	public RFID getRfidByRFIDNum(String rfidNum) {
		RFID rfid = null;
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(SELECT_ADDRESS_BY_RFID);) {
			ps.setString(1, rfidNum);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int rfidId = rs.getInt("rfid_id");
				System.out.println(rfidId);
				String userAddress = rs.getString("user_address");
				System.out.println(userAddress);
				String rfidName = rs.getString("rfid_name");
				System.out.println(rfidName);
				Timestamp createdDate = rs.getTimestamp("created_date");
				Timestamp lastModifiedDate = rs.getTimestamp("last_modified_date");
				rfid = new RFID(rfidId, userAddress, rfidName, rfidNum, createdDate, lastModifiedDate);
			}
		} catch (Exception e) {
		}
		return rfid;
	}

	public RFID getRfidById(int rfidId) {
		RFID rfid = null;
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(SELECT_RFID_BY_RFIDID);) {
			ps.setInt(1, rfidId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String userAddress = rs.getString("user_address");
				String rfidName = rs.getString("rfid_name");
				String rfidNum = rs.getString("rfid_num");
				Timestamp createdDate = rs.getTimestamp("created_date");
				Timestamp lastModifiedDate = rs.getTimestamp("last_modified_date");
				rfid = new RFID(rfidId, userAddress, rfidName, rfidNum, createdDate, lastModifiedDate);
			}
		} catch (Exception e) {
		}
		return rfid;
	}

	public boolean updateRFID(RFID rfid) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(UPDATE_RFID_SQL);) {
			ps.setString(1, rfid.getUserAddress());
			ps.setString(2, rfid.getRfidName());
			ps.setString(3, rfid.getRfidNum());
			Long datetime = System.currentTimeMillis();
			Timestamp timestamp = new Timestamp(datetime);
			ps.setTimestamp(4, timestamp);
			ps.setInt(5, rfid.getRfidId());
			rowUpdated = ps.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	public boolean deleteRFID(int rfidId) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(DELETE_RFID_SQL);) {
			ps.setInt(1, rfidId);
			rowDeleted = ps.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	private void printSQLException(SQLException e) {
	}
}
