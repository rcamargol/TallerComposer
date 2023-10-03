package co.edu.unbosque.controller;

import co.edu.unbosque.model.ComposerModelo;
import co.edu.unbosque.view.ComposerView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Controller {
    private ComposerModelo modelo;
    private ComposerView vista;
    private Properties properties;

    public Controller() {
        modelo = new ComposerModelo();
        vista = new ComposerView();
        properties = new Properties();

        
		File configFile = new File("config.properties");
		if (!configFile.exists()) {
		    properties.setProperty("numero_estrofas", "3");
		    properties.setProperty("numero_frases_por_estrofa", "2");
		    try (OutputStream output = new FileOutputStream("config.properties")) {
		        properties.store(output, null);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}

		try (InputStream input = new FileInputStream("config.properties")) {
		    properties.load(input);
		    int numeroEstrofas = Integer.parseInt(properties.getProperty("numero_estrofas"));
		    int numeroFrasesPorEstrofa = Integer.parseInt(properties.getProperty("numero_frases_por_estrofa"));
		    modelo.setNumeroEstrofas(numeroEstrofas);
		    modelo.setNumeroFrasesPorEstrofa(numeroFrasesPorEstrofa);
		} catch (IOException e) {
		    e.printStackTrace();
		}
    }

    public void definirParametros() {
        int numeroEstrofas = vista.pedirNumeroEstrofas();
        int numeroFrasesPorEstrofa = vista.pedirNumeroFrasesPorEstrofa();
        modelo.setNumeroEstrofas(numeroEstrofas);
        modelo.setNumeroFrasesPorEstrofa(numeroFrasesPorEstrofa);

        properties.setProperty("numero_estrofas", String.valueOf(numeroEstrofas));
        properties.setProperty("numero_frases_por_estrofa", String.valueOf(numeroFrasesPorEstrofa));
        try (OutputStream output = new FileOutputStream("config.properties")) {
            properties.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crearCancionYGuardar() {
        modelo.guardarCancionEnCarpeta(); 
    }
}
