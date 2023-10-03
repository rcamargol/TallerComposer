package co.edu.unbosque.controller;

import co.edu.unbosque.model.Canción;

import co.edu.unbosque.view.View;
import co.edu.unbosque.model.persistence.*;
public class Controller {
	
	
	private View gui;
	private Canción c;
	private Archivo  a;
	private Propiedades p;
	
	public Controller (Propiedades p, View vista) {
        this.p = p;
        this.gui = vista;
    }


	public void iniciar() {
        int opcion = gui.mostrarMenu();

        switch (opcion) {
            case 1:
            	c = new Canción();
        		String cancion= c.crearCancion(definirparametrosfrases(),definirparametrosEstrofas());
        		a.archivo(cancion);
                break;
            case 2:
            	
            	c = new Canción();
        		String contenido =  c.seleccionarCancion();
        		gui.mostrarcontenido(contenido);
     
                break;
                
           
            default:
        }
	
	}
	
	public int definirparametrosfrases() {
		gui = new View();
	 int  numero = gui.pedirFrases(0);
		return numero ;
	}
	
	public int definirparametrosEstrofas() {
		gui = new View();

			int numero = gui.pedirEstrofa();
			return numero;
	}
	
	
}
