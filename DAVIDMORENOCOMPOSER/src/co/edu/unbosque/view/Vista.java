package co.edu.unbosque.view;
import javax.swing.JOptionPane;

public class Vista {
	
	public void ShowMessage (String txt) {
		
		JOptionPane.showMessageDialog(null, txt);
	}
	
	public String ShowOption (String txt) {
		
		String opcion = JOptionPane.showInputDialog(txt);
		
		return opcion;
	}
	
	public int ShowMenu () {
		
		String opcion =JOptionPane.showInputDialog(null, "Seleccione una opción:\n"
				+ " 1) Elegir numero de frases y estrofas.\n"
				+ " 2) Crear canción.\n"
				+ " 3) Elegir canción creada.");
		
		return Integer.parseInt(opcion);
	}
}
