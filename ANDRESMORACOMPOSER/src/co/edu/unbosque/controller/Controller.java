package co.edu.unbosque.controller;

import java.io.File;

import co.edu.unbosque.model.Letra;
import co.edu.unbosque.view.View;

public class Controller {
	private Letra nroe;
	private View v;

	public Controller() {
		nroe = new Letra();
		v = new View();

		int numEstrofas = v.pedirNumeroEstrofas();
		nroe.setNumEstrofas(numEstrofas);

		int numFrases = v.pedirNumeroFrases();
		nroe.setNumFrasesPorEstrofa(numFrases);

		String letra = nroe.generarCancion();

		v.mostrarMensaje(letra);

		File f = v.abrirArchivo();
		if (f != null) {
			nroe.imprimirCancion(letra, f);
			v.mostrarMensaje("El nombre de tu cancion es: " + f.getName());
		} else {
			v.mostrarMensaje("no se guardo la cancion");
		}
		
		v.mostrarMensaje(nroe.hacerPropiedades());

	}

}