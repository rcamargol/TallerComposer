package co.edu.unbosque.model;
import javax.swing.*;
import java.io.*;

import co.edu.unbosque.model.persistence.Propiedades;
import java.util.Random;
public class Canción {
	

	private String palabras[]= {"Mami","Bebe","Princess","Mami"};
	private String palabras2[]= {"Yo quiero","Yo puedo","Yo vengo a","Voy a"};
	private String palabras3[]= {"Encenderte","Amarte","Ligar","jugar"};
	private String palabras4[]= {"Suave","Lento","Rapido","Fuerte"};
	private String palabras5[]= {"Hasta que salga el sol","toda la noche","Hasta el amanecer","Todo el dia"};
	private String palabras6[]= {"Sin anestesia","Sin compromiso","Face to Face","Sin miedo"};


	public String crearCancion(int numEstrofas, int frasesPorestrofas) {
		Random aleatorio = new Random();
		StringBuilder cancion = new StringBuilder();
		for(int i=0; i<numEstrofas; i++) {
			 cancion.append("Estrofa ").append(i).append(":\n");
			for(int j =0; j<frasesPorestrofas; j++) {
			
		String palabra= palabras [aleatorio.nextInt(palabras.length)];
		String palabra2 = palabras2[aleatorio.nextInt(palabras2.length)];
		String palabra3 = palabras3[aleatorio.nextInt(palabras3.length)];
		String palabra4 = palabras4[aleatorio.nextInt(palabras4.length)];
		String palabra5 = palabras5[aleatorio.nextInt(palabras5.length)];
		String palabra6 = palabras6[aleatorio.nextInt(palabras6.length)];
			String frases = palabra + " " +palabra2 + " " +palabra3 + " " + palabra4 +  " " +palabra5 + " " + palabra6;
			  cancion.append("- ").append(frases).append("\n");

		}
		
			cancion.append("\n"); 
	}
		return cancion.toString();

	}

	public String seleccionarCancion() {
	    JFileChooser fileChooser = new JFileChooser();
	    int resultado = fileChooser.showOpenDialog(null);

	    if (resultado == JFileChooser.APPROVE_OPTION) {
	        File archivoSeleccionado = fileChooser.getSelectedFile();
	        if (archivoSeleccionado.isFile()) {
	            try (BufferedReader reader = new BufferedReader(new FileReader(archivoSeleccionado))) {
	                StringBuilder contenidoCancion = new StringBuilder();
	                String linea;
	                while ((linea = reader.readLine()) != null) {
	                    contenidoCancion.append(linea).append("\n");
	                }
	                return contenidoCancion.toString();
	            } catch (IOException e) {
	                e.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Error al leer el archivo.");
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Selecciona un archivo válido.");
	        }
	    } else if (resultado == JFileChooser.CANCEL_OPTION) {
	        System.out.println("Operación cancelada.");
	    }
	    return null; // Devuelve null si no se seleccionó una canción válida.
	}}