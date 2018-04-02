package de.fhdw.awe1.uebung2;

import java.time.LocalDate;
import java.util.Set;

public class Vorlesung {

	// TODO: 3. Implementiere equals und hashCode auf alternativem Wege (z.B. mit
	// Drittanbieter-Library)
	// TODO: 4. Passen Sie die Klasse so an, das sie dem Pattern eines Immutable
	// Object entspricht

	private String studiengang;

	private String id;

	private int ectsPunkte;

	private int anzahlKontaktstunden;

	private int anzahlSelbststudiumstunden;

	private Pruefungsart pruefungsart;

	private LocalDate pruefungsTermin;

	private Set<Student> teilnehmer;

	public String getStudiengang() {
		return studiengang;
	}

	public void setStudiengang(String studiengang) {
		this.studiengang = studiengang;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getEctsPunkte() {
		return ectsPunkte;
	}

	public void setEctsPunkte(int ectsPunkte) {
		this.ectsPunkte = ectsPunkte;
	}

	public int getAnzahlKontaktstunden() {
		return anzahlKontaktstunden;
	}

	public void setAnzahlKontaktstunden(int anzahlKontaktstunden) {
		this.anzahlKontaktstunden = anzahlKontaktstunden;
	}

	public int getAnzahlSelbststudiumstunden() {
		return anzahlSelbststudiumstunden;
	}

	public void setAnzahlSelbststudiumstunden(int anzahlSelbststudiumstunden) {
		this.anzahlSelbststudiumstunden = anzahlSelbststudiumstunden;
	}

	public Pruefungsart getPruefungsart() {
		return pruefungsart;
	}

	public void setPruefungsart(Pruefungsart pruefungsart) {
		this.pruefungsart = pruefungsart;
	}

	public LocalDate getPruefungsTermin() {
		return pruefungsTermin;
	}

	public void setPruefungsTermin(LocalDate pruefungsTermin) {
		this.pruefungsTermin = pruefungsTermin;
	}

	public Set<Student> getTeilnehmer() {
		return teilnehmer;
	}

	public void setTeilnehmer(Set<Student> teilnehmer) {
		this.teilnehmer = teilnehmer;
	}
}
