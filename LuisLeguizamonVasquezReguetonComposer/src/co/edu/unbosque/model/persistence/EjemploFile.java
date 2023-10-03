package co.edu.unbosque.model.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EjemploFile {
	
	private String archivoData = "c:\\data\\datanumeros.txt";
	
	public int escribirArchivo(String nombre_del_archivo, String dato) {
		
		setArchivoData(nombre_del_archivo);
		
		File f = new File(this.archivoData);
		
		try {
			FileWriter eda = new FileWriter(f);
			try (PrintWriter i = new PrintWriter(f)) {
				i.println(dato);
			}
			
			eda.close();
		} catch(IOException e) {
			return -1;
		}
		return 0;
	}
	
	public String getArchivoData() {
		return archivoData;
	}

	public String leerArchivo() {
		
		String linea, cadena = "";
		
		File f = new File(this.archivoData);
		
		try {
			FileReader la = new FileReader(f);
			BufferedReader br = new BufferedReader(la);
			linea = br.readLine();
			while (linea != null) {
				cadena += linea;
				linea = br.readLine();
			}
			la.close();
		} catch(IOException e) {
			return null;
		}
		return cadena;
	}
	
	public void setArchivoData(String archivoData) {
		this.archivoData = archivoData;
	}
}

