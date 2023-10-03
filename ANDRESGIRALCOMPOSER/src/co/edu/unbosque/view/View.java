package co.edu.unbosque.view;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Fachada;

public class View {
	 Fachada f=new Fachada();
	   public int mostrarOpciones() {
	        return JOptionPane.showOptionDialog(null, "Seleccione una opción", "Crear cancion",
	                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
	                new String[] { "Propiedades de la cancion", "Crear cancion","Volar" }, 0);
	    }
	    public void mostrarMensajeExito(String mensaje) {
	        JOptionPane.showMessageDialog(null, mensaje);
	    }

	    public void mostrarMensajeError(String mensaje) {
	        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	    }
	    public String pedirValor1() {
	        return JOptionPane.showInputDialog(null, "Ingrese numero de estrofas", "Numero de estrofas", JOptionPane.QUESTION_MESSAGE);
	    }

	    public String pedirValor2() {
	        return JOptionPane.showInputDialog(null, "Ingrese numero de frases", "Numero de frases", JOptionPane.QUESTION_MESSAGE);
	    }	    
}
