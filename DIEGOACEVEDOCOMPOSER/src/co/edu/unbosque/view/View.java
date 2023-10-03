package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {
	
	public void message(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public String pedirNombreCancion() {
		return JOptionPane.showInputDialog(null, "Digite el nombre de la canción:");
	}
	
	public int pedirNumero(String msg) {
		int numero = 0;
		boolean salir = false;
		while (!salir) {
			String dato = JOptionPane.showInputDialog(null, msg);
			if (dato == null) {
				throw new NullPointerException();
			}
			if (!dato.equals("")) {
				try {
					numero = Integer.parseInt(dato);
					salir = true;
				} catch (NumberFormatException e) {
					message("El dato ingresado no es válido");
				}
			}
		}
		return numero;
	} 
	
	public int pedirOpcion() {
		String opciones = "";
		opciones += "***********Mix Composer***************\n";
		opciones += "1) Digite número de estrofas y versos.\n";
		opciones += "2) Crear canción\n";
		opciones += "3) Seleccionar canción\n";
		opciones += "4) Salir\n";
		
		int numero = 0;
		String dato = JOptionPane.showInputDialog(null, opciones);
		if (dato == null) {
			return 4;
		}
		try {
			numero = Integer.parseInt(dato);
		} catch (NumberFormatException e) {
			return -1;
		}
		return numero;
	}
}
