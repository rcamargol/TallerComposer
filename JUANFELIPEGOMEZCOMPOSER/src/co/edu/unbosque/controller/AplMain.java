package co.edu.unbosque.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.CancionReggaeton;
import co.edu.unbosque.view.View;

public class AplMain {

	public static void main(String[] args) {
        CancionReggaeton model = new CancionReggaeton();
        View view = new View();
        Controller controller = new Controller(model, view);

        controller.cargarConfiguracionYGenerarCancion();

        int numEstrofas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de estrofas:"));
        int numFrasesPorEstrofa = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de frases por estrofa:"));

        controller.generarCancion(numEstrofas, numFrasesPorEstrofa);

        String cancionGenerada = controller.getCancionGenerada();
        view.mostrarMensaje("Canción Generada:\n" + cancionGenerada);

        String rutaArchivo = view.mostrarDialogoGuardarCancion();
        if (rutaArchivo != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
                writer.write(cancionGenerada);
                view.mostrarMensaje("Canción guardada en: " + rutaArchivo);
            } catch (IOException e) {
                e.printStackTrace();
                view.mostrarMensaje("Error al guardar la canción.");
            }
        }

        controller.mostrarCancionGuardada();
    }
	}

