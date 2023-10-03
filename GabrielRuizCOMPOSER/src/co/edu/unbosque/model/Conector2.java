package co.edu.unbosque.model;
import java.util.Random;
public class Conector2 {
	Random rand = new Random();
	String fila2[]={"yo quiero", "yo puedo", "yo vengo a","voy a"};
 	
		public String palabraRandom() {
			int numAleatorio= rand.nextInt(4);
			
			return fila2[numAleatorio];
		}
}
