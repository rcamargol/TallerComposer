package co.edu.unbosque.model.persistence;
import java.io.*;
import java.util.Properties;


	public class Properties {

		private Properties ppds = new Properties();
		private String archivoppds = "C:\\data\\archivo.properties";

		public int escribirPropierties() {
			try {
				ppds.setProperty("nombreProyecto", "ArchivosTexto");
				ppds.setProperty("nombreArchivo", "archivo.properties");
				ppds.setProperty("nombreCodigoFuente", "Propiedades.Java");
				ppds.store(new FileOutputStream(archivoppds), null);
			} 
			catch (IOException ex) {
				return -1;
			}
			return 0;
		}	

		/* continua ... */
		
		public String leerPropierties() {
			String fila="";
			try {
				// leer el archivo de propiedades
			ppds.load(new FileInputStream(archivoppds));

			// obtener las propiedades definidas
			ppds.list(System.out);
			//Reading each property value
			fila += "nombre del Proyecto :" + ppds.getProperty("nombreProyecto")+"\n";
			fila += "nombre del Archivo :" + ppds.getProperty("nombreArchivo")+"\n";
			fila += "nombre de la Clase Java :" + ppds.getProperty("nombreCodigoFuente")+"\n";
			} 
			catch (IOException ex) {
				return null;
			}
			return fila;
		}

}
