package demo.faceId.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import demo.userPackage.model.UserPackage;

public class FaceIdDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=CST";
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private String jdbcUsername = "root";
	private String jdbcPassword = "12345678";

		// 硓筁sessionいㄏノъ籷
	private static final String SELECT_PACKAGE_BY_SESSION = "SELECT * FROM package WHERE user_address = ? AND package_state = 0;";
		// 硓筁sessionいㄏノъ籷计秖
	private static final String COUNT_PACKAGE_BY_SESSION = "SELECT COUNT(*) FROM package WHERE user_address = ? AND package_state = 0;";
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
	// 琩高祅籷(Session)
		public List<UserPackage> searchPackageByAddress(String userAddress) {
			List<UserPackage> packageList = new ArrayList<UserPackage>();
			try {
				Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(SELECT_PACKAGE_BY_SESSION);
				{
					ps.setString(1, userAddress);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						int packageId = rs.getInt("package_id");
						int packageState = rs.getInt("package_state");
						String userName = rs.getString("user_name");
						String packageNumber = rs.getString("package_number");
						Timestamp createdDate = rs.getTimestamp("created_date");
						Timestamp lastModifiedDate = rs.getTimestamp("last_modified_date");							System.out.println(lastModifiedDate);

						packageList.add(new UserPackage(packageId, userAddress, userName, packageNumber, packageState,
								createdDate, lastModifiedDate));
					}
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return packageList;
		}
		
		// 琩高祅籷计秖(Session)
		public int countPackage(String userAddress) {
			int count = 0;
			try {
				Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(COUNT_PACKAGE_BY_SESSION);
				{
					ps.setString(1, userAddress);
					ResultSet rs = ps.executeQuery();
					rs.next();
					count = rs.getInt(1);
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return count;
		}
	

	private void printSQLException(SQLException e) {
		// TODO Auto-generated method stub

	}
}
