package Co.edu.unbosque.Model;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

import Co.edu.unbosque.Model.Persistence.ArchivoCancion;
import Co.edu.unbosque.Model.Persistence.Propiedades;

public class Generador {
	private ArchivoCancion ac;
	private Propiedades p;

	public Generador() {
		ac = new ArchivoCancion();
		p = new Propiedades();
	}

	private int numEstrofas;
	private int numFrasesPorEstrofa;
	public String[] palabras = { "Mami", " quiero", "Encenderte", "Suave", " Hasta que salga el sol",
			" Sin  anestesia ", " Baby ", " puedo", "Amarte", "Lento", "Toda la noche", "Sin compromiso", "Princess",
			"  vengo A", "Ligar", "Rapido ", "Hasta el amanecer", "Feis to Feis", " Bebe ", " Voy a ", "Jugar ",
			"Fuerte", "Todo el dia", "Sin miedo", "En el Motel", "Lo panty", "Tu,", "  Yo, ", " Eres,", " Mi, ",
			" Durante  ", " Disco ", " Hacia "

	};

	public String generarCancion() {
		String cancion = "";

		for (int i = 0; i < numEstrofas; i++) {
			cancion += "Estrofa " + (i + 1) + ":\n";
			for (int j = 0; j < numFrasesPorEstrofa; j++) {
				cancion += generarFraseAleatoria() + " ";
			}
			cancion += "\n"; 
		}

		return cancion;
	}

	public String generarFraseAleatoria() {
		int numPalabras = ThreadLocalRandom.current().nextInt(3, 6); 
		String frase = "";

		for (int i = 0; i < numPalabras; i++) {
			int randomIndex = ThreadLocalRandom.current().nextInt(0, palabras.length);
			frase += palabras[randomIndex] + " "; 
		}

		return frase.trim() + "\n"; 
	}

	public void setNumEstrofas(int numEstrofas) {
		this.numEstrofas = numEstrofas;
	}

	public void setNumFrasesPorEstrofa(int numFrasesPorEstrofa) {
		this.numFrasesPorEstrofa = numFrasesPorEstrofa;
	}

	public String[] getPalabras() {
		return palabras;
	}

	public void setPalabras(String[] palabras) {
		this.palabras = palabras;
	}

	public int getNumEstrofas() {
		return numEstrofas;
	}

	public int getNumFrasesPorEstrofa() {
		return numFrasesPorEstrofa;
	}

	public void imprimirCancion(String can, File f) {
		ac.escribirArchivo(can, f);

	}

	public String hacerPropiedades() {
		p.escribirPropiedades(numEstrofas, numFrasesPorEstrofa);
		return "Se leyeron estas propiedas: " + "\n" + p.leerPropiedades();
	}
}
