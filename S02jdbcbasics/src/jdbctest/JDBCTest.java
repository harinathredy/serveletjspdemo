package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		// readFromDB();
		// insertIntoDB();
		updateIntoDB();
		 readFromDB();
	}

	private static void updateIntoDB() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Virat@12");
				Statement statement = connection.createStatement();) {

			int rowsUpdated = statement.executeUpdate("update account set balance=5000 where accno=3");
			System.out.println("number of rows inserted: " + rowsUpdated);

		} catch (

		SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	private static void insertIntoDB() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Virat@12");
				Statement statement = connection.createStatement();) {

			int rowsInserted = statement.executeUpdate("insert into account values(3,'marry','lucy',150000)");
			System.out.println("number of rows inserted: " + rowsInserted);

		} catch (

		SQLException e) {
			e.printStackTrace();
		}
	}

	private static void readFromDB() {

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Virat@12");
				Statement statement = connection.createStatement();) {

			ResultSet resultSet = statement.executeQuery("select * from account");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + ", " + resultSet.getString(2) + ", " + resultSet.getString(3)
						+ ", " + resultSet.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
