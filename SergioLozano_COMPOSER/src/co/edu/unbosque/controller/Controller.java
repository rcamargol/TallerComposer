package co.edu.unbosque.controller;


import co.edu.unbosque.model.*;
import co.edu.unbosque.view.View;


public class Controller {
	
	private View view;
	private DjRegueton mc;
	
	public Controller() {
		view = new View();
		mc = new DjRegueton();
        
		try {
			mc.reproducirCancionAleatoria();
		} catch (AudioException e) {
			e.printStackTrace();
		}
		
		
		boolean salir = false;
		while (!salir) {
			
			view.mostrarBienvenida();
			
			switch (view.mostrarOpciones()) {
				case 0:
					int numeroDeEstrofas = view.pedirNumero("Digite el número de estrofas:");
					int numeroDeVersos = view.pedirNumero("Digite el número de versos:");
					String nombreDeLaCancion = view.pedirNombreCancion();
					mc.construirCancion(numeroDeEstrofas, numeroDeVersos, nombreDeLaCancion);
					mc.gestionarPropiedades(nombreDeLaCancion, numeroDeEstrofas, numeroDeVersos);
					break;
				case 1: 
					view.message(mc.crearArchivoCancion());
					break;
				case 2:
					String cancion= mc.seleccionarCancion();
					
					// Crear dos hilos para ejecutar los métodos en paralelo
				    Thread hilo1 = new Thread(new Runnable() {
				        public void run() {
				            view.message(cancion);
				        }
				    });

				    Thread hilo2 = new Thread(new Runnable() {
				        public void run() {
				            mc.implementacionPropiedadesVoz();
				        }
				    });

				    // Iniciar los hilos
				    hilo1.start();
				    hilo2.start();

				    // Esperar a que ambos hilos terminen antes de continuar
				    try {
				        hilo1.join();
				        hilo2.join();
				    } catch (InterruptedException e) {
				        e.printStackTrace();
				    }
					break;
				case 3:
					salir = true;
					view.mostrarDespedida();
					System.exit(0);
					break;
			}
		}
	}
}
