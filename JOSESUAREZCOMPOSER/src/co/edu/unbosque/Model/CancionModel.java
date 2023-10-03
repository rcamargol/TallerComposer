package co.edu.unbosque.Model;

import java.io.*;
import java.util.Random;

public class CancionModel {
    private String[][] grupos;
    private int numEstrofas;
    private int numFrasesPorEstrofa;

    public CancionModel() {
        grupos = new String[6][4];
        grupos[0] = new String[]{"Mami", "Bebe", "Bellaka", "Mor"};
        grupos[1] = new String[]{"Yo quiero", "Yo puedo", "Yo vengo", "Te voy a"};
        grupos[2] = new String[]{"Encenderte", "Amarte", "Ligar", "Jugar"};
        grupos[3] = new String[]{"Suave", "Lento", "Rapido", "Fuerte"};
        grupos[4] = new String[]{"Hasta que salga el sol", "Toda la noche", "Hasta el amanecer", "Todo el dia"};
        grupos[5] = new String[]{"Sin anestesia", "Sin compromiso", "Feis to feis", "Sin miedo"};
    }
    public void setNumeroEstrofas(int numEstrofas) {
        this.numEstrofas = numEstrofas;
    }

    public void setNumeroFrasesPorEstrofa(int numFrasesPorEstrofa) {
        this.numFrasesPorEstrofa = numFrasesPorEstrofa;
    }

    public String componerCancion() {
        StringBuilder cancion = new StringBuilder();

        for (int i = 0; i < numEstrofas; i++) {
            for (int j = 0; j < numFrasesPorEstrofa; j++) {
                int grupoIndex = new Random().nextInt(grupos.length);
                int fraseIndex = new Random().nextInt(grupos[grupoIndex].length);
                String frase = grupos[grupoIndex][fraseIndex];

                cancion.append(frase).append(" ");
            }
            cancion.append("\n");
        }

        return cancion.toString();
    }

    public void guardarCancionEnArchivo(String nombreArchivo, String contenido) throws IOException {
        try (PrintWriter writer = new PrintWriter(nombreArchivo)) {
            writer.write(contenido);
        }
    }

    public String cargarCancionDesdeArchivo(String nombreArchivo) throws IOException {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        }
        return contenido.toString();
    }
}
