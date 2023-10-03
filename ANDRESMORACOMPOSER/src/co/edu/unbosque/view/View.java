package co.edu.unbosque.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class View {

	public View() {

	}

	public File abrirArchivo() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt");
		fileChooser.setFileFilter(filter);

		int seleccion = fileChooser.showOpenDialog(null);

		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File fichero = fileChooser.getSelectedFile();
			if (!fichero.getName().toLowerCase().endsWith(".txt")) {
				fichero = new File(fichero.getAbsolutePath() + ".txt");
			}
			return fichero;
		}

		return null;
	}
	/*
	 * metodo de prueba que pide un dato por JOptionPane y retorna el String
	 * correspondiente Reemplazar por lo que se necesiten
	 */

	

	/*
	 * metodo de prueba que imprime un dato procesado por un m�todo declarado en
	 * Reemplazar por lo que se necesiten
	 */
	public void escribirDato(String dato) {
		JOptionPane.showMessageDialog(null, dato, "Titulo del Message Dialog", JOptionPane.INFORMATION_MESSAGE);
	}

	public void mostrarMensaje(String dato) {
		JOptionPane.showMessageDialog(null, dato);
	}

	public int pedirNumeroEstrofas() {
		String input = JOptionPane.showInputDialog("Ingrese el número de estrofas:");
		try {
			int numEstrofas = Integer.parseInt(input);
			return numEstrofas;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
			return pedirNumeroEstrofas(); // Vuelve a pedir el número si no es válido
		}
	}

	public int pedirNumeroFrases() {
		String input = JOptionPane.showInputDialog("Ingrese el número de frases por estrofa:");
		try {
			int numFrases = Integer.parseInt(input);
			return numFrases;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
			return pedirNumeroFrases(); // Vuelve a pedir el número si no es válido
		}
	}
}