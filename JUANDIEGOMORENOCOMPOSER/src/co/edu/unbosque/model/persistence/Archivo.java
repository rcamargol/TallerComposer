package co.edu.unbosque.model.persistence;


import co.edu.unbosque.model.GuardarCancion;

public class Archivo {
	
	private GuardarCancion archivo;

    public Archivo() {
        archivo = new GuardarCancion();
    }

    public boolean escribirArchivo(String nomArchivo, String contenido) {
        return archivo.escribirArchivo(nomArchivo, contenido);
    }

   public String leerArchivo(String rutaArchivo) {
	return archivo.leerArchivo(rutaArchivo);
	   
   }

   
   public boolean generarCancionConFileChooser(String Contenido) {
	   return archivo.guardarCancionConFileChooser(Contenido);
	   
   }
   
   public boolean guardarCancionConFileChooser(String contenido) {
       return archivo.guardarCancionConFileChooser(contenido);
   }
}
   


