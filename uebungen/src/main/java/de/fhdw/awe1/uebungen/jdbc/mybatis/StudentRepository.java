package de.fhdw.awe1.uebungen.jdbc.mybatis;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class StudentRepository {

	private static SqlSessionFactory sqlSessionFactory;

	static {
		DataSource dataSource = createDataSource();

		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);

		Configuration configuration = new Configuration(environment);
		configuration.addMapper(StudentMapper.class);

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
	}

	public static List<Student> readAllStudents() {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			return session.getMapper(StudentMapper.class).readAllStudents();
		}
	}

	public static List<Student> readAllStudentsWithName(String name) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			return session.getMapper(StudentMapper.class).readAllStudentsWithName(name);
		}
	}

	public static void insertStudent(Student student) {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			session.getMapper(StudentMapper.class).insertStudent(student);
			session.commit();
		}
	}

	private static boolean doesTableExist(Connection connection, String table) throws SQLException {
		try (ResultSet resultSet = connection.getMetaData().getTables("%", "%", "%", new String[] { "TABLE" })) {
			while (resultSet.next()) {
				if (resultSet.getString("TABLE_NAME").equalsIgnoreCase(table)) {
					return true;
				}
			}
		}

		return false;
	}

	public static void createStudentTable() throws Exception {
		SqlSession session = sqlSessionFactory.openSession();
		Connection connection = session.getConnection();
		StudentMapper mapper = session.getMapper(StudentMapper.class);

		if (doesTableExist(connection, "STUDENT")) {
			mapper.dropStudentTable();
		}

		mapper.createStudentTable();

		session.commit();
		session.close();
	}

	private static DataSource createDataSource() {
		PooledDataSource ds = new PooledDataSource();

		ds.setDriver("org.apache.derby.jdbc.EmbeddedDriver");
		ds.setUrl("jdbc:derby:database;create=true");

		return ds;
	}

}
