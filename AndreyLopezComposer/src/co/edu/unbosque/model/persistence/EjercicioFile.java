package co.edu.unbosque.model.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EjercicioFile {
	
	private String archivoData = "c:\\data\\datanumeros.txt";
	
	public int escribirArchivo(String nombre_del_archivo, String dato) {
		
		setArchivoData(nombre_del_archivo);
		
		File f = new File(this.archivoData);
		
		try {
			FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println(dato);
			
			fw.close();
		} catch(IOException e) {
			return -1;
		}
		return 0;
	}
	
	public String leerArchivo() {
		
		String linea, cadena = "";
		
		File f = new File(this.archivoData);
		
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			linea = br.readLine();
			while (linea != null) {
				cadena += linea;
				linea = br.readLine();
			}
			fr.close();
		} catch(IOException e) {
			return null;
		}
		return cadena;
	}
	
	public void setArchivoData(String archivoData) {
		this.archivoData = archivoData;
	}
}

