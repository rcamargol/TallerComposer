package co.edu.unbosque.model;

import java.util.Random;

import co.edu.unbosque.model.persistence.EjeFile;
import co.edu.unbosque.model.persistence.Propiedades;

public class Regueton{
	
	private EjeFile archivo;
	private Random r;
	private String[] parte1Verso = {"mami", "bebe", "plincess", "mami"};
	private String[] parte2Verso = {"yo quielo", "yo puedo", "yo vengo", "voy a"};
	private String[] parte3Verso = {"encendelte", "amalte", "ligal", "jugal"};
	private String[] parte4Verso = {"suave", "lento", "rapido", "fuelte"};
	private String[] parte5Verso = {"hasta que salga el sol", "toda la noche", "hasta el amanecel", "todo el dia"};
	private String[] parte6Verso = {"sin anestesia", "sin complomiso", "feis to feis", "sin miedo"};
	private String cancionGenerada;
	
	public Regueton() {
		archivo = new EjeFile();
		r = new Random();
	}
	
	public void escribirCancion(int numero_de_estrofas, int numero_de_versos, String nombre_del_archivo) {
	    StringBuilder cancionGenerada = new StringBuilder(); 

	    for (int i = 0; i < numero_de_estrofas; i++) {
	        cancionGenerada.append("Estrofa #").append(i + 1).append("\n");
	        for (int j = 0; j < numero_de_versos; j++) {
	            cancionGenerada.append(parte1Verso[r.nextInt(0, 4)]).append(" ");
	            cancionGenerada.append(parte2Verso[r.nextInt(0, 4)]).append(" ");
	            cancionGenerada.append(parte3Verso[r.nextInt(0, 4)]).append(" ");
	            cancionGenerada.append(parte4Verso[r.nextInt(0, 4)]).append(" ");
	            cancionGenerada.append(parte5Verso[r.nextInt(0, 4)]).append(" ");
	            cancionGenerada.append(parte6Verso[r.nextInt(0, 4)]).append("\n\n");
	        }
	    }
	    this.cancionGenerada = cancionGenerada.toString();

	    String archivoAEscribir = "c:\\\\data\\\\" + nombre_del_archivo + ".txt";
	    archivo.escribirArchivo(archivoAEscribir, this.cancionGenerada);
	}
	public String gestionarPropiedades(int numero_de_estrofas, int numero_de_versos, String nombre_del_archivo) {
		Propiedades prop = new Propiedades();
		prop.escribirPropiedades(numero_de_estrofas, numero_de_versos, nombre_del_archivo);
		return "Propiedades del archivo: \n" + prop.leerPropiedades();
	}
	
	
	public EjeFile getArchivo() {
		return archivo;
	}

	public void setArchivo(EjeFile archivo) {
		this.archivo = archivo;
	}

	public Random getR() {
		return r;
	}

	public void setR(Random r) {
		this.r = r;
	}

	public String[] getParte1Verso() {
		return parte1Verso;
	}

	public void setParte1Verso(String[] parte1Verso) {
		this.parte1Verso = parte1Verso;
	}

	public String[] getParte2Verso() {
		return parte2Verso;
	}

	public void setParte2Verso(String[] parte2Verso) {
		this.parte2Verso = parte2Verso;
	}

	public String[] getParte3Verso() {
		return parte3Verso;
	}

	public void setParte3Verso(String[] parte3Verso) {
		this.parte3Verso = parte3Verso;
	}

	public String[] getParte4Verso() {
		return parte4Verso;
	}

	public void setParte4Verso(String[] parte4Verso) {
		this.parte4Verso = parte4Verso;
	}

	public String[] getParte5Verso() {
		return parte5Verso;
	}

	public void setParte5Verso(String[] parte5Verso) {
		this.parte5Verso = parte5Verso;
	}

	public String[] getParte6Verso() {
		return parte6Verso;
	}

	public void setParte6Verso(String[] parte6Verso) {
		this.parte6Verso = parte6Verso;
	}

	public String obtenerCancion() {
		String contenido = "";
		return contenido;
	}
}
