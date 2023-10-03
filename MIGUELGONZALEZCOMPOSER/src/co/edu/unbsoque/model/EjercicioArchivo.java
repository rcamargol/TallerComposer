package co.edu.unbsoque.model;

import java.util.Iterator;


import co.edu.unbsoque.model.persistence.EjemploFile;

public class EjercicioArchivo {
	
	private String n;

	private String datos = "";
	
	
	
	
	

	public String gestionarArchivoCadena() {

		EjemploFile archivo = new EjemploFile();

		archivo.escribirArchivo("");

		return archivo.leerArchivo();
	}
	
	
	public void crearArchivo() {
		
		
		
		EjemploFile archivo = new EjemploFile();
		
		archivo.setArchivoData("D:\\"+n+".txt");
		archivo.escribirArchivo(datos);
		
	}
	
	
	public void crearArchivoPropiedades() {
		
		
		
		EjemploFile archivo = new EjemploFile();
		
	
	}
	
	
	///////////////////////////////////////////////////////////////////
	
	
	
	
	


	public String getN() {
		return n;
	}


	public void setN(String n) {
		this.n = n;
	}


	public String getDatos() {
		return datos;
	}


	public void setDatos(String datos) {
		this.datos = datos;
	}
	
	

	
}
