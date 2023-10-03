package co.edu.unbsoque.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Chooser {

	public static String seleccionarArchivo() {

		JFileChooser jf = new JFileChooser();

		int valorDeRetorno = jf.showOpenDialog(null);

		if (valorDeRetorno == JFileChooser.APPROVE_OPTION) {

			File selectedFile = jf.getSelectedFile();

			return selectedFile.getAbsolutePath();

		} else {

			return null;
		}

	}

	public static String leerContenidoDelArchivo(String ruta) {

		try {

			File archivo = new File(ruta);

			FileReader fr = new FileReader(archivo);

			BufferedReader br = new BufferedReader(fr);

			StringBuilder contenido = new StringBuilder();

			String linea;

			while ((linea = br.readLine()) != null) {
				contenido.append(linea).append("\n");
			}

			br.close();
			fr.close();
			return contenido.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

}
