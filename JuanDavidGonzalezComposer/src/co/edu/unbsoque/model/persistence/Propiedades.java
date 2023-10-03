package co.edu.unbsoque.model.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Propiedades {

	private Properties prop = new Properties();
	private String archivoprop = "D:\\archivo.properties";

	private int f;
	private int e;

	public int escribirPropiedades() {

		try {

			String cantFrases = Integer.toString(f);
			String cantEstrofas = Integer.toString(e);
			
			prop.setProperty("CantidadDeFrases", cantFrases);
			prop.setProperty("CantidadDeEstrofas", cantEstrofas);

			prop.store(new FileOutputStream(archivoprop), null);
		} catch (IOException ex) {

			return -1;
		}

		return 0;
	}
	
	public String leerPropiedades() {
		
		String linea = "";
		
		try { 
			
			prop.load(new FileInputStream(archivoprop));
			
			prop.list(System.out);
			
			
			linea += "Numero de frases " + prop.getProperty("CantidadDeFrases") + "\n";
			
			linea += "Numero de estrofas " + prop.getProperty("CantidadDeEstrofas") + "\n";
			
		} catch (Exception e) {
			
			return null;
		}
		
		return linea;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public String getArchivoprop() {
		return archivoprop;
	}

	public void setArchivoprop(String archivoprop) {
		this.archivoprop = archivoprop;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}

	
	

}
