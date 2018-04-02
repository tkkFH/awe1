package de.fhdw.awe1.uebungen.jdbc.mybatis;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface StudentMapper {

	@Select("SELECT * FROM student")
	public List<Student> readAllStudents();

	@Select("SELECT * FROM student WHERE name like(#{name})")
	public List<Student> readAllStudentsWithName(String name);

	@Update("DROP TABLE STUDENT")
	public void dropStudentTable();

	@Update("CREATE TABLE STUDENT (id INT NOT NULL, name VARCHAR(64))")
	public void createStudentTable();

	@Insert("INSERT INTO STUDENT values (#{id}, #{name})")
	public void insertStudent(Student student);

}
