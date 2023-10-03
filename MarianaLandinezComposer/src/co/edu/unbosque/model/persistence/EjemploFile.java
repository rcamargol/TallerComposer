package co.edu.unbosque.model.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import co.edu.unbosque.model.Cancion;

public class EjemploFile {
	
	private String archivoData;
	
	public int escribirArchivo(String dato) {

        File f = new File(this.archivoData+ ".txt");

        try {

            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);

            pw.println(dato);

            fw.close();

        } catch (IOException e) {

            return -1;

        }

        return 0;

    }

	
	 public String leerArchivo() {
	        String linea = "";
	        String cadena = "";

	        File f = new File(this.leerArchivo());

	        try {
	            FileReader fr = new FileReader(f);
	            BufferedReader br = new BufferedReader(fr);
	            linea = br.readLine();
	            while (linea != null) {
	                cadena += linea + "\n";
	                linea = br.readLine();
	            }
	            fr.close();
	        } catch (IOException e) {
	            return null;
	        }
	        return cadena;
	    }
	 
	public String getArchivoData() {
		return archivoData;
	}
	public String setArchivoData(String archivoData) {
		return this.archivoData = archivoData;
	}
	
	 
	}
	
	