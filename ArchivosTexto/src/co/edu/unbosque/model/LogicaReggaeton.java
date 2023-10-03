package co.edu.unbosque.model;
import java.util.Random;
import co.edu.unbosque.model.persistence.Archivos;
import co.edu.unbosque.model.persistence.Propiedades;

public class LogicaReggaeton {

	private String[] conector1 =  {"Mami", "Bebé", "Princess"};
    private String[] conector2 =  {"yo quiero", "yo puedo", "yo vengo a", "voy a"};
    private String[] conector3 =  {"enceldelte", "amalte", "ligar", "jugar"};
    private String[] conector4 =  {"suave", "lento", "fuerte", "rapido"};
    private String[] conector5 =  {"hasta que salga el sol", "toda la noche", "hasta el amanecer", "todo el dia"};
    private String[] conector6 =  {"sin anestesia", "sin compromiso", "feis to feis", "sin miedo"};


  
    public String generarEstrofa(int cantidadFrases) {
        String estrofa = "";
        Random random = new Random();

        for (int i = 0; i < cantidadFrases; i++) {
            String palabra1 = conector1[random.nextInt(conector1.length)];
            String palabra2 = conector2[random.nextInt(conector2.length)];
            String palabra3 = conector3[random.nextInt(conector3.length)];
            String palabra4 = conector4[random.nextInt(conector4.length)];
            String palabra5 = conector5[random.nextInt(conector5.length)];
            String palabra6 = conector6[random.nextInt(conector6.length)];

            String frase = palabra1 + " " + palabra2 + " " + palabra3 + " " + palabra4 + " " + palabra5 + " " + palabra6;
            estrofa += frase + "\n";
        }
        return estrofa;
    }

    public String generarCancion(int cantidadEstrofas, int cantidadFrasesPorEstrofa) {
        String cancion = "";
        for (int i = 0; i < cantidadEstrofas; i++) {
            String estrofaGenerada = generarEstrofa(cantidadFrasesPorEstrofa);
            cancion += estrofaGenerada + "\n";
        }
        return cancion;
    }
    public String gestionarArchivoCadena(int cantidadFrases,String nombreArchivo, String cancionGenerada) {
		
		Archivos archivo = new Archivos();	
		archivo.setArchivodata(nombreArchivo);
		
		archivo.guardarCancionEnArchivo(nombreArchivo, cancionGenerada);
		 
		return "leí este dato : "+archivo.leerArchivo();
		
	}
  
  
    
	public String gestionarPropiedades(int cantidadEstrofas, int cantidadFrases) {
		Propiedades prop = new Propiedades();
		
	
		prop.escribirPropiedades(cantidadEstrofas,  cantidadFrases );
		return "Se leyeron estas propiedades: "+"\n"+prop.leerPropiedades();
	}

	public String seleccionarRutaArchivos() {
		Archivos archivo = new Archivos();	
		return archivo.seleccionarRutaArchivo();
		
	}

	public String leerContenidoDelArchivos(String rutaArchivo) {
		Archivos archivo = new Archivos();	
		return archivo.leerContenidoDelArchivo(rutaArchivo);
	}

	public String seleccionarArchivos() {
		Archivos archivo = new Archivos();	
		return archivo.seleccionarArchivo();
	}
	

	 
	}






