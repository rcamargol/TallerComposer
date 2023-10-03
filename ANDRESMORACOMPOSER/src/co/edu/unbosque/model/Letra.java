package co.edu.unbosque.model;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

import co.edu.unbosque.model.persistence.ArchivoCancion;
import co.edu.unbosque.model.persistence.Propiedades;

public class Letra {
	private ArchivoCancion song;
	private Propiedades prop;

	public Letra() {
		song = new ArchivoCancion();
		prop = new Propiedades();
	}

	private int nest;
	private int nfra;
	public String[] opciones = { "MAMI", "BEBE", "PRINCESS", "MI AMOR", "YO QUIERO","YO PUEDO", "YO VENGO A", "VOY A", "ENCENDERTE", "AMARTE", "LIGAR", "JUGAR", "SUAVE","LENTO", "RAPIDO", "FUERTE", "HASTA QUE SALGA EL SOL", "TODA LA NOCHE", "HASTA EL AMANECER", "TODO EL DIA", "SIN ANESTESIA","SIN COMPROMISO", "FEIS TO FEIS", "SIN MIEDO"
	};

	public void setNumEstrofas(int numEstrofas) {
		this.nest = numEstrofas;
	}

	public void setNumFrasesPorEstrofa(int numFrasesPorEstrofa) {
		this.nfra = numFrasesPorEstrofa;
	}

	public String generarCancion() {
		String cancion = "";

		for (int i = 0; i < nest; i++) {
			for (int j = 0; j < nfra; j++) {
				cancion += generarFraseAleatoria() + " ";
			}
			cancion += "\n"; // newline para pasar de una estrofa a otra
		}

		return cancion;
	}

	
	
	public String generarFraseAleatoria() {
		int numPalabras = ThreadLocalRandom.current().nextInt(4, 8);
		String frase = "";

		for (int i = 0; i < numPalabras; i++) {
			int randomIndex = ThreadLocalRandom.current().nextInt(0, opciones.length);
			frase += opciones[randomIndex] + " ";
		}

		return frase.trim() + "\n";
	}

	public String[] getPalabras() {
		return opciones;
	}

	public void setPalabras(String[] palabras) {
		this.opciones = palabras;
	}

	public int getNumEstrofas() {
		return nest;
	}

	public int getNumFrasesPorEstrofa() {
		return nfra;
	}
	
	

	public void imprimirCancion(String can, File f) {
		song.escribirArchivo(can, f);

	}

	public String hacerPropiedades() {
		prop.escribirPropiedades(nest, nfra);
		return "Se leyeron estas propiedades: " + "\n" + prop.leerPropiedades();
	}
}