package de.fhdw.awe1.uebungen.server.jsp;

import java.net.URL;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO: Funktioniert noch nicht...
		// Es fehlt noch die JSP-Engine damit die JSPs ordentlich laufen
		URL rootURL = Main.class.getClassLoader().getResource("webroot");
		String rootURLString = rootURL.toExternalForm();

		Server server = new Server(8080);

		server.setHandler(new WebAppContext(rootURLString, "/"));

		server.start();
		server.join();
	}

}
