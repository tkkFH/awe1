package de.fhdw.awe1.uebung1;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MessungArrayList {

	private static final Logger LOGGER = LogManager.getLogger(MessungArrayList.class);

	private List<String> arrayList = new ArrayList<>();

	private static final String LISTENTYP = "ArrayList";

	public MessungArrayList() {
		super();
		// Fülle Array mit 50_000 willkürlichen Strings
		for (int i = 0; i < 5_000_000; i++) {
			arrayList.add(RandomStringUtils.random(10));
		}
		LOGGER.info(String.format("%s mit %s Einträgen erstellt", LISTENTYP, arrayList.size()));
	}

	public String messeZeitBeimSchreibenAmAnfang() {
		long start = System.currentTimeMillis();
		arrayList.add(0, "Schreibe am Anfang");
		long dauer = System.currentTimeMillis() - start;
		return String.format("%s: Schreiben am Anfang dauerte %d ms.\n", LISTENTYP, dauer);
	}

	public String messeZeitBeimSchreibenAmEnde() {
		long start = System.currentTimeMillis();
		arrayList.add("Schreibe am Ende");
		long dauer = System.currentTimeMillis() - start;
		return String.format("%s: Schreiben am Ende dauerte %d ms.\n", LISTENTYP, dauer);
	}

	public String messeZeitBeimSchreibenInDerMitte() {
		long start = System.currentTimeMillis();
		arrayList.add((arrayList.size() / 2), "Schreibe in der Mitte");
		long dauer = System.currentTimeMillis() - start;
		return String.format("%s: Schreiben in der Mitte dauerte %d ms.\n", LISTENTYP, dauer);
	}

	public String messeZeitBeimLesenAmAnfang() {
		long start = System.currentTimeMillis();
		arrayList.get(0);
		long dauer = System.currentTimeMillis() - start;
		return String.format("%s: Lesen am Anfang dauerte %d ms.\n", LISTENTYP, dauer);
	}

	public String messeZeitBeimLesenAmEnde() {
		long start = System.currentTimeMillis();
		arrayList.get(arrayList.size() - 1);
		long dauer = System.currentTimeMillis() - start;
		return String.format("%s: Lesen am Ende dauerte %d ms.\n", LISTENTYP, dauer);
	}

	public String messeZeitBeimLesenInDerMitte() {
		long start = System.currentTimeMillis();
		arrayList.get(arrayList.size() / 2);
		long dauer = System.currentTimeMillis() - start;
		return String.format("%s: Lesen aus der Mitte dauerte %d ms.\n", LISTENTYP, dauer);
	}

	// TODO: 0. Zeitmessung beim Entfernen Anfang, Mitte, Ende

	public void fuehreZeitmessungenAus() {
		LOGGER.info(new StringBuilder()//
				.append("\nSchreibzugriffe:\n")//
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