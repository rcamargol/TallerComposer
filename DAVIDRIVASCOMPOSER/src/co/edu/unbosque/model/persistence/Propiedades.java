package co.edu.unbosque.model.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import co.edu.unbosque.view.View;

public class Propiedades {
	
	

	private Properties prop = new Properties();
	private String archivoProp = "C:\\Canciones\\Propiedades.properties";
	private View gui = new View();
	
	
	public String escribirPropiedades() {
		try {
			prop.setProperty("NumeroFrases", gui.definirNumFrases());
			prop.setProperty("NumeroEstrofas", gui.definirNumEstrofas());
			prop.store(new FileOutputStream(archivoProp), null);
		} 
		catch (IOException ex) {
			return ex.getMessage();
		}
		return "";
	}

	public String getFrases() {
		try {
			prop.load(new FileInputStream(archivoProp));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String frases = prop.getProperty("NumeroFrases");
		return frases;
	}
	
	public String getEstrofas() {
		try {
			prop.load(new FileInputStream(archivoProp));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String estrofas = prop.getProperty("NumeroEstrofas");
		return estrofas;
	}
	
	public String leerPropiedades() {
		String linea="";
		try {
			
		prop.load(new FileInputStream(archivoProp));

		linea += "Numero de frases por estrofa :" + prop.getProperty("NumeroFrases")+"\n";
		linea += "Numero de estrofas :" + prop.getProperty("NumeroEstrofas")+"\n";
		} 
		catch (Exception ex) {
			return null;
		}
		return linea;
	}
	

	public String getArchivoProp() {
		return archivoProp;
	}

	public void setArchivoProp(String archivoProp) {
		this.archivoProp = archivoProp;
	}
	
	
}
