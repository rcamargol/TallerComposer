package co.edu.unbosque.model;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


import co.edu.unbosque.model.persistencia.Perreito;
import co.edu.unbosque.model.persistencia.Propiedades;
public class CrearCancion {
	public Conector1 Conector1 = new Conector1();
	public Conector2 Conector2 = new Conector2();
	public Conector3 Conector3 = new Conector3();
	public Conector4 Conector4 = new Conector4();
	public Conector5 Conector5 = new Conector5();
	public Conector6 Conector6 = new Conector6();
	public Perreito Perreito = new Perreito();

	public String crearCancion(int numEstrofas, int numFrases) {
		
		
		String crearCancion = "";
		for (int i = 0; i < numEstrofas; i++) {
			for(int t = 0;t< numFrases;t++) {
				String estrofaCreada = tema(numFrases);
	            crearCancion += estrofaCreada + " \n";
			}
			
			
            crearCancion += "\n";
        }
        return crearCancion;
	}
	public String seleccionarArchivo() {
       
        return Perreito.tomarArchivo();

    }
	public String tema (int numFrases) {
    String frase1 = "";
	
		for (int i = 0; i < numFrases; i++) {
		frase1 = Conector1.palabraRandom() + " "+Conector2.palabraRandom()+ " "+Conector3.palabraRandom()+" "+Conector4.palabraRandom()+" "+Conector5.palabraRandom()+" "+Conector6.palabraRandom() ;
		
		}
		return frase1;
   }
	public String gestionarArchivoCadena(int numFrases , String nombreArchivo, String cancionCreada) {
		
		Perreito archivodata = new Perreito();	
		archivodata.setArchivodata(nombreArchivo);
		String ruta = nombreArchivo +".txt";
		archivodata.guardarEnArchivo(ruta, cancionCreada);
		 
		return "leí este dato : "+archivodata.leerArchivo();
		
	}

	public String gestionarPropiedades(int numEstrofas, int numFrases) {
		Propiedades prop = new Propiedades();
		
	
		prop.escribirPropiedades(numEstrofas,  numFrases );
		return "Se leyeron estas propiedades: "+"\n"+prop.leerPropiedades();
	}
	public static String leerArchivos() {
		Perreito n = new Perreito();
		JFileChooser buscador = new JFileChooser();
		buscador.showOpenDialog(buscador);
		try {
			String patch = buscador.getSelectedFile().getAbsolutePath();
		
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
			 
			
			buscador.setFileFilter(filtro);
			FileInputStream archivo = new FileInputStream(patch);

			DataInputStream entrada = new DataInputStream(archivo);
			
			BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));

			File selectedFile = buscador.getSelectedFile();
			String lugar = selectedFile.getAbsolutePath();
			n.setArchivodata(lugar);
			
			
			entrada.close();
			

		}catch(Exception e) {
			return null;
		}
		return n.leerArchivo();
	}

}


