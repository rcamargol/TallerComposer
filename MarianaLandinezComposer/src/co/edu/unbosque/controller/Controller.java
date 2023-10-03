package co.edu.unbosque.controller;

import co.edu.unbosque.model.Cancion;
import co.edu.unbosque.model.Chooser;
import co.edu.unbosque.model.EjercicioArchivo;
import co.edu.unbosque.model.Fachada;
import co.edu.unbosque.model.persistence.Propiedades;
import co.edu.unbosque.view.View;

public class Controller {

	private Fachada fachada;
	private View gui;

	public Controller() {

		gui = new View();

		fachada = new Fachada();

		// TODO Auto-generated constructor stub
		ejecutar();
	}

	public void ejecutar() {

		try {

			menu: while (true) {

				int opcion = gui.pedirOpcionMenu();

				switch (opcion) {

				case 1: {

//				String nombre = gui.pedirNombreArchivo();

//				fachada.geteArchivo().setNombreArchivo(nombre);

					fachada.getPropiedades().setNumEstrofas(gui.pedirNumeroEstrofas());
					fachada.getPropiedades().setNumFrases(gui.pedirNumeroFrases());
					fachada.getPropiedades().escribirPropiedades();

					fachada.getCancion().setNumeroEstrofas(fachada.getPropiedades().getNumEstrofas());
					fachada.getCancion().setNumeroFrases(fachada.getPropiedades().getNumFrases());

					gui.mostrarResultados("Datos guardados correctamente");

					break;
				}

				case 2: {

					String estrofa = Integer.toString(fachada.getCancion().getNumeroEstrofas());
					String frases = Integer.toString(fachada.getCancion().getNumeroFrases());

					if (fachada.getCancion().getNumeroEstrofas() > 0 && fachada.getCancion().getNumeroFrases() > 0
							|| estrofa.isEmpty() && frases.isEmpty()) {

						String letra = fachada.getCancion().crearCancion();

						gui.mostrarResultados(letra);

						fachada.geteArchivo().setContenido(letra);

//					fachada.geteArchivo().crearArchivo();

						fachada.geteArchivo().guardarCancionConFileChooser(letra);

						gui.mostrarResultados("Cancion creada correctamente");
					} else {

						gui.mostrarResultados("Por favor defina los parametros de su cancion");
					}

					break;

				}
				case 3: {

					String rutaArchivo = fachada.getChooser().seleccionarArchivo();

					if (rutaArchivo != null) {

						String contenido = fachada.getChooser().leerContenidoDelArchivo(rutaArchivo);

						gui.mostrarResultados(contenido);

					}

					break;
				}
				case 4: {

					break menu;
				}

				default: {

					gui.mostrarResultados("Ingrese un numero valido");
					break;

				}

				}
			}
		} catch (Exception numberformatException) {
			// TODO: handle exception
		}
	}

}
