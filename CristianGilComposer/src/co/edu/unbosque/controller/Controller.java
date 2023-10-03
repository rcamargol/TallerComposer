package co.edu.unbosque.controller;


import co.edu.unbosque.model.EjercicioReggaeton;
import co.edu.unbosque.view.View;

public class Controller {
	
	private View view;
	private EjercicioReggaeton reggaeton;
	
	public Controller() {
		view = new View();
		reggaeton = new EjercicioReggaeton();
		
		boolean run = true;
		while (run) {
			int opcion = 0;
			try {
				opcion = view.obtenerOpcionMenu();
			} catch (NumberFormatException e) {
				run = false;
			}
			switch(opcion) {
			case 1:
				int numero_de_estrofas = Integer.parseInt(view.pedirDato("INGRESA EL NUMERO DE ESTROFAS QUE DESEAS QUE TENGA LA CANCION: "));
				int numero_de_versos = Integer.parseInt(view.pedirDato("INGRESA EL NUMERO DE VERSOS QUE DESEAS QUE TENGA LA CANCION: "));
				String nombre_del_archivo = view.pedirDato("INGRESA EL NOMBRE QUE DESEAS QUE TENGA EL ARCHIVO DE LA CANCION: ");
				reggaeton.gestionarPropiedades(numero_de_estrofas, numero_de_versos, nombre_del_archivo);
				reggaeton.escribirCancion(numero_de_estrofas, numero_de_versos, nombre_del_archivo);
				break;
			case 2:
				view.mostrarDato("CANCION EXITOSAMENTE CREADA");
				break;
			case 3:
				view.mostrarArchivo();
				break;
			case 4:
				run = false;
				break;
			}
		}
	}
}
