package de.fhdw.awe1.uebungen.jdbc.mybatis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

	private static final Logger LOGGER = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws Exception {
		StudentRepository.createStudentTable();

		StudentRepository.insertStudent(new Student(1, "Adam"));
		StudentRepository.insertStudent(new Student(2, "Eva"));
		StudentRepository.insertStudent(new Student(3, "Bert"));

		LOGGER.info("Ausgabe mit Streams");
		StudentRepository.readAllStudents().stream().forEach(student -> LOGGER.info(student.toString()));

		LOGGER.info("Ausgabe mit forEach Schleife");
		for (Student student : StudentRepository.readAllStudents()) {
			LOGGER.info(student);
		}

		LOGGER.info("Hole mir Bert");
		StudentRepository.readAllStudentsWithName("Bert").stream().forEach(student -> LOGGER.info(student.toString()));
	}
}