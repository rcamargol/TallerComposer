package co.edu.unbosque.controller;

import java.io.File;

import javax.swing.JFileChooser;
import co.edu.unbsoque.model.Cancion;
import co.edu.unbsoque.model.CancionFachada;
import co.edu.unbsoque.model.Chooser;
import co.edu.unbsoque.model.EjercicioArchivo;
import co.edu.unbsoque.model.persistence.Propiedades;
import co.edu.unbsoque.view.View;

public class Controller {

	private CancionFachada fachada;
	private View gui;

	public Controller() {

		fachada = new CancionFachada();
		gui =  new View();
	}

	public void ejecutar() {
		
		
		try {
			
		

		menu: while (true) {

			int numero = gui.crearMenu();
			

			switch (numero) {

			case 1: {

				fachada.getProp().setF(gui.pedirNumeroFrases());
				fachada.getProp().setE(gui.pedirNumeroDeEstrofas());

				fachada.getProp().escribirPropiedades();
				
				gui.mostrarResultados("Datos creados y guardados con exito");
				
				break;

			}
			case 2: {

				fachada.getCancion().setEstrofas(fachada.getProp().getE());
				fachada.getCancion().setFrases(fachada.getProp().getF());
				
				fachada.getProp().escribirPropiedades();
				
				String estrofas = Integer.toString(fachada.getCancion().getEstrofas());
				String frases = Integer.toString(fachada.getCancion().getFrases());

				
				if (fachada.getCancion().getEstrofas() > 0 && fachada.getCancion().getFrases() > 0 || estrofas.isEmpty() && frases.isEmpty() ) {
					
					
	
				String letra = fachada.getCancion().crearCancion();

				gui.mostrarResultados(letra);

				fachada.getEjercicioArchivo().setContenido(letra);


				fachada.getEjercicioArchivo().guardarArchivoConFileChooser(letra);
				
				gui.mostrarResultados("Cancion guardada con exito");
				
				}else {
					
					gui.mostrarResultados("Error al crear la cancion");
				}

				break;
			}

			case 3: {

				String rutaArchivo = fachada.getChooser().seleccionarArchivo();

				if (rutaArchivo != null) {

					String contenido = fachada.getChooser().leerContenidoDelArchivo(rutaArchivo);
					
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
		
		} catch (Exception numberforException) {
		}
	}
}
