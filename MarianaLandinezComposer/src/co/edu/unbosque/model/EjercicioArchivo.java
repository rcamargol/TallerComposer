package co.edu.unbosque.model;

import java.io.File;

import javax.swing.JFileChooser;

import co.edu.unbosque.model.persistence.EjemploFile;
import co.edu.unbosque.model.persistence.Propiedades;

public class EjercicioArchivo {
	
	private String nombreArchivo;
	private String contenido;

	 
	 public String gestionarPropiedades() {
		 Propiedades prop = new Propiedades();
		 
		 prop.escribirPropiedades();
		 
		 return "Se leyeron estas propiedades: "+ "\n"+ prop.leerPropiedades();
	 }
	 
	 
	 public void crearArchivo() {
		 
		 
		 EjemploFile archivo= new EjemploFile();
		 archivo.setArchivoData("D:\\"+ nombreArchivo+".txt");
		 
		 archivo.escribirArchivo(contenido);
	 }
	 
	 public int  guardarCancionConFileChooser(String contenido) {
		 	EjemploFile archivo= new EjemploFile();
		 
	        JFileChooser fileChooser = new JFileChooser();
	        int seleccion = fileChooser.showSaveDialog(null);

	        if (seleccion == JFileChooser.APPROVE_OPTION) {
	            File archivos = fileChooser.getSelectedFile();
	            String f= archivos.getAbsolutePath();
	           String nombreArchivo=  archivo.setArchivoData(f);

	            if (!nombreArchivo.endsWith(".txt")) {
	                nombreArchivo += ".txt"; 
	                
	                archivo.escribirArchivo(contenido);
	            }

	            return -1  ;
	        } else {
	            return 0; 
	        }
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
