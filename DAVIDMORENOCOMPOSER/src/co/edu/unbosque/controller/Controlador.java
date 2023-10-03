package co.edu.unbosque.controller;
import co.edu.unbosque.model.Modelo;
import co.edu.unbosque.view.Vista;

public class Controlador {
	
	private Vista view;
	private Modelo model;
	
	public Controlador () {
		
		this.view = new Vista ();
		this.model = new Modelo ();
	}
	
	public void Funcionar () {
		
		boolean valido = false;
		
		while (valido == false) {
			
			int opc = view.ShowMenu();
			
			if (opc == 1) {
				
				valido = true;
				String estrofas = view.ShowOption("Ingrese el numero de estrofas:");
				String frases = view.ShowOption("Ingrese el numero de frases por estrofa:");
				int gd = model.op1.EscribirArchivoProp(estrofas, frases);
				
				if (gd == -1) {
					
					view.ShowMessage("Ha ocurrido un error creando el archivo. Por favor intente de nuevo.");
				} else {
					
					view.ShowMessage(model.op2.LeerArchivoProp(model.op1.prop , model.op1.propFile));
				}
	
			} else if (opc == 2) {
				
				valido = true;
				
				String estrofas = view.ShowOption("Ingrese el numero de estrofas:");
				String frases = view.ShowOption("Ingrese el numero de frases por estrofa:");
				int gd = model.op1.EscribirArchivoProp(estrofas, frases);
				
				if (gd == -1) {
					
					view.ShowMessage("Ha ocurrido un error creando el archivo. Por favor intente de nuevo.");
				} else {
					
					view.ShowMessage(model.op2.LeerArchivoProp(model.op1.prop , model.op1.propFile));
				}
				
			} else if (opc == 3){
				
				valido = true;
				view.ShowMessage(model.op3.LeerCancion());
			} 
		}
	}
}