package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EjercicioArchivo {
	
public int crearArchivos(String cancion, String nombreArchivo) {
		
		
		File f= new File(nombreArchivo); 
		
		
		if (!f.exists()) {
			try {
				f.createNewFile();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (f.exists())	{
		try {
				FileWriter fw = new FileWriter(f); 
				PrintWriter pw = new PrintWriter(fw); 
				pw.println(cancion); 
				
				fw.close();
				
			} catch (IOException e) {
				return -1;
			} 
		}
		
		
	return 0;
		
		
	}

}
