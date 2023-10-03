package co.edu.unbosque.model;
import java.util.Random;
public class Conector4 {
	
		Random rand = new Random();
		String fila4[]={"suave", "lento", "rapido" ,"fuerte"};
	 	
			public String palabraRandom() {
				int numAleatorio= rand.nextInt(4);
				
				return fila4[numAleatorio];
	}
}

