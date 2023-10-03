package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.Archivos;
import co.edu.unbosque.model.persistence.Propiedades;
import co.edu.unbosque.view.View;

public class Fachada {

	private Archivos files = new Archivos();
	private View gui = new View();
	private Propiedades prop = new Propiedades();
	
	public String mostrarOpcionesElegidas() {
		String menu="";
		try {
		int valorDato = Integer.parseInt(gui.mostrarMenu(menu));
		if(valorDato == 1) {
			gui.definirNumFrases();
			gui.definirNumEstrofas();
			gui.mostrarPropiedades(files.verPropiedades());
			mostrarOpcionesElegidas();
		}
		else if(valorDato == 2) {
			if(prop.leerPropiedades() != null) {
				files.crearArchivo();
				files.crearCancion();
				gui.mostrarCancion(files.leerArchivo());
				mostrarOpcionesElegidas();
			}
			else {
				gui.mostrarErrorPropiedades();
				mostrarOpcionesElegidas();
			}
		}
		else if(valorDato ==3){
			files.crearCarpeta();
			files.mostrarDirectorio();
			gui.mostrarCancion(files.leerArchivo());
			mostrarOpcionesElegidas();
		}
		else {
			gui.mostrarErrorAlDigitar();
			mostrarOpcionesElegidas();
		}
		}
		catch(NumberFormatException e) {
			gui.salir();
			
		}
		return menu;
	}
	
	
}
