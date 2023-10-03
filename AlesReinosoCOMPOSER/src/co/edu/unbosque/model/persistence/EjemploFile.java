package co.edu.unbosque.model.persistence;

import java.io.*;

public class EjemploFile {
	
	private String archivodata = "c:\\data\\datanumeros.txt";
	
	public int escribirArchivo(String dato) {
		
		File f = new File(this.archivodata); // f-> carga el archivo
		
		try {
			FileWriter fw = new FileWriter(f); // fr-> Crea el flujo hacia f
			PrintWriter pw = new PrintWriter(fw); //pw-> Permite la escritura en el archivo
			

					pw.println(dato); //se escribe el contenido del parámetro dato en el archivo
			
			
			fw.close();
			
		} catch (IOException e) {
			return -1;
		} 
		
		return 0;
	}
	
	public String leerArchivo() {
		
		String linea = "";
		String cadena = "";
		
		File f = new File(this.archivodata); // f-> carga el archivo
		
		try {
			FileReader fr = new FileReader(f); // fr-> Crea el flujo desde f
			BufferedReader br = new BufferedReader(fr); //br ->permite la lectura
			linea = br.readLine();     //linea toma el valor de la primera linea leída 
			while (linea != null) {    //mientras haya datos por leer en el archivo
				cadena += linea+"\n";       //acumular en cadena lo leido en linea
				linea = br.readLine(); //leer el valor de la siguiente linea
			}
			fr.close();
		} 
		catch (IOException e) {
			return null;
		}
		return cadena;
	}

	public String getArchivodata() {
		return archivodata;
	}

	public void setArchivodata(String archivodata) {
		this.archivodata = archivodata;
	}
	

}
