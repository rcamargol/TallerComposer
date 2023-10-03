package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {
   
	public  int obtenerCantidadEstrofas() {
        
		String entrada = JOptionPane.showInputDialog(null, "Ingrese la cantidad de estrofas:");
        try {
            return Integer.parseInt(entrada);
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada no válida. Ingrese un número entero.");
            return obtenerCantidadEstrofas();
        }
    }

    public  int obtenerCantidadFrasesPorEstrofa() {
        String entrada = JOptionPane.showInputDialog(null, "Ingrese la cantidad de frases por estrofa:");
        try {
            return Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada no válida. Ingrese un número entero.");
            return obtenerCantidadFrasesPorEstrofa();
        }
    }

    public String obtenerNombreArchivo() {
        return JOptionPane.showInputDialog(null, "Ingrese el nombre del archivo (incluyendo la ruta completa, por ejemplo,C:\\data\\micancion.txt):");
    }
    
	

	public void escribirDato(String dato) 
	{
		JOptionPane.showMessageDialog(null, dato, "Título del Message Dialog", JOptionPane.INFORMATION_MESSAGE);
	}
	  
	public int mostrarMenu() {
	    int seleccion = 0;

	    while (seleccion < 1 || seleccion > 4) {
	        try {
	            String input = JOptionPane.showInputDialog(
	                null,
	                "Seleccione una opción:\n"
	                + "1. Definir parámetros\n"
	                + "2. Crear canción\n"
	                + "3. Mostrar canción creada\n"
	                + "4. Salir"
	            );

	            if (input == null) {
	               
	                System.exit(0);
	            }

	            seleccion = Integer.parseInt(input);

	        } catch (NumberFormatException e) {
	         
	        }
	    }

	    return seleccion;
	}
}

