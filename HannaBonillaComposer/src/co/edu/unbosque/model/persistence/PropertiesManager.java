package co.edu.unbosque.model.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties; // Importa la clase Properties

public class PropertiesManager { // Cambio del nombre de la clase

	private Properties propiedades = new Properties(); // Cambio del nombre de la variable
	private String rutaPropiedades = "C:\\data\\archivo.properties"; // Cambio del nombre de la variable

	public int escribirPropiedades(int numEstrofas, int numFrasesPorEstrofa) {
		try {
			propiedades.setProperty("estrofas", String.valueOf(numEstrofas));
			propiedades.setProperty("frases", String.valueOf(numFrasesPorEstrofa));
			propiedades.store(new FileOutputStream(rutaPropiedades), null); // Cambio del nombre de la variable
		} catch (IOException e) {
			return -1;
		}
		return 0;
	}

	public String leerPropiedades() {
		String linea = "";
		try {
			propiedades.load(new FileInputStream(rutaPropiedades)); // Cambio del nombre de la variable

			propiedades.list(System.out);
			linea += "Número de estrofas por canción: " + propiedades.getProperty("estrofas") + "\n";
			linea += "Número de frases por estrofa: " + propiedades.getProperty("frases") + "\n";
		} catch (IOException e) {
			return null;
		}
		return linea;
	}
}
