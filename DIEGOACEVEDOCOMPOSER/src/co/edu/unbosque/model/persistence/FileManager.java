package co.edu.unbosque.model.persistence;

import java.io.*;

import javax.swing.JFileChooser;

public class FileManager {
	
	private String rutaArchivo = "C:\\Data\\archivo.txt";
	private JFileChooser chooser = new JFileChooser();
	public int escribirArchivo(String mensaje, String nombreCancion) {
		setRutaArchivo("C:\\\\Data\\\\" + nombreCancion + ".txt");
		File f = new File(this.rutaArchivo);
		
		try {
			FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw);
			
			pw.write(mensaje);
			
			pw.close();
			
		} catch(IOException e) {
			return -1;
		}
		return 0;
	}
	
	public String leerArchivo() {
		
		File f = new File(this.rutaArchivo);
		
		String contenido = "", linea = "";
		
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			linea += br.readLine();
			while (linea != null) {
				contenido += linea + "\n";
				linea = br.readLine();
			}
			
			br.close();
			
		} catch(IOException e) {
			return null;
		}
		return contenido;
	}
	
	public void getArchivo() {
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			setRutaArchivo(chooser.getSelectedFile().toString());
		} else {
			setRutaArchivo(null);
		}
	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public JFileChooser getChooser() {
		return chooser;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

	public void setChooser(JFileChooser chooser) {
		this.chooser = chooser;
	}
}
