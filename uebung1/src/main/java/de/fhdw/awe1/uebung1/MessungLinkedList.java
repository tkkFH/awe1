package de.fhdw.awe1.uebung1;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

public class MessungLinkedList {

	private List<String> liste = new LinkedList<>();

	private static final String LISTENTYP = "LinkedList";

	public MessungLinkedList() {
		super();
		// Fülle Array mit 50_000 willkürlichen Strings
		for (int i = 0; i < 5_000_000; i++) {
			liste.add(RandomStringUtils.random(10));
		}
		System.out.println(String.format("%s mit %s Einträgen erstellt", LISTENTYP,liste.size()));
	}

	public String messeZeitBeimSchreibenAmAnfang() {
		long start = System.currentTimeMillis();
		liste.add(0, "Schreibe am Anfang");
		long dauer = System.currentTimeMillis() - start;
		return String.format("%s: Schreiben am Anfang dauerte %d ms.\n", LISTENTYP, dauer);
	}

	public String messeZeitBeimSchreibenAmEnde() {
		long start = System.currentTimeMillis();
		liste.add("Schreibe am Ende");
		long dauer = System.currentTimeMillis() - start;
		return String.format("%s: Schreiben am Ende dauerte %d ms.\n", LISTENTYP, dauer);
	}

	public String messeZeitBeimSchreibenInDerMitte() {
		long start = System.currentTimeMillis();
		liste.add((liste.size() / 2), "Schreibe in der Mitte");
		long dauer = System.currentTimeMillis() - start;
		return String.format("%s: Schreiben in der Mitte dauerte %d ms.\n", LISTENTYP, dauer);
	}

	public String messeZeitBeimLesenAmAnfang() {
		long start = System.currentTimeMillis();
		liste.get(0);
		long dauer = System.currentTimeMillis() - start;
		return String.format("%s: Lesen am Anfang dauerte %d ms.\n", LISTENTYP, dauer);
	}

	public String messeZeitBeimLesenAmEnde() {
		long start = System.currentTimeMillis();
		liste.get(liste.size() - 1);
		long dauer = System.currentTimeMillis() - start;
		return String.format("%s: Lesen am Ende dauerte %d ms.\n", LISTENTYP, dauer);
	}

	public String messeZeitBeimLesenInDerMitte() {
		long start = System.currentTimeMillis();
		liste.get(liste.size() / 2);
		long dauer = System.currentTimeMillis() - start;
		return String.format("%s: Lesen aus der Mitte dauerte %d ms.\n", LISTENTYP, dauer);
	}

	public void fuehreZeitmessungenAus() {
		System.out.println(new StringBuilder()//
				.append("Schreibzugriffe:\n")//
				.append(messeZeitBeimSchreibenAmAnfang())//
				.append(messeZeitBeimSchreibenInDerMitte())//
				.append(messeZeitBeimSchreibenAmEnde())//
				.append("Lesezugriffe:\n")//
				.append(messeZeitBeimLesenAmAnfang())//
				.append(messeZeitBeimLesenInDerMitte())//
				.append(messeZeitBeimLesenAmEnde())//
				.toString());

	}
}