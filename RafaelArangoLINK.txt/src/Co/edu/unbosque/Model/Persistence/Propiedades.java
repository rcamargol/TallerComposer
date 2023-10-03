package Co.edu.unbosque.Model.Persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Propiedades {
	private Properties prop = new Properties();
	private String rprop = "C:\\data\\archivo.properties";

	public int escribirPropiedades(int numEstrofas, int numFrasesPorEstrofa) {
		try {
			prop.setProperty("estrofas", String.valueOf(numEstrofas));
			prop.setProperty("frases", String.valueOf(numFrasesPorEstrofa));
			prop.store(new FileOutputStream(rprop), null);
		} catch (IOException e) {
			return -1;
		}
		return 0;
	}

	public String leerPropiedades() {
		String linea = "";
		try {
			prop.load(new FileInputStream(rprop));

			prop.list(System.out);
			linea += "Número de estrofas por canción: " + prop.getProperty("estrofas") + "\n";
			linea += "Número de frases por estrofa: " + prop.getProperty("frases") + "\n";
		} catch (IOException e) {
			return null;
		}
		return linea;
	}
}
