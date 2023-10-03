package co.edu.unbosque.model;
import java.io.File;
import java.util.Random;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import co.edu.unbosque.model.persistence.EjemploFile;
import co.edu.unbosque.model.persistence.Propiedades;

public class EjercicioArchivo{
	Random rand = new Random();
	int parrafos = 0;
	int frases = 0;
	String palabras[][] = {{"mami","bebe","princess","mor"},{"yo quiero","yo puedo","yo vengo a","voy a"},{"jugar","ligar","amarte","encenderte"},{"suave","lento","rapido","fuerte"},{"hasta que salga el sol","Toda la noche","hasta al amanecer","todo el dia"},{"sin anestecia","sin compromiso","feis to feis","sin miedo"}};
	//metodo para leer el archivo
	leerArchivo l = new leerArchivo();
	
	
	
	//metodos para crear una frase con palabras aleatorias
	public int numero() {
		return rand.nextInt(4);
	}
	public String cadena() {
		String cadena = "";
		for(int i = 0;i<6;i++) {
			cadena+=" "+palabras[i][numero()];
		}
		return cadena;
	}
	
	//metodos pára crear cancion
	public void crearcancion(String ruta) {
		EjemploFile file = new EjemploFile();
		String cancion="";
		file.setArchivodata(ruta);
		for(int i=0;i<parrafos;i++) {
			for(int t=0;t<frases;t++) {
				cancion+=cadena()+"\n";
			}
			System.out.println(frases);
			System.out.println(cancion);
			cancion+="\n";
		}
		
		file.escribirArchivo(cancion);
	}
	
	//metodo para crear el archivo propieties
    public String seleccionarRutaArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione la ruta del archivo");

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
        fileChooser.setFileFilter(filter);

        int resultado = fileChooser.showSaveDialog(null); 

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getAbsolutePath();
        } else {
            System.out.println("Selección de archivo cancelada.");
            return null;
        }
    }
    public String seleccionarRutaArchivoP() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione la ruta del archivo");

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (*..properties)", "properties");
        fileChooser.setFileFilter(filter);

        int resultado = fileChooser.showSaveDialog(null); 

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            return selectedFile.getAbsolutePath();
        } else {
            System.out.println("Selección de archivo cancelada.");
            return null;
        }
    }
		

	
	//crear archivo de propiedades
	public String gestionarPropiedades(String ruta) {
		Propiedades prop = new Propiedades();
	
		String p = this.parrafos+"";
		String f = this.frases+"";
		prop.setParra(p);
		prop.setFrase(f);
		prop.escribirPropiedades();
		prop.setArchivoprop(ruta);
		return "Se leyeron estas propiedades: "+"\n"+prop.leerPropiedades();
	}
	
	
	
	public int getParrafos() {
		return parrafos;
	}
	public void setParrafos(int parrafos) {
		this.parrafos = parrafos;
	}
	public int getFrases() {
		return frases;
	}
	public void setFrases(int frases) {
		this.frases = frases;
	}
	public leerArchivo getL() {
		return l;
	}
	public void setL(leerArchivo l) {
		this.l = l;
	}
	
	
}



