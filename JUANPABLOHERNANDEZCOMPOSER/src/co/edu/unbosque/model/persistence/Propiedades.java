package co.edu.unbosque.model.persistence;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Propiedades {
	
	private Properties prop = new Properties();
	private String archivoprop;
	private String estrofas;
	private String frasesEstrofa;
	
	public Propiedades() {
		archivoprop = "C:\\data\\archivo.properties";
	}
	
	

	public Propiedades(String estrofas, String frasesEstrofa) {
		super();
		this.estrofas = estrofas;
		this.frasesEstrofa = frasesEstrofa;
	}



	public int escribirPropiedades(String num1, String num2) {
		try {
			prop.setProperty("numeroEstrofas", num1);
			prop.setProperty("frasesEstrofa", num2);
			prop.store(new FileOutputStream(archivoprop), null);
			
		estrofas = prop.getProperty("numeroEstrofas");
		frasesEstrofa = prop.getProperty("frasesEstrofa");
		} 
		catch (IOException ex) {
			return -1;
		}
		return 0;
	}
	
	



	public String getEstrofas() {
		return estrofas;
	}



	public void setEstrofas(String estrofas) {
		this.estrofas = estrofas;
	}



	public String getFrasesEstrofa() {
		return frasesEstrofa;
	}



	public void setFrasesEstrofa(String frasesEstrofa) {
		this.frasesEstrofa = frasesEstrofa;
	}
	
}
