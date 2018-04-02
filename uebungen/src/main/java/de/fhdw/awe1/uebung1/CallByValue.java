package de.fhdw.awe1.uebung1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CallByValue {

	// Parameter in der Methodensignatur (Javainsel Kapitel 2.8.6)
	// http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_02_008.htm#mj9b0d4e5b321975f9fc5fd010a7b19af8

	private static final Logger LOGGER = LogManager.getLogger(CallByValue.class);

	public static void main(String[] args) {

		// Bei einfachen Datentypen
		int i = 42;
		LOGGER.info("Wert von i: " + i);
		tueEtwas(i);
		LOGGER.info("Wert von i: " + i);

		// Bei komplexen Datentypen
		Student max = new Student("Mustermann", "Max");
		LOGGER.info(String.format("%s %s", max.getName(), max.getVorname()));
		tueEtwas(max);
		LOGGER.info(String.format("%s %s", max.getName(), max.getVorname()));
	}

	// Bei einfachen Datentypen
	public static void tueEtwas(int i) {
		// Hier wird eine Kopie von i erstellt und als lokale Variable im Methodenrumpf
		// genutzt
		i++;
		LOGGER.info("Wert von i: " + i);
	}

	// Bei komplexen Datentypen
	public static void tueEtwas(Student student) {
		// student = new Student("Mustermann", "Max"); // Neuer "Wert"
		student.setName("Beispiel");
		LOGGER.info(String.format("%s %s", student.getName(), student.getVorname()));

	}

}
