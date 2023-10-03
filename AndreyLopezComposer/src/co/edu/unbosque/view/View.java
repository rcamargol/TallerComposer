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
		texto_menu += "1) Digitar número de estrofas y frases por estrofas." + "\n";
		texto_menu += "2) Crear canción.\n";
		texto_menu += "3) Seleccionar canción creada.\n";
		texto_menu += "4) Salir.\n";
		
		int opcion = Integer.parseInt(JOptionPane.showInputDialog(texto_menu));
		return opcion;
	}
	
	public void mostrarArchivo() {
		int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = chooser.getSelectedFile();
            try {
                // Leer el contenido del archivo
                BufferedReader reader = new BufferedReader(new FileReader(archivoSeleccionado));
                StringBuilder fileContent = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    fileContent.append(line).append("\n");
                }
                reader.close();
                
                // Mostrar el contenido del archivo en un JOptionPane
                JOptionPane.showMessageDialog(null, "Canción:\n" + fileContent.toString(), archivoSeleccionado.toString(), JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al realizar la lectura del archivo.", "Error de lectura", JOptionPane.ERROR_MESSAGE);
            }
        }
	}
}
