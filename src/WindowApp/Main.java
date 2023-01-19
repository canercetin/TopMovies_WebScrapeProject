package WindowApp;

import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import WebScraper.JSoup;

public class Main {

	static final Logger log = Logger.getLogger(Main.class);
	
	public static void main(String[] args) throws IOException {
				
		BasicConfigurator.configure();		
		log.debug("Main...");
		
		JSoup jsoup = new JSoup();
		new Swing(jsoup);
	}

}
