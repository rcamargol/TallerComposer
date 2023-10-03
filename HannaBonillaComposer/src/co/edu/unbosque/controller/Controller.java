package co.edu.unbosque.controller;

import co.edu.unbosque.model.Compositor;
import co.edu.unbosque.view.View;

import java.io.File;

public class Controller {
	private Compositor compositor;
	private View view;

	public Controller() {
		compositor = new Compositor();
		view = new View();

		int numEstrofas = view.pedirNumeroEstrofas();
		compositor.setNumEstrofas(numEstrofas);

		int numFrases = view.pedirNumeroFrases();
		compositor.setNumFrasesPorEstrofa(numFrases);

		String letra = compositor.generarSong();

		view.mostrarMensaje(letra);

		File archivo = view.openArchivo();
		if (archivo != null) {
			compositor.imprimirCancion(letra, archivo);
			view.mostrarMensaje("Canción creada y guardada como " + archivo.getName());
		} else {
			view.mostrarMensaje("La canción no se puede guardar.");
		}

		view.mostrarMensaje(compositor.hacerPropiedades());
	}
}
