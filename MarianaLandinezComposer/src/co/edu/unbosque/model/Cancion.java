package co.edu.unbosque.model;

import java.util.Random;

public class Cancion {

	private int numeroEstrofas, numeroFrases;

	private Random random;

	private String[] sustantivo = { "Mami ", "Princess ", "Bebe ", "Mami ", "Gyal ", "Nena ", "Mujer ", "Preciosa " };

	private String[] verboAuxiliar = { "yo quiero ", "yo puedo ", "me muero por ", "yo vengo a ", "no paro de ",
			"voy a ", "tengo el deseo de ", "me vuelvo loco por " };
	private String[] verbo = { "comerte ", "encenderte ", "tocarte ", "amarte ", "ligar ", "jugar ", "acariciarte ",
			"cuidarte " };
	private String[] adverbio = { "suave ", "lento ", "duro ", "con calma ", "fuerte ", "sin presion ",
			"como tu quieras ", "sin miedo " };
	private String[] complemento = { "hasta el amanecer ", "diario ", "hasta el anochecer ", "sin anestesia",
			"face to face ", "todo el dia", "hasta quedar sin aliento ", "hasta perder la compostura " };

	public Cancion() {

		random = new Random();
		// TODO Auto-generated constructor stub

	}

	public String crearFrase() {

		int numeroSus = random.nextInt(7);
		int numeroVerbAux = random.nextInt(7);
		int numeroVerb = random.nextInt(7);
		int numeroAdv = random.nextInt(7);
		int numeroCompl = random.nextInt(7);

		String frase = sustantivo[numeroSus] + verboAuxiliar[numeroVerbAux] + verbo[numeroVerb] + adverbio[numeroAdv]
				+ complemento[numeroCompl];

		return frase;
	}

	public String crearVerso() {

		String texto = "";
		String textoFinal = "";

		for (int j = 0; j < numeroFrases; j++) {

			texto = crearFrase();
			textoFinal = texto + "\n" + textoFinal;
		}
		return textoFinal;

	}

	public String crearCancion() {

		String cancion = "";
		String verso = "";

		for (int i = 0; i < numeroEstrofas; i++) {

			verso = crearVerso();
			cancion = verso + "\n" + cancion;

		}
		return cancion;
	}

	public int getNumeroEstrofas() {
		return numeroEstrofas;
	}

	public void setNumeroEstrofas(int numeroEstrofas) {
		this.numeroEstrofas = numeroEstrofas;
	}

	public int getNumeroFrases() {
		return numeroFrases;
	}

	public void setNumeroFrases(int numeroFrases) {
		this.numeroFrases = numeroFrases;
	}

}
