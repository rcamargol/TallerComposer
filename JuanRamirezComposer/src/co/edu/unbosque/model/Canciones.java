package co.edu.unbosque.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

	public class Canciones {
		    private static final String[] FRASES_REGGAETON = {
		        "Baila, baby, baila",
		        "En la pista, rompemos la tarima",
		        "Con el ritmo, la fiesta se anima",
		        "Hasta el amanecer, nuestra rumba no termina",
		        "Ella es fuego, una diva",
		        "En la discoteca, no se priva",
		        "Los dos juntos, la noche se aviva"
		    };

		    public static String generarCancionAleatoria(int numEstrofas, int numFrases) {
		        Random random = new Random();
		        StringBuilder cancion = new StringBuilder();

		        for (int i = 0; i < numEstrofas; i++) {
		            cancion.append("Estrofa ").append(i + 1).append(":\n");
		            for (int j = 0; j < numFrases; j++) {
		                int indiceFrase = random.nextInt(FRASES_REGGAETON.length);
		                cancion.append(FRASES_REGGAETON[indiceFrase]).append("\n");
		            }
		            cancion.append("\n");
		        }

		        return cancion.toString();
		    }
	public static void guardarCancionEnArchivo(String archivo, String cancion) {
        try (FileWriter writer = new FileWriter(archivo)) {
            writer.write(cancion);
        } catch (IOException ex) {
            ex.printStackTrace();// Manejar excepciones de escritura de archivo
        }
   
public static String cargarCancionDesdeArchivo(String archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            
            StringBuilder can;
StringBuilder cancion = new StringBuilder();
            String linea;
            
           
while ((linea = reader.readLine()) != null) {
                cancion.append(linea).append("\n");
            }
            return cancion.toString();
        } 
catch (IOException ex) {
            ex.printStackTrace(); // Manejar excepciones de lectura de archivo
            return "Error al cargar el archivo";
        }
    }
}
