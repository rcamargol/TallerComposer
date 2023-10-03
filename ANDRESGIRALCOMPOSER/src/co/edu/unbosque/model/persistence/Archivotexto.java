package co.edu.unbosque.model.persistence;
import java.io.*;
public class Archivotexto {

	
	public void escribirArchivo(String cancion1) {
		   try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\data\\datanumeros.txt"))) {
		        writer.println("Cancion:");
		        
		        writer.println(cancion1);
		        
		    } catch (IOException e) {
		        e.printStackTrace();
		    
}
}
		   
	}
