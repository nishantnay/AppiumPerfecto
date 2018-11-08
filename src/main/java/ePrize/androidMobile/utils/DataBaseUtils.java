package ePrize.androidMobile.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import com.sun.rowset.CachedRowSetImpl;

import ru.yandex.qatools.allure.annotations.Step;

import org.testng.Assert;
import org.testng.Reporter;

public class DataBaseUtils extends AppiumUtils {
	// Declare connection, statement, resultSet and CachedResultSet as null
	private static Connection connection=null;
	private static Statement statement=null;
	private static ResultSet resultSet=null;
	private static CachedRowSetImpl crs=null;
	private static String resultValue = "";

	// Connect to OLAP Database
	@Step("Connect to the OLAP Database with the drivername,url,username and password")
	public static void dbConnectOLAP(String jdbcDriverName, String dataBaseUrlOLAP, String olapDatabaseName,
			String userName, String password) throws SQLException, ClassNotFoundException {
		// Setting Oracle JDBC Driver
		try {
			Class.forName(jdbcDriverName);
		} catch (ClassNotFoundException e) {
			Reporter.log("Where is your Oracle JDBC Driver?" + e.getMessage());
			throw e;
		}

		Reporter.log("Oracle JDBC Driver Registered!");

		// Establish the Oracle Connection using Connection String
		try {
			connection = DriverManager.getConnection(dataBaseUrlOLAP.concat(olapDatabaseName), userName, password);
		} catch (SQLException e) {
			Reporter.log("Connection Failed! Check output console" + e.getMessage());
			throw e;
		}
	}

	// Connect to OLTP Database
	@Step("Connect to the OLTP Database with the drivername,url,username and password")
	public static void dbConnectOLTP(String jdbcDriverName, String dataBaseUrlOLTP, String oltpDatabaseName,
			String userName, String password) throws SQLException, ClassNotFoundException {
		// Setting Oracle JDBC Driver
		try {
			Class.forName(jdbcDriverName);
		} catch (ClassNotFoundException e) {
			Reporter.log("Where is your Oracle JDBC Driver?" + e.getMessage());
			throw e;
		}

		Reporter.log("Oracle JDBC Driver Registered!");

		// Establish the Oracle Connection using Connection String
		try {
			connection = DriverManager.getConnection(dataBaseUrlOLTP.concat(oltpDatabaseName), userName, password);
		} catch (SQLException e) {
			Reporter.log("Connection Failed! Check output console" + e.getMessage());
			throw e;
		}
	}
	@Step("Connect to the OLTP Database with the drivername,url,username and password")
	public static void dbConnectOLTP(String dataBaseUrlOLTP, String oltpDatabaseName, String userName, String password)
			throws SQLException {
		// Establish the Oracle Connection using Connection String
		try {
			connection = DriverManager.getConnection(dataBaseUrlOLTP.concat(oltpDatabaseName), userName, password);
		} catch (SQLException e) {
			Reporter.log("Connection Failed! Check output console" + e.getMessage());
			throw e;
		}
	}

	// Close Connection
	@Step("Disconnect from the database")
	public static void dbDisconnect() throws Exception {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (Exception e) {
			Reporter.log("Connection Failed! Check output console" + e.getMessage());
			throw e;
		}
	}

	public static void verifyProfileIDOLAP(String mobilenumber) {
		try {
			/*
			 * String verifyProfileId =
			 * "SELECT registrations.profile_id,birth_date.profile_id,sweeps_entries.profile_id FROM registrations INNER JOIN birth_date ON (registrations.profile_id= birth_date.profile_id) INNER JOIN sweeps_entries ON (birth_date.profile_id= sweeps_entries.profile_id) WHERE mobile_phone_number='"
			 * + phonenumber + "'";
			 */
			String verifyProfileId = "SELECT registrations.profile_id,birth_date.profile_id,sweeps_entries.profile_id FROM registrations INNER JOIN birth_date ON (registrations.profile_id= birth_date.profile_id) INNER JOIN sweeps_entries ON (birth_date.profile_id= sweeps_entries.profile_id) WHERE mobile_phone_number='"
					+ mobilenumber + "'";
			System.out.println(verifyProfileId);
			statement.executeQuery(verifyProfileId);
		} catch (SQLException sqlEx) {
			Reporter.log(
					"Unable to fetch the query for verifying the profile Id's for Win Scenario " + sqlEx.getMessage());
		}
	}

	public static ResultSet verifyEventNameRegisterInSweepEntries(String phonenumber, String eventName)
			throws SQLException, ClassNotFoundException {
		// Declare statement, resultSet and CachedResultSet as null
		int i;
		CachedRowSetImpl crs = null;
		try {
			statement = connection.createStatement();
			String verifyEventName = "SELECT registrations.profile_id,sweeps_entries.profile_id,sweeps_entries.event_name FROM registrations INNER JOIN sweeps_entries ON (registrations.profile_id= sweeps_entries.profile_id) WHERE mobile_phone_number='"
					+ phonenumber + "'" + " AND event_name='" + eventName + "'";
			System.out.println(verifyEventName);
			ResultSet resultSet = statement.executeQuery(verifyEventName);
			ResultSetMetaData metaData = resultSet.getMetaData();
			int noCols = metaData.getColumnCount();
			for (i = 1; i <= noCols; i++) {
				if (i != 4)
					System.out.printf("%-10s\t", metaData.getColumnName(i).toUpperCase());
			}
			System.out.println();
			while (resultSet.next()) {
				for (i = 1; i <= noCols; i++) {
					if (i != 4)
						System.out.printf("%-10s\t", resultSet.getObject(i));
					Assert.assertEquals(resultSet.getString(3), eventName);
				}
				break;
			}
			System.out.println();
			// CachedRowSet Implementation
			// In order to prevent "java.sql.SQLRecoverableException: Closed
			// Connection: next" error
			// We are using CachedRowSet
			crs = new CachedRowSetImpl();
			crs.populate(resultSet);
		} catch (SQLException e) {
			Reporter.log("Problem occurred at executeQuery operation : " + e);
			throw e;
		} finally {
			if (resultSet != null) {
				// Close resultSet
				resultSet.close();
			}
		}
		// Return CachedRowSet
		return crs;
	}
	@Step("Delete the specific record from the OLAP Database")
	public static void deleteRecordfromOLAPLooseScenario(String phonenumber) {
		try {
			statement = connection.createStatement();
			String regselect = "SELECT @ProfileID :=  profile_id FROM registrations WHERE mobile_phone_number='" + phonenumber + "'";
			String birthdate = "DELETE FROM birth_date WHERE profile_id = @ProfileID";
			String sweeps = "DELETE FROM sweeps_entries WHERE profile_id = @ProfileID";
			String regdelete = "DELETE FROM registrations WHERE profile_id = @ProfileID";
			statement.execute(regselect);
			statement.execute(birthdate);
			statement.execute(sweeps);
			statement.execute(regdelete);
		} catch (SQLException sqlEx) {
			Reporter.log(
					"Unable to fetch the query for deleting all the records present in child and parent tables for Loose Scenario "
							+ sqlEx.getMessage());
		} finally {
			try {
				statement.close();
			} catch (Exception e) {
				Reporter.log("Unable to close the connection " + e.getMessage());
			}
		}
	}
	@Step("Delete the specific record from the OLTP Database")
	public static void deleteRecordfromOLTP(String phonenumber) {
		try {
			statement = connection.createStatement();
			String deleteRecord = "DELETE FROM profile WHERE unique_id='" + phonenumber + "'";
			statement.execute(deleteRecord);
		} catch (SQLException sqlEx) {
			Reporter.log(
					"Unable to delete the query exists in the profile table of OLTP Database" + sqlEx.getMessage());
		} finally {
			try {
				statement.close();
			} catch (Exception e) {
				Reporter.log("Unable to close the connection " + e.getMessage());
			}
		}
	}
}
