package de.fhdw.awe1.uebungen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DerbyDatenbank {

	private static final String JDBC_URL = "jdbc:derby:database;create=true";

	private static final Logger LOGGER = LogManager.getLogger(DerbyDatenbank.class);

	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();
		properties.put("user", "user");

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(JDBC_URL, properties);
			if (!tableExists(connection))
				createTable(connection);
			populateTable(connection);

			List<StudentEntity> studenten = getStudents(connection);
			for (StudentEntity student : studenten) {
				LOGGER.info(student.getId() + ": " + student.getName());
			}
		} catch (Exception e) {
			LOGGER.error("Fehler mit der DB!", e);
		} finally {
			if (connection != null) {
				connection.close();
				LOGGER.info("Connection wurde geschlossen!");
			}
		}
	}

	private static boolean tableExists(Connection connection) throws SQLException {
		try (ResultSet result = connection.getMetaData().getTables("%", "%", "%",
				new String[] { "TABLE", "SYSTEM TABLE" })) {
			while (result.next()) {
				if (result.getString("TABLE_NAME").equalsIgnoreCase("STUDENTEN"))
					return true;
			}
		}
		return false;
	}

	private static List<StudentEntity> getStudents(Connection connection) throws SQLException {
		List<StudentEntity> studenten = new ArrayList<>();
		try (Statement statement = connection.createStatement()) {
			ResultSet result = statement.executeQuery("SELECT * FROM STUDENTEN");

			while (result.next()) {
				StudentEntity student = new StudentEntity();

				student.setId(result.getInt(1));
				student.setName(result.getString(2));

				studenten.add(student);
			}

			result.close();

		}
		return studenten;
	}

	private static void populateTable(Connection connection) throws SQLException {
		try (Statement statement = connection.createStatement()) {
			statement.execute("DELETE FROM STUDENTEN");
			statement.execute("INSERT INTO STUDENTEN (name) values ('Eric Elsen')");
			statement.execute("INSERT INTO STUDENTEN (name) values ('Anna Adam')");
			statement.execute("INSERT INTO STUDENTEN (name) values ('Bert Bertamann')");
			statement.execute("INSERT INTO STUDENTEN (name) values ('Charlie Cäsar')");
			statement.execute("INSERT INTO STUDENTEN (name) values ('Daniel Danger')");
			statement.close();
		}
	}

	private static void createTable(Connection connection) throws SQLException {
		try (Statement statement = connection.createStatement()) {
			statement.execute(
					"CREATE TABLE STUDENTEN (id integer primary key generated always as identity, name varchar(64))");
			statement.close();
		}
	}
}