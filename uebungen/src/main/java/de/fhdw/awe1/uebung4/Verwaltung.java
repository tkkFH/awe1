package de.fhdw.awe1.uebung4;

import java.util.Observable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jpatterns.gof.ObserverPattern;

@ObserverPattern
@ObserverPattern.Subject
@ObserverPattern.ConcreteSubject
public class Verwaltung extends Observable {
	// TODO: 6. Observer Pattern

	// Beispiel mit Erläuterungen hier
	// http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_10_002.htm#mjc7ffdeb540e30917defcbcab81cc06b4

	private static final Logger LOGGER = LogManager.getLogger(Verwaltung.class);

	public void anmelden(Dozent dozent) {
		this.addObserver(dozent);
	}

	public void anmelden(Student student) {
		LOGGER.info(String.format("Student %s %s meldet sich an.", student.getVorname(), student.getName()));
		setChanged();
		notifyObservers(student);
	}

	public void abmelden(Student student) {
		LOGGER.info(String.format("Student %s %s meldet sich ab.", student.getVorname(), student.getName()));
		setChanged();
		notifyObservers(student);
	}
}