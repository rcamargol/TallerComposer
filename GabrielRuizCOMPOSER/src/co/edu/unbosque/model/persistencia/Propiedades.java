package co.edu.unbosque.model.persistencia;

import java.io.*;
import java.util.Properties;

public class Propiedades {

	
	private Properties prop = new Properties();
	private String archivoprop = "C:\\cancion\\archivo.properties";

	public int escribirPropiedades(int numEstrofas, int NumFrases) {
		
		
		try {
			prop.setProperty("numEstrofas", String.valueOf(numEstrofas));
			prop.setProperty("cantidadFrasesPorEstrofa", String.valueOf( NumFrases));
			
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
		prop.load(new FileInputStream(archivoprop));

		prop.list(System.out);
		linea += "numEstrofas :" + prop.getProperty("numEstrofas")+"\n";
		linea += "NumFrases :" + prop.getProperty("NumFrases")+"\n";
		
		} 
		catch (IOException ex) {
			return null;
		}
		return linea;
	}
}
