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
		texto_menu += "INGRESA UNA OPCION: \n";
		texto_menu += "1) INGRESAR EL NUMERO DE ESTROFAS Y FRASES." + "\n";
		texto_menu += "2) CREAR CANCION.\n";
		texto_menu += "3) SELECCIONAR CANCION CREADA.\n";
		texto_menu += "4) SALIR.\n";
		
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
                JOptionPane.showMessageDialog(null, "CANCION:\n" + fileContent.toString(), archivoSeleccionado.toString(),
                		JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "ERROR AL SALIR DE LA LECTURA DEL ARCHIVO.", "ERROR DE LECTURA"
                		+ "", JOptionPane.ERROR_MESSAGE);
            }
        }
	}
}
