package co.edu.unbosque.view;
import co.edu.unbosque.controller.*;
import javax.swing.JOptionPane;

public class View {
	
	
	
	 public void mostrarMensaje(String mensaje) {
	        JOptionPane.showMessageDialog(null, mensaje);
	    }
	
	public void mostrarResultados2(int dato) {
		JOptionPane.showMessageDialog(null, dato);
		
		
	}
	
	public int pedirEstrofa() {
		int numero2=0;
		numero2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de estrofas:"));
		return numero2;

		}


		public int pedirFrases(int numero) {
		 numero=0;
		numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de frases por estrofa:"));
		return numero;

		}
		
	
	 public int mostrarMenu() {
	        String[] opciones = {"Crear Canción", "Seleccionar una canción"};
	        int seleccion = JOptionPane.showOptionDialog(
	            null,
	            "Seleccione una opción:",
	            "Menú",
	            JOptionPane.DEFAULT_OPTION,
	            JOptionPane.PLAIN_MESSAGE,
	            null,
	            opciones,
	            opciones[0]
	        );

	     return  seleccion +1;}
		
		public void mostrarcontenido(String contenido) {
			if (contenido != null) {
	            JOptionPane.showMessageDialog(null, "Contenido de la canción:\n" + contenido);
	        } else {
	            JOptionPane.showMessageDialog(null, "No se seleccionó una canción válida.");
	        }
	    
		}
}
