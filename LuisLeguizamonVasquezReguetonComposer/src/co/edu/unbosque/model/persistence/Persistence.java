package co.edu.unbosque.model.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Persistence {
	private Properties prop = new Properties();
	private int NumeroDeVersos;
	private int NumeroDeEstrofas;
	private String archivoProp = "c:\\data\\archivo.properties";
	public String leerPersistence;

	
	public int escribirPropiedades(int NumeroDeEstrofas, int NumeroDeVersos, String NombreDelArchivo) {
		try {
			setNombreDeArchivo(NombreDelArchivo + ".properties");
			prop.setProperty("nombreDelArchivo", getNombreDelArchivo());
			setArchivoProp("c:\\data\\" + getNombreDelArchivo());
			setNumeroDeVersos(NumeroDeVersos);
			prop.setProperty("numeroDeVersos", getNumeroDeVersos() + "");
			setNumeroDeEstrofas(NumeroDeEstrofas);
			prop.setProperty("numeroDeEstrofas", getNumeroDeEstrofas() + "");
			prop.setProperty("NombreCodigo", "Propiedades.Java");
			prop.store(new FileOutputStream(archivoProp), "Descripción de las propiedades");
		} catch (IOException e) {
			return -1;
		}
		return 0;
	}
	

	

	public int getNumeroDeVersos() {
		return NumeroDeVersos;
	}

	public void setNumeroDeVersos(int numeroDeVersos) {
		NumeroDeVersos = numeroDeVersos;
	}

	public int getNumeroDeEstrofas() {
		return NumeroDeEstrofas;
	}

	public void setNumeroDeEstrofas(int numeroDeEstrofas) {
		NumeroDeEstrofas = numeroDeEstrofas;
	}

	public String getArchivoProp() {
		return archivoProp;
	}

	public void setArchivoProp(String archivoProp) {
		this.archivoProp = archivoProp;
	}

	public void setNombreDelArchivo(String nombreDelArchivo) {
	}

	private String getNombreDelArchivo() {
		// TODO Auto-generated method stub
		return null;
	}

	private void setNombreDeArchivo(String string) {
		// TODO Auto-generated method stub
		
	}

	public String leerPropiedades() {
		String linea = "";
		try {
		
			prop.load(new FileInputStream(archivoProp));
			
			prop.list(System.out);

			linea += "NombreDel Archivo: " + prop.getProperty("NombreDelArchivo") + "\n";
			linea += "NumeroDeEstrofas: " + prop.getProperty("NumeroDeVersos") + "\n";
			linea += "NumeroDeVersos: " + prop.getProperty("NumeroDeEstrofas") + "\n";
			linea += "NombreClase: " + prop.getProperty("NombreCodigo") + "\n";
		} catch (IOException e) {
			return null;
		}
		return linea;
	}

	

	public String getLeerPersistence() {
		return leerPersistence;
	}

	public void setLeerPersistence(String leerPersistence) {
		this.leerPersistence = leerPersistence;
	}

	
}
