package co.edu.unbosque.model.persistence;

import java.io.*;

public class File1 {
	
	public int escribirArchivo(String dato, File archivo) {
		
		//File f = new File(archivo); // f-> carga el archivo
		String nombre = archivo+".txt";
		try {
			FileWriter fw = new FileWriter(nombre, true); // fr-> Crea el flujo hacia f
			PrintWriter pw = new PrintWriter(fw); //pw-> Permite la escritura en el archivo
			
			pw.println(dato); //se escribe el contenido del par�metro dato en el archivo
			fw.close();
			
		} catch (IOException e) {
			return -1;
		} 
		
		return 0;
	}
	
	public String leerArchivo(File archivo) {
		
		String linea = "";
		String cadena = "";
		String nombre = archivo+".txt";
		
		File f = new File(nombre); // f-> carga el archivo
		
		try {
			FileReader fr = new FileReader(f); // fr-> Crea el flujo desde f
			BufferedReader br = new BufferedReader(fr); //br ->permite la lectura
			linea = br.readLine();     //linea toma el valor de la primera linea le�da 
			while (linea != null) {    //mientras haya datos por leer en el archivo
				cadena += linea;       //acumular en cadena lo leido en linea
				linea = br.readLine(); //leer el valor de la siguiente linea
			}
			fr.close();
		} 
		catch (IOException e) {
			return null;
		}
		return cadena;
	}
}
