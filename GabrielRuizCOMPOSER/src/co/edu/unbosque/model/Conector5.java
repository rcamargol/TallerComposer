package co.edu.unbosque.model;
import java.util.Random;
public class Conector5 {
	Random rand = new Random();
	String fila5[]={"hasta que salga el sol", "Toda la noche", "hasta el amanecer", "todo el dia"};
	
 	
		public String palabraRandom() {
			int numAleatorio= rand.nextInt(4);
			
			return fila5[numAleatorio];
		}

}

