package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.Properties;

public class Propiedades {

	
	private Properties prop = new Properties();
	private String archivoprop = "C:\\data\\archivo.properties";

	public int escribirPropiedades(int cantidadEstrofas, int cantidadFrases) {
		
		
		try {
			prop.setProperty("cantidadEstrofas", String.valueOf(cantidadEstrofas));
			prop.setProperty("cantidadFrasesPorEstrofa", String.valueOf( cantidadFrases));
			
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
		linea += "cantidadEstrofas :" + prop.getProperty("cantidadEstrofas")+"\n";
		linea += "cantidadFrasesPorEstrofa :" + prop.getProperty("cantidadFrasesPorEstrofa")+"\n";
		
		
		} 
		catch (IOException ex) {
			return null;
		}
		return linea;
	}
}
