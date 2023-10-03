package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.Properties;

public class Propiedades {
	
	private Properties prop = new Properties();
	private String archivoprop = "C:\\data\\archivo.properties";

	public int escribirPropiedades(int numEstrofas, int numLineas) {
		try {
			prop.setProperty("estrofas", String.valueOf(numEstrofas));
			prop.setProperty("lineas", String.valueOf(numLineas));
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
		linea += "Estrofas = "+ prop.getProperty("estrofas")+"\n";
		linea += "Frases = "+ prop.getProperty("lineas")+"\n";
		
		} 
		catch (IOException ex) {
			return null;
		}
		return linea;
	}
}
