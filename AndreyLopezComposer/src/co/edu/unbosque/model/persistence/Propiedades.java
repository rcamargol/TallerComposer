package co.edu.unbosque.model.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Propiedades {
	private Properties prop = new Properties();
	private String nombre_del_archivo;
	private int numero_de_estrofas;
	private int numero_de_versos;
	private String archivoProp = "C:\\data\\archivo.properties";
	
	public int escribirPropiedades(int numero_de_estrofas, int numero_de_versos, String nombre_del_archivo) {
		try {
			setNombre_del_archivo(nombre_del_archivo + ".properties");
			prop.setProperty("nombreDelArchivo", getNombre_del_archivo());
			setArchivoProp("C:\\data\\" + getNombre_del_archivo());
			setNumero_de_versos(numero_de_versos);
			prop.setProperty("numeroDeVersos", getNumero_de_versos() + "");
			setNumero_de_estrofas(numero_de_estrofas);
			prop.setProperty("numeroDeEstrofas", getNumero_de_estrofas() + "");
			prop.setProperty("nombreCodigoFuente", "Propiedades.Java");
			prop.store(new FileOutputStream(archivoProp), null);
		} catch (IOException e) {
			return -1;
		}
		return 0;
	}
	
	public String leerPropiedades() {
		String linea = "";
		try {
			// Leer el archivo de propiedades
			prop.load(new FileInputStream(archivoProp));
			
			// Obtener las propiedades definidas
			prop.list(System.out);
			// Reading each property value
			linea += "nombre del Archivo: " + prop.getProperty("nombreDelArchivo") + "\n";
			linea += "numero de Versos: " + prop.getProperty("numeroDeVersos") + "\n";
			linea += "numero de Estrofas: " + prop.getProperty("numeroDeEstrofas") + "\n";
			linea += "nombre de la clase Java: " + prop.getProperty("nombreCodigoFuente") + "\n";
		} catch (IOException e) {
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

	public String getNombre_del_archivo() {
		return nombre_del_archivo;
	}

	public void setNombre_del_archivo(String nombre_del_archivo) {
		this.nombre_del_archivo = nombre_del_archivo;
	}

	public int getNumero_de_estrofas() {
		return numero_de_estrofas;
	}

	public void setNumero_de_estrofas(int numero_de_estrofas) {
		this.numero_de_estrofas = numero_de_estrofas;
	}

	public int getNumero_de_versos() {
		return numero_de_versos;
	}

	public void setNumero_de_versos(int numero_de_versos) {
		this.numero_de_versos = numero_de_versos;
	}

	public String getArchivoProp() {
		return archivoProp;
	}

	public void setArchivoProp(String archivoProp) {
		this.archivoProp = archivoProp;
	}
}
