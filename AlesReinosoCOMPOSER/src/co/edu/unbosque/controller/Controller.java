package co.edu.unbosque.controller;

import co.edu.unbosque.model.EjercicioArchivo;
import co.edu.unbosque.view.View;
import co.edu.unbosque.model.*;
import co.edu.unbosque.model.persistence.*;
public class Controller {
	
	private View gui;
	private EjercicioArchivo m;

	public Controller() {
		m = new EjercicioArchivo();
		gui = new View();
	
		
	
		funcionar();
		
	}
	public void funcionar() {
		boolean c = true;
		while(c) {
			try {
			int a = Integer.parseInt(gui.menu());
			switch (a) {
			case 1: {
				String rutaP = m.seleccionarRutaArchivoP() + ".properties";
				//se estan tomando los parametros de lo que pongo pero no los de el archivo
				int p = Integer.parseInt(gui.pedirnumP());
				m.setParrafos(p);
				int f = Integer.parseInt(gui.pedirnumF());
				m.setFrases(f);
				gui.escribirDato(m.gestionarPropiedades(rutaP));
				break;
			}
			case 2: {
				String ruta = m.seleccionarRutaArchivo()+".txt";
				m.crearcancion(ruta);
				break;
			}
			case 3: {
				gui.escribirDato(m.getL().presenta());;
				break;
			}
			case 4: {
				c = false;
				break;
			}
			default:
				gui.escribirDato("mi perro que parte de que solo hay 4 opciones no entiende\nsolo hay 4 opciones seleccione una de las 4¡¡¡");
			}
		}catch(Exception e){
			gui.escribirDato("mi perro no entiende que solo se pueden poner numeros?");
		}
		}
	}

}
