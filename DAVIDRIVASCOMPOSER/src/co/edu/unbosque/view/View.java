package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {

	public String mostrarMenu(String menu) {
		String saludo = "¡BIENVENIDO! \n INGRESA EL VALOR DE LA ACCION QUE DESEAS EJECUTAR \n 1. SELECCIONAR EL NUMERO DE FRASES Y ESTROFAS QUE DESEA QUE TENGA LA CANCION . \n 2. CREAR LA CANCION. \n 3. ABRIR UNA CANCION YA HECHA.";
		String dato = JOptionPane.showInputDialog(null, saludo);
		return dato;
	}
	
	public String definirNumFrases() {
		String mensaje = "Digite el numero (diferente de cero) de frases que quiera que tenga cada estrofa";
		String numFrases = JOptionPane.showInputDialog(null, mensaje);
		return numFrases;
	}
	
	public String definirNumEstrofas() {
		String mensaje = "Digite el numero (diferente de cero) de estrofas que quiera que tenga la cancion";
		String numEstrofas = JOptionPane.showInputDialog(null, mensaje);
		return numEstrofas;
	}
	
	public void checkMessage() {
		String check = "Archivo creado con exito";
		JOptionPane.showMessageDialog(null, check, "Cancion Lista!", 1);
	}
	public void failMessage() {
		String fail = "El archivo no se pudo crear";
		JOptionPane.showMessageDialog(null, fail,"", 2);
	}
	
	public void mostrarCancion(String letra) {
		JOptionPane.showMessageDialog(null, letra, "Letra", 1);
	}
	
	public void mostrarPropiedades(String prop) {
		JOptionPane.showMessageDialog(null, prop);
	}
	
	public void mostrarErrorAlDigitar() {
		String errorDigito = "La opcion digitada no se encuentra en el menu";
		JOptionPane.showMessageDialog(null, errorDigito, "ERROR", 2);
	}
	
	public void mostrarErrorPropiedades() {
		String errorPropiedades = "Las propiedades de la cancion no han sido inicializadas. \n Digite la opcion 1 para establecerlas";
		JOptionPane.showMessageDialog(null, errorPropiedades, "LAS PROPIEDADES DE LA CANCION NO EXISTEN", 2);
	}
	
	public void salir() {
		String salida = "El programa fue cerrado con exito \n\n Presione la tecla 'Enter' dos veces para salir";
		JOptionPane.showMessageDialog(null, salida);
	}
	
}
