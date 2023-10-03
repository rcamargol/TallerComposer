package co.edu.unbosque.model;

import java.util.Iterator;

import co.edu.unbosque.model.persistence.EjemploFile;

public class EjercicioArchivo {

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

	///////////////////////////////////////////////////////////////////

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

}
