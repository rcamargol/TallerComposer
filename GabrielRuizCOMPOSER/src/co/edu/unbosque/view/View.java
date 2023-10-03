package co.edu.unbosque.view;
import javax.swing.JOptionPane;

public class View {
	  public static int mostrarMenu() {
		  
	        String[] opciones = {" recibir datos ", " crear cancion ", "Mostrar canción", "Salir"};
	        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
	        
	        seleccion++;

	        return seleccion;
	    }

		public void escribirDato(String dato) 
		{
			JOptionPane.showMessageDialog(null, dato, "Título del Message Dialog", JOptionPane.INFORMATION_MESSAGE);
		}
	    public String crearCancion(int numEstrofas, int numFrases) {
	       
	        String cancion = "Canción creada con " + numEstrofas + " estrofas y " + numFrases + " frases.";
	        return cancion;
	    }

		public String generarNombre() {
		
			return null;
		}
}