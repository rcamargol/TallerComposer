package co.edu.unbosque.model;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
public class CancionCreada {

	
	 private String[] columnas1 = {"Mami", "Bebe", "Princess", "Mami"};
	    private String[] columnas2 = {"Yo quiero", "Yo puedo", "Yo vengo a", "Voy a"};
	    private String[] columnas3 = {"Encenderte", "Amarte", "Ligar", "Jugar"};
	    private String[] columnas4 = {"Suave", "Lento", "Rapido", "Fuerte"};
	    private String[] columnas5 = {"Hasta que salga el sol", "Toda la noche", "Hasta el amanecer", "Todo el dia"};
	    private String[] columnas6 = {"Sin anestesia", "Sin compromiso", "Face to Face", "Sin miedo"};

	    public String generarCancion(int numEstrofas, int numFrasesPorEstrofa) {
	        StringBuilder cancion = new StringBuilder();
	        Random random = new Random();

	        for (int i = 0; i < numEstrofas; i++) {
	            cancion.append("Estrofa ").append(i + 1).append(":\n");

	            for (int j = 0; j < numFrasesPorEstrofa; j++) {
	                cancion.append(columnas1[random.nextInt(columnas1.length)]).append(" ");
	                cancion.append(columnas2[random.nextInt(columnas2.length)]).append(" ");
	                cancion.append(columnas3[random.nextInt(columnas3.length)]).append(" ");
	                cancion.append(columnas4[random.nextInt(columnas4.length)]).append(" ");
	                cancion.append(columnas5[random.nextInt(columnas5.length)]).append(" ");
	                cancion.append(columnas6[random.nextInt(columnas6.length)]).append("\n");
	            }

	            cancion.append("\n");
	        }

	        return cancion.toString();
	    }

}
