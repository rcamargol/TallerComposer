package co.edu.unbosque.controller;

import java.io.File;

import javax.swing.JFileChooser;
import co.edu.unbsoque.model.Cancion;
import co.edu.unbsoque.model.Chooser;
import co.edu.unbsoque.model.EjercicioArchivo;
import co.edu.unbsoque.model.persistence.Propiedades;
import co.edu.unbsoque.view.View;

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

				gui.mostrarResultados(letra);

				eje.setDatos(letra);

				eje.setN(gui.cambiarNombreDelArchivo());

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
