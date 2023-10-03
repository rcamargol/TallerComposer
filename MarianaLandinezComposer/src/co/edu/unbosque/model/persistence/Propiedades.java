
package co.edu.unbosque.model.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


public class Propiedades {

	private Properties propiedades = new Properties();
	private String archivoPropiedades = "D:\\archivo.properties";
	private int numFrases, numEstrofas;

	public int escribirPropiedades() {

		try {

			String cantFrases = Integer.toString(numFrases);
			String cantEstrofas = Integer.toString(numEstrofas);

			propiedades.setProperty("cantidadFrases", cantFrases);
			propiedades.setProperty("cantidadEstrofas", cantEstrofas);
			propiedades.store(new FileOutputStream(archivoPropiedades), null);

		} catch (IOException ex) {
			return -1;

		}
		return 0;

	}

	public String leerPropiedades() {
		String linea = "";

		try {
			propiedades.load(new FileInputStream(archivoPropiedades));

			propiedades.list(System.out);

			linea += "numero de frases: " + propiedades.getProperty("cantidadFrases") + "\n";
			linea += "numero de estrofas: " + propiedades.getProperty("cantidadEstrofas") + "\n";
		} catch (IOException ex) {
			return null;

		}
		return linea;
	}

	public int getNumFrases() {
		return numFrases;
	}

	public void setNumFrases(int numFrases) {
		this.numFrases = numFrases;
	}

	public int getNumEstrofas() {
		return numEstrofas;
	}

	public void setNumEstrofas(int numEstrofas) {
		this.numEstrofas = numEstrofas;
	}

}
