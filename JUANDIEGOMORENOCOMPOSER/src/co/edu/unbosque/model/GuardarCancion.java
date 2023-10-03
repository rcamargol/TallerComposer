package co.edu.unbosque.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.view.View;

public class GuardarCancion {
	private View view;
	
	public boolean escribirArchivo(String rutaArchivo, String contenido) {
        try {
            FileWriter fw = new FileWriter(rutaArchivo);
            PrintWriter pw = new PrintWriter(fw);

            pw.println(contenido);

            fw.close();

            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
	
	public String leerArchivo(String rutaArchivo) {
        try {
            StringBuilder contenido = new StringBuilder();
            FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }

            br.close();
            return contenido.toString();
        } catch (IOException e) {
            return null;
        }
	}

    public boolean guardarCancionConFileChooser(String contenido) {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showSaveDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            String nombreArchivo = archivo.getAbsolutePath();

            if (!nombreArchivo.endsWith(".txt")) {
                nombreArchivo += ".txt"; 
            }

            return escribirArchivo(nombreArchivo, contenido);
        } else {
            return false; 
        }
    }
    
    public String abrircancion() {
    	JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            return leerArchivo(archivoSeleccionado.getAbsolutePath());
        } else {
            return null;
        }
    }
    
}

