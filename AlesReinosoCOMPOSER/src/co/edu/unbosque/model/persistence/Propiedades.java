package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.Properties;

public class Propiedades {

	private Properties prop = new Properties();
	private String archivoprop = "C:\\data\\propiedades.properties";
	private String parra;
	private String frase;

	public int escribirPropiedades() {
		try {
			prop.setProperty("parrafos",parra);
			prop.setProperty("frases",frase);
			prop.store(new FileOutputStream(archivoprop), null);
		} 
		catch (IOException ex) {
			return -1;
		}
		return 0;
	}

	
	public String leerPropiedades() {
		String linea="";
		try {
			// leer el archivo de propiedades
		prop.load(new FileInputStream(archivoprop));

		// obtener las propiedades definidas
		prop.list(System.out);
		//Reading each property value
		linea += "parrafos :" + prop.getProperty("parrafos")+"\n";
		linea += "frases :" + prop.getProperty("frases")+"\n";
		} 
		catch (IOException ex) {
			return null;
		}
		return linea;
	}



	public String getParra() {
		return parra;
	}
	public void setParra(String parra) {
		this.parra = parra;
	}
	public String getFrase() {
		return frase;
	}
	public void setFrase(String frase) {
		this.frase = frase;
	}


	public String getArchivoprop() {
		return archivoprop;
	}


	public void setArchivoprop(String archivoprop) {
		this.archivoprop = archivoprop;
	}



	
	

	
}
