package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {
	public View() {
		// TODO Auto-generated constructor stub
	}
	public String pedirDato() {
		return (JOptionPane.showInputDialog(null,"Por favor seleccione una opcion:"
				+ "\n1. Definir parametros (numero de estrofas, numero de frases)"
				+ "\n2. Crear cancion"
				+ "\n3. Seleccionar una cancion creada"
				+ "\n4. Salir"));
	}
	
	public String pedirNumEstrofas() {
		return (JOptionPane.showInputDialog(null,"Por favor, digite el numero de estrofas"));
	}
	
	public String pedirNumFrases() {
		return (JOptionPane.showInputDialog(null,"Por favor, digite el numero de frases"));
	}
	
	public String pedirNombre() {
		return (JOptionPane.showInputDialog(null,"¿Como se va a llamar la cancion?"));
	}

	public void escribirDato(String dato) 
	{
		JOptionPane.showMessageDialog(null, dato, "T�tulo del Message Dialog", JOptionPane.INFORMATION_MESSAGE);
	}
}
