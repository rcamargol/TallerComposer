package co.edu.unbosque.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class View {
	
	private JFileChooser chooser = new JFileChooser();
	
	public String pedirDato(String dato) {
		return JOptionPane.showInputDialog(dato);
	}
	
	public void mostrarDato(String dato) {
		JOptionPane.showMessageDialog(null, dato);
	}
	
	public int obtenerOpcionMenu() {
		String texto_menu = "";
		texto_menu += "Digite una opcion: \n";
		texto_menu += "1) Dame un numero de versos y de estrofas para la cancion." + "\n";
		texto_menu += "2) Seleccionar canción creada.\n";
		texto_menu += "3) Salir.\n";
		
		int opcion = Integer.parseInt(JOptionPane.showInputDialog(texto_menu));
		return opcion;
	}
	
	public void mostrarArchivo() {
		int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = chooser.getSelectedFile();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(archivoSeleccionado));
                StringBuilder fileContent = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    fileContent.append(line).append("\n");
                }
                reader.close();
                
                JOptionPane.showMessageDialog(null, "Canción:\n" + fileContent.toString(), archivoSeleccionado.toString(), JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error a la lectura del archivo.", "Error de lectura", JOptionPane.ERROR_MESSAGE);
            }
        }
	}

	public JFileChooser getChooser() {
		return chooser;
	}

	public void setChooser(JFileChooser chooser) {
		this.chooser = chooser;
	}
}
