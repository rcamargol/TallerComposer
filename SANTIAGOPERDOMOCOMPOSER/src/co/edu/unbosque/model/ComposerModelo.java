package co.edu.unbosque.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ComposerModelo {
    private String[] frasesReggaeton;
    private int numeroEstrofas;
    private int numeroFrasesPorEstrofa;

    public ComposerModelo() {
        cargarFrases();
    }

    public void cargarFrases() {
        frasesReggaeton = new String[] {
            "Mami, yo quiero encenderte",
            "Bebé, yo puedo amarte",
            "Princess, yo vengo a ligar",
            "Mami, voy a jugar",
            "Suave hasta que salga el sol, sin anestesia",
            "Lento, toda la noche sin compromiso",
            "Rápido, hasta el amanecer, feis to feis",
            "Fuerte, todo el día, sin miedo"
        };
    }

    public void setNumeroEstrofas(int numeroEstrofas) {
        this.numeroEstrofas = numeroEstrofas;
    }

    public void setNumeroFrasesPorEstrofa(int numeroFrasesPorEstrofa) {
        this.numeroFrasesPorEstrofa = numeroFrasesPorEstrofa;
    }

    public String componerCancion() {
        StringBuilder cancion = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < numeroEstrofas; i++) {
            cancion.append("Estrofa ").append(i + 1).append(":\n");

            for (int j = 0; j < numeroFrasesPorEstrofa; j++) {
                int randIndex = rand.nextInt(frasesReggaeton.length);
                cancion.append(frasesReggaeton[randIndex]).append("\n");
            }
            cancion.append("\n");
        }
        return cancion.toString();
    }

    public void guardarCancionEnCarpeta() {
        String rutaCompleta = "C:\\data\\Canción.txt"; 

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaCompleta))) {
            String cancion = componerCancion();
            writer.write(cancion);
            System.out.println("Canción guardada en " + rutaCompleta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

