package co.edu.unbosque.model;
import java.util.Random;
public class Conector6 {
	Random rand = new Random();
 	String fila6[]={"sin anestecia", "sin compromiso" ,"feis to feis", "sin miedo "};
 	
		public String palabraRandom() {
			int numAleatorio= rand.nextInt(4);
			return fila6[numAleatorio];
		}
}
