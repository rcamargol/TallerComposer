package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {
	
	/* metodo de prueba que pide un dato por JOptionPane y retorna el String correspondiente
	 * Reemplazar por lo que se necesiten
	 */
	
	public String menu() 
	{
		String a = JOptionPane.showInputDialog(null,"1.editar parametros\n2.crear cancion\n3.mostrar canciones\n4.salir","Menu Perreo",JOptionPane.INFORMATION_MESSAGE);
		if(a == null) {
			return "4";
		}
		else {
		return a;
		}
	}
	public String pedirnumP() 
	{
		return (JOptionPane.showInputDialog(null,"Dame el numero de parrafos","Parametros",JOptionPane.INFORMATION_MESSAGE));
	}
	public String pedirnumF() 
	{
		return (JOptionPane.showInputDialog(null,"Dame el numero de frases","Parametros",JOptionPane.INFORMATION_MESSAGE));
	}
	
	/* metodo de prueba que imprime un dato procesado por un método declarado en 
	 * Reemplazar por lo que se necesiten
	 */

	public void escribirDato(String dato) 
	{
		JOptionPane.showMessageDialog(null, dato, "Título del Message Dialog", JOptionPane.INFORMATION_MESSAGE);
	}

}
