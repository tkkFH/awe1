package de.fhdw.awe1.uebung2;

import java.time.LocalDate;

public class Student {

	private String name; 

	private String titel; 
	
	private String vorname;

	private String matrikelnummer;

	private LocalDate geburtsDatum;

	/*
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)//
				.append(name)//
				.append(vorname)//
				.append(matrikelnummer)//
				.append(geburtsDatum)//
				.toHashCode();
	}
	*/

	/*
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Student other = (Student) obj;
		return new EqualsBuilder()//
				.appendSuper(super.equals(obj))//
				.append(name, other.name)//
				.append(vorname, other.vorname)//
				.append(matrikelnummer, other.matrikelnummer)//
				.append(geburtsDatum, other.geburtsDatum)//
				.isEquals();
	}
	*/
}
