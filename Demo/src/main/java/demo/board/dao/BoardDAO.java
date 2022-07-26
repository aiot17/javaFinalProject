package demo.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import demo.board.model.Board;


public class BoardDAO {
	// 資料庫連線資料
		private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=CST";
		private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		private String jdbcUsername = "root";
		private String jdbcPassword = "12345678";

		// MySQL控制語法
		private static final String SELECT_ALL_INFO = "select * from board";
		private static final String SELECT_INFO_BY_ID = "select id,date,title,info,last_modified from board where id = ?";
		private static final String UPDATE_BOARD_SQL = "update board set date = ?, title = ?, info = ? where id = ?;";
		private static final String INSERT_BOARD_SQL = "INSERT INTO board"
				+ "  (date, title, info) VALUES " + " (?, ?, ?);";
		private static final String DELETE_BOARD_SQL = "delete from board where id = ?;";
		// 找尋日期大於等於今天的資料
		private static final String SELECT_DATA_AFTER_TODAY = "SELECT * FROM `board` WHERE date >= now()";


		public BoardDAO() {			
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
		
		// 公告清單
		public List<Board> selectAllInfo() {

			List<Board> infoList = new ArrayList<>();
			try (Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_INFO);) {
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					int id = rs.getInt("id");
					String date = rs.getString("date");
					String title = rs.getString("title");
					String info = rs.getString("info");
					String last_modified = rs.getString("last_modified");
					infoList.add(new Board(id, date, title, info, last_modified));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return infoList;
		}
		
		// 查詢個別公告資料
		public Board selectInfo(int id) {
			Board board = null;
			try (Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(SELECT_INFO_BY_ID);) {
				preparedStatement.setInt(1, id);
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					String date = rs.getString("date");
					String title = rs.getString("title");
					String info = rs.getString("info");
					String last_modified = rs.getString("last_modified");
					board = new Board(id, date, title, info, last_modified);
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return board;
		}
		
		// 編輯個別公告資料
		public boolean updateBoard(Board board) throws SQLException {
			boolean rowUpdated;
			
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(UPDATE_BOARD_SQL);) {
				statement.setString(1, board.getDate());
				statement.setString(2, board.getTitle());
				statement.setString(3, board.getInfo());
				statement.setInt(4, board.getId());

				rowUpdated = statement.executeUpdate() > 0;
			}
			return rowUpdated;
		}
		
		// 新增公告
		public void insertBoard(Board board) throws SQLException {
			System.out.println(INSERT_BOARD_SQL);
			try (Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOARD_SQL)) {
				preparedStatement.setString(1, board.getDate());
				preparedStatement.setString(2, board.getTitle());
				preparedStatement.setString(3, board.getInfo());
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				printSQLException(e);
			}
		}
		
		// 移除公告
		public boolean deleteBoard(int id) throws SQLException {
			boolean rowDeleted;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement(DELETE_BOARD_SQL);) {
				statement.setInt(1, id);
				rowDeleted = statement.executeUpdate() > 0;
			}
			return rowDeleted;
		}
		
		// 搜尋大於等於今天的資料
				public List<Board> selectDataAfterNow() {

					List<Board> infoList = new ArrayList<>();
					try (Connection connection = getConnection();
							PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DATA_AFTER_TODAY);) {
						System.out.println(preparedStatement);
						ResultSet rs = preparedStatement.executeQuery();

						while (rs.next()) {
							int id = rs.getInt("id");
							String date = rs.getString("date");
							String title = rs.getString("title");
							String info = rs.getString("info");
							String last_modified = rs.getString("last_modified");
							infoList.add(new Board(id, date, title, info, last_modified));
						}
					} catch (SQLException e) {
						printSQLException(e);
					}
					return infoList;
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
