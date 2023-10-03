package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {
   
	public  int obtenerCantidadEstrofas() {
        
		String entrada = JOptionPane.showInputDialog(null, "Ingrese la cantidad de estrofas:");
        try {
            return Integer.parseInt(entrada);
        }
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada no v�lida. Ingrese un n�mero entero.");
            return obtenerCantidadEstrofas();
        }
    }

    public  int obtenerCantidadFrasesPorEstrofa() {
        String entrada = JOptionPane.showInputDialog(null, "Ingrese la cantidad de frases por estrofa:");
        try {
            return Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada no v�lida. Ingrese un n�mero entero.");
            return obtenerCantidadFrasesPorEstrofa();
        }
    }

    public String obtenerNombreArchivo() {
        return JOptionPane.showInputDialog(null, "Ingrese el nombre del archivo (incluyendo la ruta completa, por ejemplo,C:\\data\\micancion.txt):");
    }
    
	

	public void escribirDato(String dato) 
	{
		JOptionPane.showMessageDialog(null, dato, "T�tulo del Message Dialog", JOptionPane.INFORMATION_MESSAGE);
	}
	  
	public int mostrarMenu() {
	    int seleccion = 0;

	    while (seleccion < 1 || seleccion > 4) {
	        try {
	            String input = JOptionPane.showInputDialog(
	                null,
	                "Seleccione una opci�n:\n"
	                + "1. Definir par�metros\n"
	                + "2. Crear canci�n\n"
	                + "3. Mostrar canci�n creada\n"
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

