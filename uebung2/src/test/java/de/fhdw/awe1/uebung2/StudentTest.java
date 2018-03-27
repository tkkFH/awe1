package de.fhdw.awe1.uebung2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTest {

	private Student subjectUnderTest; 
	
	@Test
	public void vergleichMitNullwertSollteFalseLiefern() throws Exception {

		// given
		subjectUnderTest = new Student(); 

		// when
		boolean expected = subjectUnderTest.equals(null);
		
		// then
		assertThat(expected,is(false)); 
	}

	@Test
	public void vergleichMitSichSelbstSollteTrueLiefern() throws Exception {

		// given
		subjectUnderTest = new Student(); 

		// when
		boolean expected = subjectUnderTest.equals(subjectUnderTest);
		
		// then
		assertThat(expected,is(true)); 
	}
	
}
