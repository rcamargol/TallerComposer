package co.edu.unbsoque.view;

import javax.swing.JOptionPane;

public class View {

	
	public int pedirNumeroDeEstrofas() {

		int numero;

		numero = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Bienvenido, por favor ingrese la cantidad de estrofas que desea en su cancion (es recomendable elegir menos de 4) "));

		return numero;
	}

	public int pedirNumeroFrases() {

		int numero;

		numero = Integer
				.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de frases que desea en su cancion "));

		return numero;
	}

	public void mostrarResultados(String dato) {
		JOptionPane.showMessageDialog(null, dato);
	}

	public int crearMenu() {

		int numeroElegido = 0;
		
		numeroElegido = Integer.parseInt(JOptionPane.showInputDialog(null, "Bienvenido al creador de canciones, por favor ingrese el numero de la opcion deseada \n "
				+ " 1. Asignar Estrofras y Frases \n "
				+ " 2. Crear cancion \n "
				+ " 3. Mostrar por pantalla una cancion \n "
				+ " 4. Salir del programa"));
		
		
		return numeroElegido;

	}
	
	
	public void mostrarOpcionDefault() {
		
		
		JOptionPane.showMessageDialog(null, "ERROR, asegurese que el numero ingresado es correcto");
	}
	
	public String  CambiarNombreDelArchivo() {
		
		String dato = "";
		
		dato = JOptionPane.showInputDialog(null, "Por ultimo, ingrese el nombre de su archivo, tenga en cuenta que: \n"
				+ "1. No puede tener espacios ni caracteres especiales \n"
				+ "2. Tiene que modificar el nombre del archivo, de lo contrario su cancion no sera guardada");
		return dato;
	}
	
	
	public void errorAlLeer() {
		
		
		JOptionPane.showMessageDialog(null, "Error al leer el archivo");
	}
	
}
