package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.Properties;

public class Propiedades {
	private Properties prop;
	private String rutaArchivoPropiedades = "C:\\Data\\propiedades.txt";
	
	public Propiedades() {
		prop = new Properties();
	}
	
	public int escribirPropiedadesDeLaCancion(String nombreDeLaCancion, int estrofas, int frases) {
		setRutaArchivoPropiedades("C:\\data\\" + nombreDeLaCancion + ".properties");;
		
		try {
			prop.setProperty("nombreCancion", nombreDeLaCancion);
			prop.setProperty("estrofas", estrofas + "");
			prop.setProperty("frases", frases + "");
			prop.setProperty("nombreArchivo", nombreDeLaCancion + ".properties");
			prop.store(new FileOutputStream(this.rutaArchivoPropiedades), null);
		} catch (IOException e) {
			return -1;
		}
		return 0;
	}

	public void listarPropiedadesDeCancion() {
		try {
			prop.load(new FileInputStream(this.rutaArchivoPropiedades));
			prop.list(System.out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Properties getProp() {
		return prop;
	}

	public String getRutaArchivoPropiedades() {
		return rutaArchivoPropiedades;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public void setRutaArchivoPropiedades(String rutaArchivoPropiedades) {
		this.rutaArchivoPropiedades = rutaArchivoPropiedades;
	}
}
