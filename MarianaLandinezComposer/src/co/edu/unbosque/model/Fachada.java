package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.Propiedades;
import co.edu.unbosque.model.Cancion;
import co.edu.unbosque.model.Chooser;
import co.edu.unbosque.model.EjercicioArchivo;

public class Fachada {
	
	private Cancion cancion;
	private Propiedades propiedades;
	private EjercicioArchivo eArchivo;
	private Chooser chooser;
	

	
	public Fachada() {
		// TODO Auto-generated constructor stub
		
		cancion= new Cancion();
		propiedades= new Propiedades();
		eArchivo= new EjercicioArchivo();
		chooser = new Chooser();
		
	}



	public Cancion getCancion() {
		return cancion;
	}



	public void setCancion(Cancion cancion) {
		this.cancion = cancion;
	}



	public Propiedades getPropiedades() {
		return propiedades;
	}



	public void setPropiedades(Propiedades propiedades) {
		this.propiedades = propiedades;
	}



	public EjercicioArchivo geteArchivo() {
		return eArchivo;
	}



	public void seteArchivo(EjercicioArchivo eArchivo) {
		this.eArchivo = eArchivo;
	}



	public Chooser getChooser() {
		return chooser;
	}



	public void setChooser(Chooser chooser) {
		this.chooser = chooser;
	}
	
	
}


