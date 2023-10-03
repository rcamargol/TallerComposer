package co.edu.unbosque.model;
import java.util.Properties;
import java.io.*;

public class Opcion1 {
	
	public Properties prop = new Properties();
	public String propFile = "c:\\data\\EstrofasyFrases.properties";
	
	public int EscribirArchivoProp (String estrofas, String frases) {
		
		try {
			
			prop.setProperty("Frases", frases);
			prop.setProperty("Estrofas", estrofas);
			prop.store(new FileOutputStream(propFile), null);
		}
		catch (IOException ex){
			return -1;
		}
		return 0;
	}

}
