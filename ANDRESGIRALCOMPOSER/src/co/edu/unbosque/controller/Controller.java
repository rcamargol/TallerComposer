package co.edu.unbosque.controller;

import co.edu.unbosque.model.Fachada;
import co.edu.unbosque.view.View;

public class Controller {
	private View gui;
	private Fachada fa;
	public Controller() {
		gui = new View();
		fa=new Fachada();
		fa.procesarOpcion(gui.mostrarOpciones());
}
}