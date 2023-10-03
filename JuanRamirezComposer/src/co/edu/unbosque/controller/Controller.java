package co.edu.unbosque.controller;
import co.edu.unbosque.model.*;
import co.edu.unbosque.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Canciones modelo;
    private View vista;

    public Controller(Canciones modelo, View vista) {
        this.modelo = modelo;
        this.vista = vista;

        vista.addCrearButtonListener(new CrearButtonListener());
        vista.addGuardarButtonListener(new GuardarButtonListener());
        vista.addSeleccionarButtonListener(new SeleccionarButtonListener());
    }

    public Controller() {
		// TODO Auto-generated constructor stub
	}

	class CrearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int numEstrofas = Integer.parseInt(vista.getEstrofas());
            int numFrases = Integer.parseInt(vista.getFrasesPorEstrofa());

            // Lógica para crear la canción aleatoriamente con los parámetros dados
            String cancion = generarCancionAleatoria(numEstrofas, numFrases);
            vista.mostrarCancion(cancion);
        }
    }

    class GuardarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cancion = vista.mostrarDialogoGuardar();
            if (cancion != null) {
                // Lógica para guardar la canción en el archivo seleccionado
                guardarCancionEnArchivo(cancion, vista.getTextoCancion());
            }
        }
    }

    class SeleccionarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String archivo = vista.mostrarDialogoGuardar();
            if (archivo != null) {
                // Lógica para cargar y mostrar la canción desde el archivo seleccionado
                String cancion = cargarCancionDesdeArchivo(archivo);
                vista.mostrarCancion(cancion);
            }
        }
    }

    // Agrega aquí la lógica para generar, guardar y cargar canciones según tus requerimientos

    private String generarCancionAleatoria(int numEstrofas, int numFrases) {
        // Implementa la generación de la canción aleatoria aquí
        return "Canción generada aleatoriamente.";
    }

    private void guardarCancionEnArchivo(String archivo, String cancion) {
        // Implementa la lógica para guardar la canción en el archivo especificado
    }

    private String cargarCancionDesdeArchivo(String archivo) {
        // Implementa la lógica para cargar una canción desde el archivo especificado
        return "Canción cargada desde archivo.";
    }
}
