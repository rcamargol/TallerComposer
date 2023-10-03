package co.edu.unbosque.controller;

import co.edu.unbosque.model.Fachada;
import co.edu.unbosque.model.persistence.Archivos;
import co.edu.unbosque.view.View;

public class Controller {

	private View gui;
	private Archivos file;
	private Fachada f;
	
	public Controller() {
		gui = new View();
		file = new Archivos();
		f = new Fachada();
		ejecutar();
	}

	private void ejecutar() {
		file.crearCarpeta();
		gui.mostrarMenu(f.mostrarOpcionesElegidas());
		
	}
}
