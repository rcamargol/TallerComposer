package co.edu.unbosque.controller;

import co.edu.unbosque.model.MixComposer;
import co.edu.unbosque.view.View;

public class Controller {
	
	private View view;
	private MixComposer mc;
	
	public Controller() {
		view = new View();
		mc = new MixComposer();
		
		boolean salir = false;
		while (!salir) {
			int opcion = view.pedirOpcion();
			switch (opcion) {
				case 1:
					try {
						int numeroDeEstrofas = view.pedirNumero("Digite el número de estrofas:");
						int numeroDeVersos = view.pedirNumero("Digite el número de versos:");
						String nombreDeLaCancion = view.pedirNombreCancion();
						mc.construirCancion(numeroDeEstrofas, numeroDeVersos, nombreDeLaCancion);
						mc.gestionarPropiedades(nombreDeLaCancion, numeroDeEstrofas, numeroDeVersos);
					} catch (NullPointerException e) {}
					break;
				case 2: 
					view.message(mc.crearArchivoCancion());
					break;
				case 3:
					view.message(mc.seleccionarCancion());
					break;
				case 4:
					salir = true;
					break;
				default:
					view.message("Opción inválida");
			}
		}
	}
}
