package co.edu.unbosque.model;
import java.util.Random;
public class Conector1 {
		Random rand = new Random();
		String fila1[]= {"mami","bebe","princess","mor"};
	 	
			public String palabraRandom() {
				int numAleatorio= rand.nextInt(4);
				
				return fila1[numAleatorio];
		
	}
	
}
