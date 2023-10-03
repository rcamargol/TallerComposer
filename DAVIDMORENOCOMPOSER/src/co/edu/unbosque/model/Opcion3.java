package co.edu.unbosque.model;
import java.io.*;

import javax.swing.JFileChooser;

public class Opcion3 {
	
	public String LeerCancion () {
		
		JFileChooser selector = new JFileChooser();
		int sel = selector.showOpenDialog(null);
		StringBuilder cancion = new StringBuilder();
		
		if (sel == JFileChooser.APPROVE_OPTION) {
			
			File song = selector.getSelectedFile();
			
			try {
				
				BufferedReader br = new BufferedReader (new FileReader(song));
				String linea;
				
				while ((linea = br.readLine()) != null) {
					cancion.append(linea).append("\n");
				}
				br.close();
			} catch (IOException ex) {
				return "Ha ocurrido un error, intentelo de nuevo.";
			}
		}
		return cancion.toString();
	}
}
