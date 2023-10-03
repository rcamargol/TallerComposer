package co.edu.unbosque.view;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class View {

	public View() {

	}

	public File openArchivo() {

		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de textos personalizados", "txt");
		chooser.setFileFilter(filtro);

		int selection = chooser.showOpenDialog(null);

		if (selection == JFileChooser.APPROVE_OPTION) {
			File fichero = chooser.getSelectedFile();
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

	public String pedirDato() {
		return (JOptionPane.showInputDialog(null, "Ingrese un dato", "Titulo del InputDialog",
				JOptionPane.INFORMATION_MESSAGE));
	}

	/*
	 * metodo de prueba que imprime un dato procesado por un m�todo declarado en
	 * Reemplazar por lo que se necesiten
	 */

	public int pedirNumero() {
		return Integer.parseInt(pedirDato());
	}

	public void escribirDato(String dato) {
		JOptionPane.showMessageDialog(null, dato, "Titulo del Message Dialog", JOptionPane.INFORMATION_MESSAGE);
	}

	public void mostrarMensaje(String dato) {
		JOptionPane.showMessageDialog(null, dato);
	}

	/**
	 *
	 * Este sirve para cuando el usuario quiera digitar un numero distinto
	 */

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
