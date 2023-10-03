package co.edu.unbosque.model;

import java.util.Random;

public class Cancion {

	private int frases;
	private int estrofas;
	private Random random;

	String sustantivos[] = { "MAMI ", "BEBE ", "PRINCESS ", "MAMI " };
	String verbos[] = { "YO QUIERO ", "YO PUEDO ", "YO VENGO A ", "VOY A " };
	String verboAux[] = { "ENCELDELTE ", "AMALTE ", "LIGAR ", "JUGAR ", };
	String adverbios[] = { "SUAVE ", "LENTO ", "RAPIDO ", " FUERTE " };
	String complementos[] = { "HASTA QUE SALGA EL SOL", "HASTA EL AMANECER ", "TODA LA NOCHE ", "TODO EL DIA" };
	String complementos2[] = { "FEIS TO FEIS ", "SIN ANESTESIA ", "SIN COMPLOMISO ", "SIN MIEDO " };

	public Cancion() {

		random = new Random();

	}

	public String crearFrases() {

		int numeroSustantivos = random.nextInt(4);
		int numeroComplementos = random.nextInt(4);
		int numeroVerbosAuxiliares = random.nextInt(4);
		int numeroVerbos = random.nextInt(4);
		int numeroAdverbios = random.nextInt(4);
		int numeroComplemetos2 = random.nextInt(4);

		String frase = sustantivos[numeroSustantivos] + verbos[numeroVerbos] + verboAux[numeroVerbosAuxiliares]
				+ adverbios[numeroAdverbios] + complementos[numeroComplementos] + complementos2[numeroComplemetos2];

		return frase;

	}

	public String crearVerso() {

		String texto = "";
		String textoAcum = "";

		for (int i = 0; i < frases; i++) {

			texto = crearFrases();
			textoAcum = texto + "\n" + textoAcum;

		}

		return textoAcum;
	}

	public String crearCancion() {

		String cancion = "";
		String verso = "";

		for (int i = 0; i < estrofas; i++) {

			verso = crearVerso();
			cancion = verso + "\n" + cancion;

		}

		return cancion;
	}

	public int getFrases() {
		return frases;
	}

	public void setFrases(int frases) {
		this.frases = frases;
	}

	public int getEstrofas() {
		return estrofas;
	}

	public void setEstrofas(int estrofas) {
		this.estrofas = estrofas;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public String[] getSustantivos() {
		return sustantivos;
	}

	public void setSustantivos(String[] sustantivos) {
		this.sustantivos = sustantivos;
	}

	public String[] getVerbos() {
		return verbos;
	}

	public void setVerbos(String[] verbos) {
		this.verbos = verbos;
	}

	public String[] getVerboAux() {
		return verboAux;
	}

	public void setVerboAux(String[] verboAux) {
		this.verboAux = verboAux;
	}

	public String[] getAdverbios() {
		return adverbios;
	}

	public void setAdverbios(String[] adverbios) {
		this.adverbios = adverbios;
	}

	public String[] getComplementos() {
		return complementos;
	}

	public void setComplementos(String[] complementos) {
		this.complementos = complementos;
	}

	public String[] getComplementos2() {
		return complementos2;
	}

	public void setComplementos2(String[] complementos2) {
		this.complementos2 = complementos2;
	}
}
