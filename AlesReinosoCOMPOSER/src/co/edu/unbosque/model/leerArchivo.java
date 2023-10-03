package co.edu.unbosque.model;
import co.edu.unbosque.model.persistence.*;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.crypto.Data;
import co.edu.unbosque.model.persistence.*;
public class leerArchivo{
	public static String presenta() {
		EjemploFile n = new EjemploFile();
		JFileChooser buscador = new JFileChooser();
		buscador.showOpenDialog(buscador);
		try {
			String patch = buscador.getSelectedFile().getAbsolutePath();
			//Creamos el filtro
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
			 
			//Le indicamos el filtro
			buscador.setFileFilter(filtro);
			FileInputStream archivo = new FileInputStream(patch);

			DataInputStream entrada = new DataInputStream(archivo);
			
			BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));

			File selectedFile = buscador.getSelectedFile();
			String lugar = selectedFile.getAbsolutePath();
			n.setArchivodata(lugar);
			
			
			entrada.close();
			

		}catch(Exception e) {
			return null;
		}
		return n.leerArchivo();
	}
}
