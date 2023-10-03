package co.edu.unbosque.model.persistence;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class ArchivosCanciones {
		public int escritorArchivos(String dato, File archivo) {

			try {
				FileWriter escritor = new FileWriter(archivo);

				PrintWriter mostrador = new PrintWriter(escritor);

				mostrador.println(dato);

				escritor.close();

			} catch (IOException e) {
				return -1;
			}

			return 0;

		}

		public String leerArchivo(File archivo) {

			String fila = "";
			String secuencia = "";

			try {
				FileReader lea = new FileReader(archivo);
				BufferedReader lecAlm = new BufferedReader(lea);
				fila = lecAlm.readLine();
				while (secuencia != null) {
					secuencia += fila;
					fila = lecAlm.readLine();
				}
				lea.close();
			} catch (IOException e) {
				return null;
			}
			return secuencia;
		
	}

}
