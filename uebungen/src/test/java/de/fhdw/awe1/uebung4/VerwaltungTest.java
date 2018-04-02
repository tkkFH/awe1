package de.fhdw.awe1.uebung4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class VerwaltungTest {

	private static final Logger LOGGER = LogManager.getLogger(VerwaltungTest.class);

	private Verwaltung subjectUnderTest;

	@Before
	public void init() {
		subjectUnderTest = new Verwaltung();
	}

	@Test
	public void testName() throws Exception {

		// given
		Dozent dozent0 = new Dozent("Hempe", "Sabine");
		Dozent dozent1 = new Dozent("Reus", "Ulrich");
		Dozent dozent2 = new Dozent("Carrol-Scott", "Karin");
		Dozent dozent3 = new Dozent("Holzheuer", "Heiko");
		Dozent dozent4 = new Dozent("Nieland", "Stefan");
		Dozent dozent5 = new Dozent("Hohensohn", "Heidi");

		subjectUnderTest.anmelden(dozent0);
		subjectUnderTest.anmelden(dozent1);
		subjectUnderTest.anmelden(dozent2);
		subjectUnderTest.anmelden(dozent3);
		// subjectUnderTest.anmelden(dozent4);
		subjectUnderTest.anmelden(dozent5);

		Student max = new Student("Mustermann", "Max");

		// when
		subjectUnderTest.anmelden(max);
		LOGGER.info("So, jetzt kann ich weiterarbeiten...");
		subjectUnderTest.anmelden(dozent4);
		subjectUnderTest.abmelden(max);
		LOGGER.info("So, jetzt kann ich weiterarbeiten...");

		// then

	}
}
