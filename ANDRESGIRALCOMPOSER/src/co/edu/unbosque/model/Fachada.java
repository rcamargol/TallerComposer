package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.ArchivoProperties;
import co.edu.unbosque.model.persistence.Archivotexto;
import co.edu.unbosque.view.View;

public class Fachada {
	private View view;
	private ArchivoProperties archivoproperties;
	private Archivotexto archivotexto;
	private Letra letra;
	private Fachada fachada;

	 public void procesarOpcion(int opcion) {
		 view=new View();
		 archivoproperties=new ArchivoProperties();
		 archivotexto=new Archivotexto();
		 letra=new Letra();
	        if (opcion == 0) {
	        	  String estrofas = view.pedirValor1();
	              String frases = view.pedirValor2();
	              if (estrofas != null && frases != null) {
	                  archivoproperties.crearArchivoProperties(estrofas, frases);
	                  view.mostrarMensajeExito("Archivo properties creado exitosamente.");
	              } else {
	                  view.mostrarMensajeError("Debe ingresar valores para clave1 y clave2.");
	              }
	        } else if (opcion == 1) {
	        	String estrofas = view.pedirValor1();
	              String frases = view.pedirValor2();
	            String cancion1=letra.crearCancion(Integer.parseInt(estrofas),Integer.parseInt(frases));
	            archivotexto.escribirArchivo(cancion1);
	            
	            view.mostrarMensajeError("Archivo creado exitozamente");
	    
	     

	            
	    }
}
}