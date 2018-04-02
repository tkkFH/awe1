package de.fhdw.awe1.uebung2;

import java.time.LocalDate;

public class Student {

	private String matrikelNummer;

	private String name;

	private String vorname;

	private LocalDate geburtsDatum;

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

	@Override
	public boolean equals(Object obj) {
		// TODO: 1. Implentiere equals für die Klasse Student basierend auf ihren
		// internen Zustand entsprechend des Vertrags von equals
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO: 2. Implentiere und teste hashCode
		return super.hashCode();
	}
}