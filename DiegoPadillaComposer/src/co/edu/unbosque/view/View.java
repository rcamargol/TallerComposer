package co.edu.unbosque.view;

import javax.swing.*;
import co.edu.unbosque.model.CancionCreada;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Properties;

public class View {
	  
	
	 private static Properties properties = new Properties();
	   public static String cancionGenerada;

	           
	   public static void main(String[] args) {

	    
	        JFrame frame = new JFrame(" Canciones de Reguetón");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(400, 200);

	        JButton definirParametrosButton = new JButton("Definir Parámetros");
	        JButton generarCancionButton = new JButton("Generar y Guardar Canción");
	        JButton seleccionarCancionButton = new JButton("Seleccionar y Mostrar Canción");

	        definirParametrosButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                int numEstrofas = Integer.parseInt(JOptionPane.showInputDialog("Cuantas estrofas quieres:"));
	                int numFrasesPorEstrofa = Integer.parseInt(JOptionPane.showInputDialog("Número de frases por estrofa que quieres :"));

	                properties.setProperty("numEstrofas", String.valueOf(numEstrofas));
	                properties.setProperty("numFrasesPorEstrofa", String.valueOf(numFrasesPorEstrofa));

	                try (OutputStream output = new FileOutputStream("config.properties")) {
	                    properties.store(output, null);
	                    JOptionPane.showMessageDialog(null, "Parámetros definidos .");
	                } catch (IOException ex) {
	                    ex.printStackTrace();
	                    JOptionPane.showMessageDialog(null, "Error al guardar los parámetros.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        });

	        generarCancionButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                if (properties.isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "Debes definir los parámetros primero.");
	                    return;
	                }

	                int numEstrofas = Integer.parseInt(properties.getProperty("numEstrofas"));
	                int numFrasesPorEstrofa = Integer.parseInt(properties.getProperty("numFrasesPorEstrofa"));

	                CancionCreada cancionCreada = new CancionCreada();
	                cancionGenerada = cancionCreada.generarCancion(numEstrofas, numFrasesPorEstrofa);

	                guardarCancionEnArchivo(cancionGenerada);
	            }
	        });

	        seleccionarCancionButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String contenido = seleccionarArchivoYLeerContenido();
	                JOptionPane.showMessageDialog(null, "Contenido del archivo:\n" + contenido);
	            }
	        });

	        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
	        frame.add(definirParametrosButton);
	        frame.add(generarCancionButton);
	        frame.add(seleccionarCancionButton);
	        frame.setVisible(true);
	    }

	    private static void guardarCancionEnArchivo(String cancion) {
	        JFileChooser fileChooser = new JFileChooser();
	        int result = fileChooser.showSaveDialog(null);

	        if (result == JFileChooser.APPROVE_OPTION) {
	            File file = fileChooser.getSelectedFile();
	            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
	                writer.write(cancion);
	                JOptionPane.showMessageDialog(null, "Canción generada y guardada correctamente en " + file.getAbsolutePath());
	            } catch (IOException ex) {
	                ex.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Error al guardar la canción.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    }

	    private static String seleccionarArchivoYLeerContenido() {
	        JFileChooser fileChooser = new JFileChooser();
	        int result = fileChooser.showOpenDialog(null);

	        if (result == JFileChooser.APPROVE_OPTION) {
	            File selectedFile = fileChooser.getSelectedFile();
	            return leerContenido(selectedFile);
	        }
	        return "No se seleccionó ningún archivo.";
	    }

	    private static String leerContenido(File file) {
	        StringBuilder content = new StringBuilder();
	        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                content.append(line).append("\n");
	            }
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	        return content.toString();
	    }

	    public static String getCancionGenerada() {
	        return cancionGenerada;
	    
	    }

}
