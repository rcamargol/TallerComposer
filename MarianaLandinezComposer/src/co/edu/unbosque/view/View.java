package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {
	
	
	public void mostrarResultados(String dato) {
		JOptionPane.showMessageDialog(null, dato);
	}


	public String pedirNombreArchivo() {
		String dato = "";
		dato = JOptionPane.showInputDialog(null, "Ingrese el nombre que desea para su archivo :");
		return dato;
	}

	public int pedirNumeroEstrofas() {
		int numero = 0;
		numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingresa la cantidad de estrofas que deseas para tu cancion." +
		"\n"+ "RECUERDA: por convencion una cancion NO tiene mas de 4 estrofas"));
		return numero;

	}
	public int pedirNumeroFrases() {
		int numero = 0;
		numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingresa la cantidad de frases que deseas para tu cancion"));
		return numero;
		
		
	}public int pedirOpcionMenu() {
			int numero = 0;
			numero = Integer.parseInt(JOptionPane.showInputDialog(null, "                           REGUETON COMPOSER          " +"\n"+"Por favor ingrese el numero de la opcion que desea seleccionar:"+"\n"+
			"1. Establecer parametros para la cancion que desea crear"+ "\n"+ "2. Crear Cancion"+"\n"+ "3. Visualizar canciones creadas"+"\n"+ "4. Salir"));
			return numero;
		
	}
	
	
	}
	

			
		


