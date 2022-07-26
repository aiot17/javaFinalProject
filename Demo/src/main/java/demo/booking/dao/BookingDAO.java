package demo.booking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demo.booking.model.Booking;

public class BookingDAO {
	// 資料庫連線資料
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=CST";
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private String jdbcUsername = "root";
	private String jdbcPassword = "12345678";

	// MySQL控制語法
	private static final String SELECT_ALL_BOOKINGS = "select * from booking";
	private static final String SELECT_BOOKING_BY_ID = "select id,user_name,activity,date,site from booking where id = ?";
	private static final String UPDATE_BOOKING_SQL = "update booking set user_name = ?, activity = ?,date = ?, site = ? where id = ?;";
	private static final String INSERT_BOOKING_SQL = "INSERT INTO booking"
			+ "  (user_name, activity, date, site) VALUES " + " (?, ?, ?, ?);";
	private static final String DELETE_BOOKING_SQL = "delete from booking where id = ?;";
	private static final String SELECT_SITE_ACTIVITY_AND_DATE = "select * from booking where site = ? and activity = ? and date = ?";

	public BookingDAO() {
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

	// 租借清單
	public List<Booking> selectAllBookings() {

		List<Booking> bookings = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKINGS);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String user_name = rs.getString("user_name");
				String activity = rs.getString("activity");
				String date = rs.getString("date");
				String site = rs.getString("site");
				bookings.add(new Booking(id, user_name, activity, date, site));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return bookings;
	}

	// 查詢個別租借資料
	public Booking selectBooking(int id) {
		Booking booking = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKING_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String user_name = rs.getString("user_name");
				String activity = rs.getString("activity");
				String date = rs.getString("date");
				String site = rs.getString("site");
				booking = new Booking(id, user_name, activity, date, site);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return booking;
	}

	// 編輯個別租借資料
	public boolean updateBooking(Booking booking) throws SQLException {
		boolean rowUpdated;

		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_BOOKING_SQL);) {
			statement.setString(1, booking.getUser_name());
			statement.setString(2, booking.getActivity());
			statement.setString(3, booking.getDate());
			statement.setString(4, booking.getSite());
			statement.setInt(5, booking.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	// 辯證場地是否已租借
	public boolean siteVerify(String period, String activity, String date) {
		boolean verify = true;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(SELECT_SITE_ACTIVITY_AND_DATE);) {
			preparedStatement.setString(1, period);
			preparedStatement.setString(2, activity);
			preparedStatement.setString(3, date);
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

	// 新增租借
	public void insertBooking(Booking booking) throws SQLException {
		System.out.println(INSERT_BOOKING_SQL);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKING_SQL)) {
			preparedStatement.setString(1, booking.getUser_name());
			preparedStatement.setString(2, booking.getActivity());
			preparedStatement.setString(3, booking.getDate());
			preparedStatement.setString(4, booking.getSite());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	// 移除租借
	public boolean deleteBooking(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_BOOKING_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
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
