package co.edu.unbosque.model.persistence;
 import java.io.*;
 
public class ClaseFile {
	
private String archivodata = "c:\\data\\datanumeros.txt";
	
	public int escribirArchivo(String NombreArchivo,String dato) {
		
		File f = new File(this.archivodata); 
		
		try {
			FileWriter fw = new FileWriter(f); 
			PrintWriter pw = new PrintWriter(fw); 
			
			pw.println(dato); 
			
			fw.close();
			
		} catch (IOException e) {
			return -1;
		} 
		
		return 0;
	}
	
	public String leerArchivo() {
		
		String linea = "";
		String cadena = "";
		
		File f = new File(this.archivodata); 
		
		try {
			FileReader fr = new FileReader(f); 
			BufferedReader br = new BufferedReader(fr); 
			linea = br.readLine();      
			while (linea != null) {    
				cadena += linea;      
				linea = br.readLine(); 
			}
			fr.close();
		} 
		catch (IOException e) {
			return null;
		}
		return cadena;
	}

}
