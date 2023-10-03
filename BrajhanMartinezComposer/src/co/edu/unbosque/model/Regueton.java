package co.edu.unbosque.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import co.edu.unbosque.model.persistence.File1;
import co.edu.unbosque.model.persistence.Propiedades;


public class Regueton {
	private Propiedades prop;
	private JFileChooser fc;
	private Random r;
	private File1 archivo;
	private File archivos;
	
	public Regueton() {
		prop = new Propiedades();
		fc = new JFileChooser();
		r = new Random();
		archivo = new File1();
	}
	
	public String archivar(int numEstrofas, int numLineas) {
		prop.escribirPropiedades(numEstrofas, numLineas);	
		return prop.leerPropiedades();
	}
	
	public String crearLineas(int numLineas) {
		
		String[] parte1 = {"MAMI ", "BEBE ", "PRINCESS ", "MAMI "};
		String[] parte2 = {"YO QUIERO ", "YO PUEDO ", "YO VENGO A ", "VOY A "};
		String[] parte3 = {"ENCENDELTE ", "AMALTE ", "LIGAL ", "JUGAL  "};
		String[] parte4 = {"SUAVE ", "LENTO ", "RÁPIDO ", "FUERTE "};
		String[] parte5 = {"HASTA QUE EL SOL SALGA ", "TODA LA NOCHE ", "HASTA EL AMANECER ", "TODO EL DIA "};
		String[] parte6 = {"SIN ANESTESIA,", "SIN COMPROMISO,", "FEIS TO FEIS,", "SIN MIEDO,"};
		
		String estrofa = "";
		
		for(int i = 0; i < numLineas; i++) {
			int random1 = r.nextInt(parte1.length);
			String frase1 = parte1[random1];
		
			int random2 = r.nextInt(parte2.length);
			String frase2 = parte2[random2];			
			
			int random3 = r.nextInt(parte3.length);
			String frase3 = parte3[random3];			
			
			int random4 = r.nextInt(parte4.length);
			String frase4 = parte4[random4];		
			
			int random5 = r.nextInt(parte5.length);
			String frase5 = parte5[random5];			
			
			int random6 = r.nextInt(parte6.length);
			String frase6 = parte6[random6];
			
			String cadena = frase1+frase2+frase3+frase4+frase5+frase6;
			estrofa += cadena+"\n";
		}
		return estrofa;
		
	}
	
	public String componer(int numEstrofas, int numLineas) {
        String cancion = "";
        for (int i = 0; i < numEstrofas; i++) {
            String estrofaGenerada = crearLineas(numLineas);
            cancion += estrofaGenerada + "\n";
        }
        return cancion;
	}
	
	public String crearArchivo(String cancion) {	
		archivo.escribirArchivo(cancion, archivos);
		return archivo.leerArchivo(archivos);
	}
	
	public void guardarArchivo() {
		fc.setDialogType(JFileChooser.SAVE_DIALOG);
		fc.showSaveDialog(null);
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		archivos = fc.getSelectedFile();
	}
	
	public String elegirArchivo() {
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
		fc.setFileFilter(filtro);
		
		int valor = fc.showOpenDialog(fc);
		
		if(valor == JFileChooser.APPROVE_OPTION) {
			File f = fc.getSelectedFile();
			return f.getAbsolutePath();
		}else {
			return null;	
		}
	}
	
	public String leerArchivo(String rutaArchivo) {
        try {
            File archivo = new File(rutaArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            StringBuilder contenido = new StringBuilder();
            String linea;

            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }

            br.close();
            fr.close();
            return contenido.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
