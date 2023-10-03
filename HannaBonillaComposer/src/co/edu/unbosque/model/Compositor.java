package co.edu.unbosque.model;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

import co.edu.unbosque.model.persistence.ArchivoSong;
import co.edu.unbosque.model.persistence.PropertiesManager;
import java.util.Set;
import java.util.HashSet;

public class Compositor {
    private ArchivoSong as;
    private PropertiesManager pm;

    public Compositor() {
        as = new ArchivoSong();
        pm = new PropertiesManager();
    }

    private int numStanzas;
    private int numPhraseStanzas;

    public String[] poeticWordsReggae = {
        "Tu susurro,", "Me hace,", "Sentir,", "Euforica,", "Con luminiscencia,",
        "En tu mirada,", "Serenata,", "Al anochecer,", "Poesía en cada suspiro,", "Tuyo,",
        "Lucero,", "De mi cielo,", "Magia,", "En tus manos,", "Brillo,", "En tu esencia,", "Alma,", "y caricia,",
        "Fantasía sin fin,", "Sensualidad,", "En cada verso,", "Representa el,", "Resplandor,",
        "En cada noche,", "Ya que,", "Tu eres,", "Mi sinfonía", "Te quiero,", "Tanto,", " Que morir,", "Yo quisiera,"
    };

    public String generarSong() {
        StringBuilder cancion = new StringBuilder();

        for (int i = 0; i < numStanzas; i++) {
            cancion.append("Estrofa ").append(i + 1).append(":\n");
            for (int j = 0; j < numPhraseStanzas; j++) {
                cancion.append(generarRandomPhrase()).append("\n");
            }
        }

        return cancion.toString();
    }

    public String generarRandomPhrase() {
        int numPalabras = ThreadLocalRandom.current().nextInt(3, 9); 
        StringBuilder frase = new StringBuilder();
        Set<Integer> indicesSeleccionados = new HashSet<>();

        for (int i = 0; i < numPalabras; i++) {
            int randomIndex;
            do {
                randomIndex = ThreadLocalRandom.current().nextInt(0, poeticWordsReggae.length);
            } while (indicesSeleccionados.contains(randomIndex));

            indicesSeleccionados.add(randomIndex);
            frase.append(poeticWordsReggae[randomIndex]);

            if (i < numPalabras - 1) {
                frase.append(" "); 
            }
        }

        return frase.toString().trim(); 
    }

    public void setNumEstrofas(int numEstrofas) {
		this.numStanzas = numEstrofas;
	}

	public void setNumFrasesPorEstrofa(int numFrasesPorEstrofa) {
		this.numPhraseStanzas = numFrasesPorEstrofa;
	}


	public int getNumEstrofas() {
		return numStanzas;
	}

	public int getNumFrasesPorEstrofa() {
		return numPhraseStanzas;
	}

	public void imprimirCancion(String can, File f) {
		as.writeArchivo(can, f);

	}

    public String[] getPoeticWordsReggae() {
		return poeticWordsReggae;
	}

	public void setPoeticWordsReggae(String[] poeticWordsReggae) {
		this.poeticWordsReggae = poeticWordsReggae;
	}

	public String hacerPropiedades() {
        pm.escribirPropiedades(numStanzas, numPhraseStanzas);
        return "Se leyeron estas propiedades:\n" + pm.leerPropiedades();
    }
}


