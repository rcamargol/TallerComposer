package co.edu.unbosque.model.persistence;
import java.io.*;
import java.util.Properties;

public class ArchivoProperties {
	private Properties prop = new Properties();
	private String archivoprop = "C:\\data\\archivo.properties";
	  public int crearArchivoProperties(String estrofas, String frases) {
		  try {
				prop.setProperty("numeroDeEstrofas", estrofas);
				prop.setProperty("numeroDeFrases",frases);
				prop.store(new FileOutputStream(archivoprop), null);
			} 
			catch (IOException ex) {
				return -1;
			}
			return 0;
}
	  public String leerPropiedades(Properties prop,String archivoprop) {
		  int linea1;
		  int linea2;
			try {
				// leer el archivo de propiedades
			prop.load(new FileInputStream(archivoprop));

			// obtener las propiedades definidas
			prop.list(System.out);
			//Reading each property value
			linea1 = Integer.parseInt(prop.getProperty("numeroDeEstrofas"));
			linea2 = Integer.parseInt(prop.getProperty("numeroDeFrases"));
			palabra(linea1,linea2);
			} 
			catch (IOException ex) {
				return null;
			}
			return palabra(linea1,linea2);

		}
	private String palabra(int linea1, int linea2) {
		return archivoprop;
		// TODO Auto-generated method stub
		
	}
}