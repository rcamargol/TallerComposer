package co.edu.unbosque.controller;

import java.io.File;

import javax.swing.JFileChooser;
import co.edu.unbosque.model.Cancion;
import co.edu.unbosque.model.Chooser;
import co.edu.unbosque.model.EjercicioArchivo;
import co.edu.unbosque.model.persistence.Propiedades;
import co.edu.unbosque.view.View;

public class Controller {

	private Cancion cancion;
	private View gui;
	private Propiedades prop;
	private EjercicioArchivo eje;
	private Chooser chooser;

	public Controller() {

		cancion = new Cancion();
		gui = new View();
		prop = new Propiedades();
		eje = new EjercicioArchivo();

		chooser = new Chooser();

	}

	public void ejecutar() {

		menu: while (true) {

			int numero = gui.crearMenu();

			switch (numero) {

			case 1: {

				prop.setF(gui.pedirNumeroFrases());
				prop.setE(gui.pedirNumeroDeEstrofas());

				prop.escribirPropiedades();

				break;

			}
			case 2: {

				cancion.setEstrofas(prop.getE());
				cancion.setFrases(prop.getF());

				String letra = cancion.crearCancion();

			

				eje.setDatoS(letra);

				eje.setN(gui.CambiarNombreDelArchivo());

				eje.crearArchivo();

				break;
			}

			case 3: {

				String rutaArchivo = chooser.seleccionarArchivo();

				if (rutaArchivo != null) {

					String contenido = chooser.leerContenidoDelArchivo(rutaArchivo);

					gui.mostrarResultados(contenido);
				} else {

					gui.errorAlLeer();

				}

				break;
			}

			case 4: {

				break menu;

			}

			default: {

				gui.mostrarOpcionDefault();
				break menu;
			}
			}
		}
	}
}
