package de.fhdw.awe1.uebung4;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.RandomUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jpatterns.gof.ObserverPattern;
import org.jpatterns.gof.ObserverPattern.ConcreteObserver;
import com.google.common.util.concurrent.Uninterruptibles;

@ObserverPattern
@ConcreteObserver
public class Dozent implements Observer {

	private static final Logger LOGGER = LogManager.getLogger(Dozent.class);

	private String name;

	private String vorname;

	private long reaktionszeit;

	public Dozent(String name, String vorname) {
		super();
		this.name = name;
		this.vorname = vorname;
		this.reaktionszeit = RandomUtils.nextLong(0, 1501);
	}

	@Override
	public void update(Observable o, Object arg) {
		Uninterruptibles.sleepUninterruptibly(reaktionszeit, TimeUnit.MILLISECONDS);
		LOGGER.info(String.format("%s %s sagt: Vielen Dank für die Information", vorname, name));
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
}
