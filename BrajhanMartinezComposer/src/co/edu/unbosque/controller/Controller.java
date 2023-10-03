package co.edu.unbosque.controller;

import co.edu.unbosque.model.Regueton;
import co.edu.unbosque.view.View;

public class Controller {
	
	private View vista;
	private Regueton cancion;
	
	public Controller() {
		vista = new View();
		cancion = new Regueton();
		
		ejecutar();
	}
	
	public void ejecutar() {
		int estrofas = 0;
		int frases = 0;
		int opcion = 0;
		
		do{
			opcion = Integer.parseInt(vista.pedirDato());
			switch(opcion){
			case 1:
				estrofas = Integer.parseInt(vista.pedirNumEstrofas());
				frases = Integer.parseInt(vista.pedirNumFrases());
				cancion.archivar(estrofas, frases);
				vista.escribirDato(cancion.archivar(estrofas, frases));
				break;
			case 2:
				if (estrofas > 0 && frases > 0) {
				cancion.componer(estrofas, frases);
				vista.escribirDato("El archivo se creó con exito,\nA continuacion procedemos a guardar");
				cancion.guardarArchivo();
				vista.escribirDato(cancion.crearArchivo(cancion.componer(estrofas, frases)));
				
				}else {
				vista.escribirDato("Primero, por favor crear los parametros");
				}
				break;
			case 3:
				cancion.elegirArchivo();
                String contenido = cancion.leerArchivo(cancion.elegirArchivo());
                vista.escribirDato("La composicion elegida es:\n"+contenido);
				break;
			case 4:
				vista.escribirDato("Hasta la proxima.");
                break;
            default:
            	vista.escribirDato("Opción no válida.");
			}
		}while(opcion != 4);
	}
		
}
