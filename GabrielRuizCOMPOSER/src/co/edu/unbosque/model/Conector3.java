package co.edu.unbosque.model;
import java.util.Random;
public class Conector3 {
	Random rand = new Random();
	String fila3[]={"jugar" ,"ligar", "amarte", "encenderte"};
 	
		public String palabraRandom() {
			int numAleatorio= rand.nextInt(4);
			
			return fila3[numAleatorio];
		}
}
