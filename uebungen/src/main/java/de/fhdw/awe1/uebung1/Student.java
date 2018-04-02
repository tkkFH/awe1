package de.fhdw.awe1.uebung1;

import java.time.LocalDate;
import org.jpatterns.gof.ObserverPattern.Subject;

@Subject
public class Student {

	private String matrikelNummer;

	private String name;

	private String vorname;

	private LocalDate geburtsDatum;

	public Student(String name, String vorname) {
		super();
		this.name = name;
		this.vorname = vorname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getMatrikelNummer() {
		return matrikelNummer;
	}

	public void setMatrikelNummer(String matrikelNummer) {
		this.matrikelNummer = matrikelNummer;
	}

	public LocalDate getGeburtsDatum() {
		return geburtsDatum;
	}

	public void setGeburtsDatum(LocalDate geburtsDatum) {
		this.geburtsDatum = geburtsDatum;
	}
}