package de.fhdw.awe1.uebungen.server.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class Main {

	private static final Logger LOGGER = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);

		ServletContextHandler handler = new ServletContextHandler();
		handler.addServlet(HelloWorldServlet.class, "/helloWorld");

		server.setHandler(handler);

		server.start();
		LOGGER.info("Server gestartet!");
	}

}
