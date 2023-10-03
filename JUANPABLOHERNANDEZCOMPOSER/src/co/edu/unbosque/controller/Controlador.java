package co.edu.unbosque.controller;

import co.edu.unbosque.model.Compositor;
import co.edu.unbosque.view.View;

public class Controlador {
	private Compositor c;
	private String nombreCancion;
	private String numeroEstrofas;
	private String numeroFrases;
	private View view;
	private int opcion;
	
	public Controlador() {
		c = new Compositor();
		nombreCancion = null;
		numeroEstrofas = null;
		numeroFrases = null;
		view = new View();
		opcion = 0;
	}
	
public void ejecutar() {
	cicloprincipal: while (opcion != 3) {
	opcion = view.mostrarMenuOpciones();
	switch (opcion) {
	case 0: {
		numeroEstrofas = view.obtenerCantidadEstrofas();
		numeroFrases = view.obtenerCantidadFrasesPorEstrofa();
		nombreCancion = view.obtenerNombreArchivo();
		System.out.println(numeroEstrofas+ " "+ numeroFrases);
		break;
	} 
	case 1: {
		if (Integer.parseInt(numeroEstrofas) > 0 && Integer.parseInt(numeroFrases) > 0 && nombreCancion != null) {
			c.crearLetrasCancion();
			System.out.println(numeroEstrofas+ " "+ numeroFrases);
			c.definirPropiedades(numeroEstrofas,numeroFrases);
			c.mostrarMatriz(nombreCancion);
			
		} else {
			view.escribirDato("Error, define primero los datos antes de crear la cancion");
			break;
		}
		break;
	}
	case 2 : {
		String ubicacionArchivo = c.seleccionarArchivo();
		if (ubicacionArchivo != null) {
			String contenido = c.leerContenidoDelArchivo(ubicacionArchivo);
			if (contenido != null) {
				view.escribirDato("Canción seleccionada: \n"+contenido);
			}else {
				view.escribirDato("Error, el archivo no tiene datos");
			}
		}else {
			view.escribirDato("Selección cancelada.");
		}
		break;
	}
	case 3: {
		view.escribirDato("Adios :D");
		break cicloprincipal;
	}
	default: {
		view.escribirDato("Opción no valida.");
	}
	}
	}
	}
}

