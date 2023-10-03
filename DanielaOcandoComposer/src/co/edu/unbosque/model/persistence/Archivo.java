package co.edu.unbosque.model.persistence;
import javax.swing.*;
import java.io.*;
public class Archivo {

	
	public static void archivo(String cancion) {
		
		
	        JFileChooser fileChooser = new JFileChooser();
	        int resultado = fileChooser.showSaveDialog(null);

	        if (resultado == JFileChooser.APPROVE_OPTION) {
	            File archivoSeleccionado = fileChooser.getSelectedFile();
	            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSeleccionado))) {
	                writer.write(cancion);
	                JOptionPane.showMessageDialog(null, "Guardado exitosamente");
	            } catch (IOException e) {
	                e.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Error al guardar el archivo.");
	            }
	        } else if (resultado == JFileChooser.CANCEL_OPTION) {
	            System.out.println("Operación cancelada.");
	        }
	    }
	}

