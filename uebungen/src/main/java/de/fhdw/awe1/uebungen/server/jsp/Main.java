package de.fhdw.awe1.uebungen.server.jsp;

import java.net.URL;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {

	// Folien 185 bis 192

	public static void main(String[] args) throws Exception {
		// TODO: Funktioniert noch nicht...
		// Es fehlt noch die JSP-Engine damit die JSPs ordentlich laufen
		// Beispiel dafür:
		// https://examples.javacodegeeks.com/enterprise-java/jetty/jetty-jsp-example/
		URL rootURL = Main.class.getClassLoader().getResource("webroot");
		String rootURLString = rootURL.toExternalForm();

		Server server = new Server(8080);

		server.setHandler(new WebAppContext(rootURLString, "/"));

		server.start();
		server.join();
	}

}
