package co.edu.unbosque.model;
import java.io.*;
import java.util.Properties;
import java.util.Random;

public class CancionReggaeton {
	private String cancionGenerada;
	
	public void propiedades() {
        Properties prop = new Properties();
        try (FileInputStream input = new FileInputStream("config.properties")) {
            prop.load(input);
            int numEstrofas = Integer.parseInt(prop.getProperty("numEstrofas"));
            int numFrasesPorEstrofa = Integer.parseInt(prop.getProperty("numFrasesPorEstrofa"));
            hacerCancion(numEstrofas, numFrasesPorEstrofa);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	String[] parte1 = { "mami","bebé","plincess","mami",};
	String[] parte2 = {"yo quiero","yo puedo","yo vengo a", "voy a"};
	String[] parte3 = { "encendelte", "amalte","ligal","jugal"};
	String[] parte4 = {"suave","lento","rápido","fuerte"};
	String[] parte5 = {"hasta que salga el sol", "toda la noche", "hasta el amanecer", "todo el día"};
	String[] parte6 = {"sin anestesia", "sin compromiso", "feis to feis", "sin miedo"};
	
	public void hacerCancion(int numEstrofas, int numFrasesPorEstrofa) {
	    StringBuilder cancion = new StringBuilder();
	    Random random = new Random();

	    for (int i = 1; i <= numEstrofas; i++) {
	        cancion.append("Estrofa ").append(i).append(":\n");
	        for (int j = 1; j <= numFrasesPorEstrofa; j++) {
	            cancion.append("Frase ").append(j).append(": ");
	            String Parte1 = parte1[random.nextInt(parte1.length)];
	            String Parte2 = parte2[random.nextInt(parte2.length)];
	            String Parte3 = parte3[random.nextInt(parte3.length)];
	            String Parte4 = parte4[random.nextInt(parte4.length)];
	            String Parte5 = parte5[random.nextInt(parte5.length)];
	            String Parte6 = parte6[random.nextInt(parte6.length)];
	            String cancionCompleta = Parte1 + " " + Parte2 + " " + Parte3 + " " + Parte4+ " " + Parte5+ " " + Parte6;
	            cancion.append(cancionCompleta).append("\n");
	        }
	        cancion.append("\n");
	    }

	    cancionGenerada = cancion.toString();
	}
        public String getCancionGenerada() {
            return cancionGenerada;
        }
    }


