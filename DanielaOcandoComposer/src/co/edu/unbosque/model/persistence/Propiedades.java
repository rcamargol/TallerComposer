package co.edu.unbosque.model.persistence;
import co.edu.unbosque.controller.*;
import java.io.*;
import java.util.Properties;

public class Propiedades {

	
	
	 private Properties properties;
	    private String archivo = "C\\data\\archivo.properties";

	    public void inicializar() {
	        properties = new Properties();
	        cargarPropiedades();
	    }

	    public void guardarConfiguracion(String Estrofa, String Frase) {
	        properties.setProperty("dato1", Estrofa);
	        properties.setProperty("dato2", Frase);
	        guardarPropiedades();
	    }

	    public String obtenerDato1() {
	        return properties.getProperty("Estrofa", "");
	    }

	    public String obtenerDato2() {
	        return properties.getProperty("Frase", "");
	    }

	    private void cargarPropiedades() {
	        try (InputStream inputStream = new FileInputStream(archivo)) {
	            properties.load(inputStream);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private void guardarPropiedades() {
	        try (OutputStream outputStream = new FileOutputStream(archivo)) {
	            properties.store(outputStream, "Configuración de Datos");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
}}