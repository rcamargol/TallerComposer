package co.edu.unbosque.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class CancionVista {
    private JFrame frame;
    private JTextArea textoCancion;
    private JButton botonComponer;
    private JButton botonGuardar;
    private JButton botonAbrir;
    private JFileChooser fileChooser;

    public CancionVista() {
        frame = new JFrame("Compositor de Reguetón");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new BorderLayout());

        textoCancion = new JTextArea();
        textoCancion.setEditable(false);
        panel.add(new JScrollPane(textoCancion), BorderLayout.CENTER);

        botonComponer = new JButton("Componer Canción");
        botonGuardar = new JButton("Guardar en Archivo");
        botonAbrir = new JButton("Abrir Archivo");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(botonComponer);
        buttonPanel.add(botonGuardar);
        buttonPanel.add(botonAbrir);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);

        fileChooser = new JFileChooser();
    }

    public void setComponerCancionListener(ActionListener listener) {
        botonComponer.addActionListener(listener);
    }

    public void setGuardarCancionListener(ActionListener listener) {
        botonGuardar.addActionListener(listener);
    }

    public void setAbrirCancionListener(ActionListener listener) {
        botonAbrir.addActionListener(listener);
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }

    public void mostrarCancion(String cancion) {
        textoCancion.setText(cancion);
    }

    public File mostrarDialogoGuardar() {
        int seleccion = fileChooser.showSaveDialog(frame);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    public File mostrarDialogoAbrir() {
        int seleccion = fileChooser.showOpenDialog(frame);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

	public String mostrarCancion() {
		// TODO Auto-generated method stub
		return null;
	}
}