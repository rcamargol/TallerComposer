package Co.edu.unbosque.Controler;

import java.io.File;

import Co.edu.unbosque.Model.Generador;
import Co.edu.unbosque.view.View;

public class Controller {
	private Generador nm;
	private View v;

	public Controller() {
		nm = new Generador();
		v = new View();

		int numEstrofas = v.pedirNumeroEstrofas();
		nm.setNumEstrofas(numEstrofas);

		int numFrases = v.pedirNumeroFrases();
		nm.setNumFrasesPorEstrofa(numFrases);

		String letra = nm.generarCancion();

		v.mostrarMensaje(letra);

		File f = v.abrirArchivo();
		if (f != null) {
			nm.imprimirCancion(letra, f);
			v.mostrarMensaje("Canción creada y guardada como " + f.getName());
		} else {
			v.mostrarMensaje("La canción no se pudo guardar.");
		}

		v.mostrarMensaje(nm.hacerPropiedades());

	}

}
