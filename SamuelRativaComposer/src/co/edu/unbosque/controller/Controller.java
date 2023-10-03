package co.edu.unbosque.controller;

import co.edu.unbosque.view.*;
import co.edu.unbosque.model.*;

public class Controller {
  private View vw;
  private Cancion cancion;
	
	public Controller() {
		vw = new View();
		vw.Menu();
		cancion=new Cancion();
		int numero=0;
		
		
			try {
				numero=vw.Menu();
			}catch(NumberFormatException e) {
				System.out.print("El progrma finalizo"); 
			}
			switch(numero){
			case 1:
				String NombreArchivo = vw.pedirDato("Nombre de su cancion: ");
				int NumeroEstrofas = Integer.parseInt(vw.pedirDato("Numero de estrofas de la cancion: "));
				int NumeroVersos = Integer.parseInt(vw.pedirDato("Numero de versos de la cancion: "));
				cancion.Propiedades(NombreArchivo, NumeroEstrofas, NumeroVersos);
				cancion.CrearCancion(NombreArchivo, NumeroEstrofas, NumeroVersos);
				break;
			case 2:
				vw.MostrarDato("La cancion ha sido creada exitosamente");
				break;
			case 3:
				vw.MostrarArchivoCreado();
				
			}
			
		
	}

}
