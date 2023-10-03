package co.edu.unbsoque.model;

import java.util.Random;

public class Cancion {
	
	private int frases;
	private int estrofas;
	private Random random;

	
	String sustantivos[] = { "Mami ", "Bebe ", "Nena ", "Princess ", "Reina ", "Preciosa ", "Baby "};
	String verbos[] = { "yo quiero ", "yo puedo ", "yo vengo a ", "voy a ", "tengo ganas de ", "me muero por ", "yo deseo "};
	String verboAux[] = {"comerte ", " tocarte ", "encenderte ", "amarte ", "jugar ", " acariciarte ", " quererte "};
	String adverbios[] = {"suave ", "lento ", "duro ", " fuerte ", "sin parar ", "rapido ", "con calma "};
	String complementos[] = {"hasta el amanecer ", "toda la noche ", "face to face ", "hasta quedar sin aliento ", "sin control ",  "hasta quedar sin aliento", " hasta no poder mas"};
	
	public Cancion() {

		random = new Random();
		
	}

	public String crearFrases() {
		
		int numeroSustantivos =  random.nextInt(6);
		int numeroComplementos =  random.nextInt(6);
		int numeroVerbosAuxiliares =  random.nextInt(6);
		int numeroVerbos =  random.nextInt(6);
		int numeroAdverbios =  random.nextInt(6);
		
		String frase = sustantivos[numeroSustantivos] + verbos[numeroVerbos]+ verboAux[numeroVerbosAuxiliares]+ adverbios[numeroAdverbios]+ complementos[numeroComplementos] ;
		
		
		return frase;
		
	}
	
	public String crearVerso() {
		
		String texto = "";
		String textoAcum = "";
		
		
		for (int i = 0; i < frases; i++) {
			
			texto = crearFrases();
			textoAcum =  texto + "\n"+  textoAcum ;
			
		}
		
		return textoAcum;
	}
	
	public String crearCancion() {
		
		
		String cancion =  "";
		String verso = "";
		
		for (int i = 0; i < estrofas; i++) {
			
			verso = crearVerso();
			cancion = verso + "\n"+  cancion;
			
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

	
	
}
