package de.fhdw.awe1.uebung2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class StudentTest {

	// Exkurs: TDD (Test driven Development und hamcrest) -> red, green, refactor...
	// Referenz bzw. Cheat-Sheet:
	// https://www.marcphilipp.de/downloads/posts/2013-01-02-hamcrest-quick-reference/Hamcrest-1.3.pdf

	// Definition Wikipedia:
	// https://de.wikipedia.org/wiki/Testgetriebene_Entwicklung

	// Literatur:
	// Kent Beck, Test-Driven Development by Example, Addison-Wesley Verlag

	private Student subjectUnderTest; // auch unitUnderTest, testgegenstand, etc. ...

	@Test
	public void vergleichMitNullwertSollteFalseLiefern() throws Exception {

		// given (oder gegeben sein)
		subjectUnderTest = new Student();

		// when (wenn)
		boolean expected = subjectUnderTest.equals(null);

		// then (dann)
		assertThat(expected, is(false));
	}

	// reflexive
	@Test
	public void vergleichMitSichSelbstSollteTrueLiefern() throws Exception {

		// given
		subjectUnderTest = new Student();

		// when
		boolean expected = subjectUnderTest.equals(subjectUnderTest);

		// then
		assertThat(expected, is(true));
	}

	@Test
	public void vergleichMitGleichemObjektSollteTrueLiefern() throws Exception {

		// given
		Student student1 = new Student();
		Student student2 = new Student();

		// when

		// then
		assertThat(student1.equals(student2), is(true));
	}

	@Test
	public void vergleichMitUngleichemObjektSollteFalseLiefern() throws Exception {

		// given
		Student student1 = new Student();
		Student student2 = new Student();

		// when

		// then
		assertThat(student1.equals(student2), is(false));
	}

	// symmetric
	@Test
	public void equalsImplementierungSollteSymetrischSein() throws Exception {

		// given

		// when

		// then
	}

	// transitive
	@Test
	public void equalsImplementierungSollteTransitivSein() throws Exception {

		// given
		Student student1 = new Student();
		Student student2 = new Student();
		Student student3 = new Student();

		// when

		// then
		assertThat(student1.equals(student2), is(true));
		assertThat(student3.equals(student2), is(true));
		assertThat(student1.equals(student3), is(true));

	}

	// consistent
	@Test
	public void equalsImplementierungSollteKonsistentSein() throws Exception {

		// given
		Student student1 = new Student();

		// when

		// then
		for (int i = 0; i < 50_000; i++) {
			assertThat(student1.equals(student1), is(true));
		}
	}
}
