package co.edu.unbosque.model;

import java.util.concurrent.ThreadLocalRandom;

public class Canciones {
	
	public String crearCancion() {
		String [] Palabras= {"MAMI ", "BEBE ", "PRINCESS " , "AMOR "};
		String [] Palabras2 = {"YO QUIERO ", "YO PUEDO ", "YO VENGO A ", "VOY A "};
		String [] Palabras3 = {"ENCENDERTE ", "AMARTE ", "LIGAR ", "JUGAR "};
		String [] Palabras4 = {"SUAVE ", "RAPIDO ", "LENTO ", "FUERTE "};
		String [] Palabras5 = {"HASTA QUE SALGA EL SOL ", "TODA LA NOCHE ", "HASTA EL AMANECER ", "TODO EL DIA "};
		String [] Palabras6 = {"SIN ANESTESIA ", "SIN COMPROMISO ", "FEIS TO FEIS ", "SIN MIEDO "};
		
		int indiceAleatoriof1 = numeroAleatorio(0, Palabras.length-1);
		int indiceAleatoriof2 = numeroAleatorio(0, Palabras2.length-1);
		int indiceAleatoriof3 = numeroAleatorio(0, Palabras3.length-1);
		int indiceAleatoriof4 = numeroAleatorio(0, Palabras4.length-1);
		int indiceAleatoriof5 = numeroAleatorio(0, Palabras5.length-1);
		int indiceAleatoriof6 = numeroAleatorio(0, Palabras6.length-1);
		
		String fraseAl1 = Palabras[indiceAleatoriof1];
		String fraseAl2 = Palabras2[indiceAleatoriof2];
		String fraseAl3 = Palabras3[indiceAleatoriof3];
		String fraseAl4 = Palabras4[indiceAleatoriof4];
		String fraseAl5 = Palabras5[indiceAleatoriof5];
		String fraseAl6 = Palabras6[indiceAleatoriof6];
		
		String fraseAleatoriaCompleta = fraseAl1 + fraseAl2 + fraseAl3 + fraseAl4 + fraseAl5 + fraseAl6;
		
		return fraseAleatoriaCompleta;
	}
	
	public int numeroAleatorio(int min, int max) {
		// TODO Auto-generated method stub
		return ThreadLocalRandom.current().nextInt(min, max + 1);
		
	}
	
	
}
