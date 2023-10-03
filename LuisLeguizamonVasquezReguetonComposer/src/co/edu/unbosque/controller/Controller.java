package co.edu.unbosque.controller;
import co.edu.unbosque.model.CancionRegueton;
import co.edu.unbosque.view.View;

public class Controller {
	
	private View view;
	private CancionRegueton regueton;
	
	public Controller() {
		view = new View();
		 regueton = new CancionRegueton();
		
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
				int NumeroDeEstrofas = Integer.parseInt(view.pedirDato("Dame un numero de estrofas que quieras que tenga la cancion: "));
				int NumeroDeVersos = Integer.parseInt(view.pedirDato("Dame un numero de versos que quieras que tenga la cancion : "));
				String NombreDelArchivo = view.pedirDato("Pon el nombre al archivo que quieras: ");
				regueton.gestionaPropiedades(NumeroDeVersos, NumeroDeEstrofas, NombreDelArchivo);
				regueton.resultadoCancion(NumeroDeVersos, NumeroDeEstrofas, NombreDelArchivo);
				break;
			case 2:
				view.mostrarArchivo();
				break;
			case 3:
				run = false;
				break;
			}
		}
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public CancionRegueton getRegueton() {
		return regueton;
	}

	public void setRegueton(CancionRegueton regueton) {
		this.regueton = regueton;
	}
}