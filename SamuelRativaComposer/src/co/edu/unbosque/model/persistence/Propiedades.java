package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.Properties;
public class Propiedades {
	
	private Properties prop = new Properties();
	private String NombreArchivo;
	private int NumeroEstrofas;
	private int NumeroVersos;
	private String archivoprop = "C:\\data\\archivo.properties";

	public int escribirPropiedades(String nombreArchivo, int numeroEstrofas, int numeroVersos) {
		try {
			setNombreArchivo(NombreArchivo+"properties");
			prop.setProperty("nombreArchivo", getNombreArchivo());
			setNumeroVersos(NumeroVersos);
			prop.setProperty("Numero de versos", getNumeroVersos()+ "" );
			setNumeroEstrofas(NumeroEstrofas);
			prop.setProperty("Numero de estrofas",getNumeroEstrofas()+"");
			prop.setProperty("nombreCodigoFuente", "Propiedades.Java");
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
		linea += "nombre del Archivo :" + prop.getProperty("nombreArchivo")+"\n";
		linea += "Numero de estrofas :" + prop.getProperty("NumeroEstrofas")+"\n";
		linea += "Numero de versos :" + prop.getProperty("NumeroVersos")+"\n";
		} 
		catch (IOException ex) {
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

	public String getNombreArchivo() {
		return NombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		NombreArchivo = nombreArchivo;
	}

	public int getNumeroEstrofas() {
		return NumeroEstrofas;
	}

	public void setNumeroEstrofas(int numeroEstrofas) {
		NumeroEstrofas = numeroEstrofas;
	}

	public int getNumeroVersos() {
		return NumeroVersos;
	}

	public void setNumeroVersos(int numeroVersos) {
		NumeroVersos = numeroVersos;
	}

	public String getArchivoprop() {
		return archivoprop;
	}

	public void setArchivoprop(String archivoprop) {
		this.archivoprop = archivoprop;
	}

}
