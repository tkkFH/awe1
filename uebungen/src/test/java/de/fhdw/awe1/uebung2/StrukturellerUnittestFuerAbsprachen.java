package de.fhdw.awe1.uebung2;

import static org.junit.Assert.fail;
import java.io.File;
import java.io.FileFilter;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import com.google.common.collect.Lists;

public class StrukturellerUnittestFuerAbsprachen {

	// Mit Unittests lassen sich einige getroffene Absprachen für die Entwicklung
	// kontrollieren -> fail early Prinzip

	private static final String SRC_FOLDER = "src/main/java"; // Hier schauen wir uns nur den "produktiven" Code an

	// Hier wird Log aus Apache Commons genutzt.
	// Nicht so viele Methoden wir bei log4j, daher übersichtlicher in der Anwendung
	private static final transient Log LOGGER = LogFactory.getLog(StrukturellerUnittestFuerAbsprachen.class);

	@Test
	public void loggingSollAusschliesslichMitLoggingFrameworkErfolgen() throws Exception {
		File repoFolder = new File("..");

		List<String> klasseMitNichtAbgestimmtenLogging = Lists.newArrayList();

		// Nach Clean Code Gesichtspunkten ist das hier nicht optimal gelöst
		// -> Verschachtelungsebene zu tief
		for (File file : repoFolder.listFiles((FileFilter) DirectoryFileFilter.INSTANCE)) {
			if (file.isDirectory()) {
				File srcFolder = new File(file, SRC_FOLDER);
				if (srcFolder.exists()) {
					LOGGER.info("Untersuche " + srcFolder.getAbsolutePath());
					int i = 0;
					Iterator<File> srcFileIterator = FileUtils.iterateFiles(srcFolder, new SuffixFileFilter("java"),
							TrueFileFilter.INSTANCE);
					while (srcFileIterator.hasNext()) {
						File srcFile = srcFileIterator.next();
						String txt = FileUtils.readFileToString(srcFile);
						if (klasseEnthaeltNichtAbgesprochenesLogging(txt)) {
							klasseMitNichtAbgestimmtenLogging.add(srcFile.getAbsolutePath());
						}
						i++;
					}
					LOGGER.debug("Es wurden " + i + " Dateien untersucht");
				}
			}
		}

		if (CollectionUtils.isNotEmpty(klasseMitNichtAbgestimmtenLogging)) {
			LOGGER.warn("Folgende Klassen enthalten nicht abgestimmtes Logging");
			LOGGER.warn(klasseMitNichtAbgestimmtenLogging);
			fail("Es wird nicht abgesprochenes Logging verwendet!");
		}
	}

	private boolean klasseEnthaeltNichtAbgesprochenesLogging(String txt) {
		return txt.contains("System.out.println(")//
				|| txt.contains("System.err.println(");
	}
}
