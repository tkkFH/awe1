package de.fhdw.awe1.uebung3;

public class Pizza {

	// Anti-Pattern als mögliche Folge des Immutable Object Patterns
	// Telescoping Contructor (Anti-)Pattern
	// TODO: 5. Stellen Sie die Klasse auf das Builder-Pattern um

	// Exkurs: Domain Driven Design und Value-Objects Pattern

	public static final int CLASSIC = 24;

	public static final int MEDIUM = 28;

	public static final int LARGE = 32;

	private final int groesse;

	// Es geht nur eine Sauce, oder auch keine Sauce
	private final boolean tomatenSauce;

	private final boolean bbqSauce;

	private final boolean sahneSauce;

	// Beläge
	private final boolean kaese;

	private final boolean bacon;

	private final boolean tomaten;

	private final boolean paprika;

	// ... bei einigen Pizzarien kann aus 50 Belägen und mehr gewählt werden

	public Pizza(int groesse, boolean tomatenSauce, boolean bbqSauce, boolean sahneSauce, boolean kaese, boolean bacon,
			boolean tomaten, boolean paprika) {
		super();
		this.groesse = groesse;
		this.tomatenSauce = tomatenSauce;
		this.bbqSauce = bbqSauce;
		this.sahneSauce = sahneSauce;
		this.kaese = kaese;
		this.bacon = bacon;
		this.tomaten = tomaten;
		this.paprika = paprika;
	}

	public int getGroesse() {
		return groesse;
	}

	public boolean isTomatenSauce() {
		return tomatenSauce;
	}

	public boolean isBbqSauce() {
		return bbqSauce;
	}

	public boolean isSahneSauce() {
		return sahneSauce;
	}

	public boolean isKaese() {
		return kaese;
	}

	public boolean isBacon() {
		return bacon;
	}

	public boolean isTomaten() {
		return tomaten;
	}

	public boolean isPaprika() {
		return paprika;
	}

}
