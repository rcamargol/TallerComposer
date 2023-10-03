package co.edu.unbosque.model.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;


import co.edu.unbosque.model.Canciones;
import co.edu.unbosque.view.View;

public class Archivos {
	
	private File cancion;
	private JFileChooser select;
	private View gui = new View(); 
	private Canciones c = new Canciones();
	
	
	public void crearCarpeta() {
		File carpeta = new File("C:\\Canciones");
		if(!carpeta.exists()) {
			carpeta.mkdirs();
		}
	}
	
	public void mostrarDirectorio() {
		select = new JFileChooser("C:\\Canciones");
		select.showOpenDialog(null);
		setCancion(select.getSelectedFile());
	}

	
	int i=1;
	public void crearArchivo() {
		
		cancion = new File("c:\\Canciones\\Cancion "+i+".txt");
		
		try {
			while(cancion.exists()) {
				i++;
				cancion = new File("c:\\Canciones\\Cancion "+i+".txt");
			}
			if(cancion.createNewFile()) {
				gui.checkMessage();
			}
			else {
				gui.failMessage();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void crearCancion() {
			try {
				FileWriter fw = new FileWriter(cancion);
				PrintWriter pw = new PrintWriter(fw);
				Propiedades prop = new Propiedades();
				
				int nfrases = Integer.parseInt(prop.getFrases());
				int nestrofas = Integer.parseInt(prop.getEstrofas());
				
				for(int j=1;j<=nestrofas;j++) {
					for(int i=1; i<=nfrases;i++) {
						pw.println(c.crearCancion());
						if(i==nfrases) {
						pw.println();
						}
					}
				}
				fw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//mostrarDirectorio();
	}
	
	public String leerArchivo() {
		String letra = "";
		String linea = "";
		try {
			FileReader lect = new FileReader(cancion);
			
			if(lect.ready()) {
				BufferedReader leer = new BufferedReader(lect);
				
				while((linea = leer.readLine())!=null) {
					letra+=linea+"\n";
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return letra;
	}
	
	public String verPropiedades() {
		Propiedades prop = new Propiedades();
		prop.escribirPropiedades();
		return "Las propiedades de la cancion son: "+"\n"+prop.leerPropiedades();
	}

	public File getCancion() {
		return cancion;
	}

	public void setCancion(File cancion) {
		this.cancion = cancion;
	}

}
