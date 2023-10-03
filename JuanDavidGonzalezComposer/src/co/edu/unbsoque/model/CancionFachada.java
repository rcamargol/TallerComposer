package co.edu.unbsoque.model;

import co.edu.unbsoque.model.persistence.Propiedades;

public class CancionFachada {
	
	
	private Cancion cancion;
	private Chooser chooser;
	private EjercicioArchivo ejercicioArchivo;
	private Propiedades prop;
	
	
	public CancionFachada() {

	cancion = new Cancion();
	chooser = new Chooser();
	ejercicioArchivo = new EjercicioArchivo();
	prop = new Propiedades();
	
	}


	public Cancion getCancion() {
		return cancion;
	}


	public void setCancion(Cancion cancion) {
		this.cancion = cancion;
	}


	public Chooser getChooser() {
		return chooser;
	}


	public void setChooser(Chooser chooser) {
		this.chooser = chooser;
	}


	public EjercicioArchivo getEjercicioArchivo() {
		return ejercicioArchivo;
	}


	public void setEjercicioArchivo(EjercicioArchivo ejercicioArchivo) {
		this.ejercicioArchivo = ejercicioArchivo;
	}


	public Propiedades getProp() {
		return prop;
	}


	public void setProp(Propiedades prop) {
		this.prop = prop;
	}

	
}
