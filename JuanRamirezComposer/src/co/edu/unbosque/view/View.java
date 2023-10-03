package co.edu.unbosque.view;	
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class View {
    private JFrame frame;

    public View() {
        frame = new JFrame("Canciones de Reguetón");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(null);

        JButton crearButton = new JButton("Crear Canción");
        crearButton.setBounds(50, 50, 120, 30);

        JButton guardarButton = new JButton("Guardar Canción");
        guardarButton.setBounds(180, 50, 140, 30);

        JButton seleccionarButton = new JButton("Seleccionar Canción");
        seleccionarButton.setBounds(50, 100, 180, 30);

        frame.add(crearButton);
        frame.add(guardarButton);
        frame.add(seleccionarButton);

        frame.setVisible(true);
    }

    public void addCrearButtonListener(ActionListener listener) {
        // Agrega el ActionListener al botón de "Crear Canción"
        // Puedes personalizar esta lógica según sea necesario
    }

    public void addGuardarButtonListener(ActionListener listener) {
        // Agrega el ActionListener al botón de "Guardar Canción"
        // Puedes personalizar esta lógica según sea necesario
    }

    public void addSeleccionarButtonListener(ActionListener listener) {
        // Agrega el ActionListener al botón de "Seleccionar Canción"
        // Puedes personalizar esta lógica según sea necesario
    }

    public String getEstrofas() {
        // Implementa la lógica para obtener el número de estrofas ingresado por el usuario
        // Debes devolver el valor como una cadena (String)
        return "3"; // Ejemplo: retorna "3"
    }

    public String getFrasesPorEstrofa() {
        // Implementa la lógica para obtener el número de frases por estrofa ingresado por el usuario
        // Debes devolver el valor como una cadena (String)
        return "4"; // Ejemplo: retorna "4"
    }

    public String mostrarDialogoGuardar() {
        // Implementa la lógica para mostrar un diálogo de guardar y devolver el nombre del archivo seleccionado
        // Debes devolver el nombre del archivo como una cadena (String)
        return "cancion.txt"; // Ejemplo: retorna "cancion.txt"
    }

    public String getTextoCancion() {
        // Implementa la lógica para obtener el texto de la canción ingresado por el usuario
        // Debes devolver el texto como una cadena (String)
        return "Esta es una canción de reguetón."; // Ejemplo: retorna el texto de la canción
    }

    public void mostrarCancion(String cancion) {
        // Implementa la lógica para mostrar la canción generada o cargada en la interfaz gráfica
        // Puedes personalizar esta lógica según sea necesario
        JOptionPane.showMessageDialog(frame, cancion, "Canción Generada", JOptionPane.INFORMATION_MESSAGE);
    }
}

