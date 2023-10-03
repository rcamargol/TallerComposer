package co.edu.unbosque.controller;
import co.edu.unbosque.model.Regueton;
import co.edu.unbosque.view.View;

public class Controller {
	
	private View view;
	private Regueton regueton;
	
	public Controller() {
		view = new View();
		regueton = new Regueton();
		
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
				int numero_de_estrofas = Integer.parseInt(view.pedirDato("Digite el numero de estrofas que va a tener la cancion: "));
				int numero_de_versos = Integer.parseInt(view.pedirDato("Digite el numero de versos que va a tener la cancion: "));
				String nombre_del_archivo = view.pedirDato("Digite el nombre del archivo de la cancion a crear: ");
				regueton.gestionarPropiedades(numero_de_estrofas, numero_de_versos, nombre_del_archivo);
				regueton.escribirCancion(numero_de_estrofas, numero_de_versos, nombre_del_archivo);
				break;
			case 2:
				view.mostrarDato("Canción creada exitosamente");
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
