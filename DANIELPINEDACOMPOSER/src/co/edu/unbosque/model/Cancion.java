package co.edu.unbosque.model;
import java.io.*;
import java.util.Properties;
import java.util.Random;

public class Cancion {
	private String cancionGenerada;
	
	public void cargarConfiguracion() {
        Properties prop = new Properties();
        try (FileInputStream input = new FileInputStream("config.properties")) {
            prop.load(input);
            int numEstrofas = Integer.parseInt(prop.getProperty("numEstrofas"));
            int numFrasesPorEstrofa = Integer.parseInt(prop.getProperty("numFrasesPorEstrofa"));
            generarCancion(numEstrofas, numFrasesPorEstrofa);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	String[] Frases1 = { "mami","bebé","plincess","mami",};
	String[] Frases2 = {"yo quiero","yo puedo","yo vengo a", "voy a"};
	String[] Frases3 = { "encendelte", "amalte","ligal","jugal"};
	String[] Frases4 = {"suave","lento","rápido","fuerte"};
	String[] Frases5 = {"hasta que salga el sol", "toda la noche", "hasta el amanecer", "todo el día"};
	String[] Frases6 = {"sin anestesia", "sin compromiso", "feis to feis", "sin miedo"};
	
	public void generarCancion(int numEstrofas, int numFrasesPorEstrofa) {
	    StringBuilder cancion = new StringBuilder();
	    Random random = new Random();

	    for (int i = 1; i <= numEstrofas; i++) {
	        cancion.append("Estrofa ").append(i).append(":\n");
	        for (int j = 1; j <= numFrasesPorEstrofa; j++) {
	            cancion.append("Frase ").append(j).append(": ");
	            String frase1 = Frases1[random.nextInt(Frases1.length)];
	            String frase2 = Frases2[random.nextInt(Frases2.length)];
	            String frase3 = Frases3[random.nextInt(Frases3.length)];
	            String frase4 = Frases4[random.nextInt(Frases4.length)];
	            String frase5 = Frases5[random.nextInt(Frases5.length)];
	            String frase6 = Frases6[random.nextInt(Frases6.length)];
	            String fraseCompleta = frase1 + " " + frase2 + " " + frase3 + " " + frase4+ " " + frase5+ " " + frase6;
	            cancion.append(fraseCompleta).append("\n");
	        }
	        cancion.append("\n");
	    }

	    cancionGenerada = cancion.toString();
	}
        public String getCancionGenerada() {
            return cancionGenerada;
        }
    }

