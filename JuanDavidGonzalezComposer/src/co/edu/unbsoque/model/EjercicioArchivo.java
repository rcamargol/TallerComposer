package co.edu.unbsoque.model;

import java.io.File;
import java.util.Iterator;

import javax.swing.JFileChooser;

import co.edu.unbsoque.model.persistence.EjemploFile;

public class EjercicioArchivo {

	
	private String nombreArchivo;
	
	private String contenido;
	
	
	private String n;

	private String datoS = "";
	

	
	
	

	public String gestionarArchivoCadena() {

		EjemploFile archivo = new EjemploFile();

		archivo.escribirArchivo("");

		return archivo.leerArchivo();

	}

	public void crearArchivo() {

		EjemploFile archivo = new EjemploFile();

		archivo.setArchivoData("D:\\" + n + ".txt");
		archivo.escribirArchivo(datoS);

	}

	public void crearArchivoPropiedades() {

		EjemploFile archivo = new EjemploFile();

	}

	public int guardarArchivoConFileChooser(String contenido) {
		EjemploFile guardado = new EjemploFile();

		JFileChooser fileChooser = new JFileChooser();

		int seleccion = fileChooser.showSaveDialog(null);

		if (seleccion == JFileChooser.APPROVE_OPTION) {
			
			
			File archivos = fileChooser.getSelectedFile();
			String f = archivos.getAbsolutePath();
			String nombreArchivo = guardado.setArchivoData(f);

		

				guardado.escribirArchivo(contenido);
			

			return -1;
			
		} else {
			
			return 0;
			
		}
		
	}

	public String getN() {
		return n;
	}

	public void setN(String n) {
		this.n = n;
	}

	public String getDatoS() {
		return datoS;
	}

	public void setDatoS(String datoS) {
		this.datoS = datoS;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	

}
