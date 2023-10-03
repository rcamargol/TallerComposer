package co.edu.unbosque.controller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import co.edu.unbosque.model.Cancion;
import co.edu.unbosque.view.View;

public class Controller {
	private Cancion model;
    private View view;

    public Controller(Cancion model, View view) {
        this.model = model;
        this.view = view;
    }

    public void cargarConfiguracionYGenerarCancion() {
        model.cargarConfiguracion();
    }

    public void generarCancion(int numEstrofas, int numFrasesPorEstrofa) {
        model.generarCancion(numEstrofas, numFrasesPorEstrofa);
    }

    public String getCancionGenerada() {
        return model.getCancionGenerada();
    }

    public void mostrarCancionGuardada() {
        String rutaArchivo = view.mostrarDialogoSeleccionarCancion();
        if (rutaArchivo != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
                StringBuilder contenido = new StringBuilder();
                String linea;
                while ((linea = reader.readLine()) != null) {
                    contenido.append(linea).append("\n");
                }
                view.mostrarMensaje("Canción Seleccionada:\n" + contenido.toString());
            } catch (IOException e) {
                e.printStackTrace();
                view.mostrarMensaje("Error al leer la canción seleccionada.");
            }
        }
    }
}

