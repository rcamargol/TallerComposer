package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {

	
	public int pedirNumeroDeEstrofas() {

		int numero;

		numero = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Eliga el numero de estrofas para su cancion(es recomendable elegir menos de 4) "));

		return numero;
	}

	public int pedirNumeroFrases() {

		int numero;

		numero = Integer
				.parseInt(JOptionPane.showInputDialog(null, "Eliga la cantidad de frases que quiere para su cancion "));

		return numero;
	}

	public void mostrarResultados(String dato) {
		JOptionPane.showMessageDialog(null, dato);
	}

	public int crearMenu() {

		int numeroElegido = 0;
		
		numeroElegido = Integer.parseInt(JOptionPane.showInputDialog(null, "Creador de canciones de reggaeton en menos de 30 segundos \n "
				+ " 1. Eliga la composicion de frases y estrofas de la cancion \n "
				+ " 2. Escriba el nombre de su cancion de reggaeton \n "
				+ " 3. Abra el archivo y disfrute de su cancion para ser el nuevo exito del verano :D \n "
				+ " 4. Salir del programa"));
		
		
		return numeroElegido;

	}
	
	
	public void mostrarOpcionDefault() {
		
		
		JOptionPane.showMessageDialog(null, "El numero ingresado es incorrecto :( ");
	}
	
	public String  CambiarNombreDelArchivo() {
		
		String dato = "";
		
		dato = JOptionPane.showInputDialog(null, "Ingrese el nombre de su cancion de reggaeton: \n"
				+ "1. No puede tener espacios ni caracteres especiales \n"
				+ "2. Tiene que modificar el nombre del archivo, de lo contrario su cancion no sera guardada");
		return dato;
	}
	
	
	public void errorAlLeer() {
		
		
		JOptionPane.showMessageDialog(null, "Error al leer el archivo");
	}
	
}
