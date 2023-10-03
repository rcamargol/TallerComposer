package co.edu.unbosque.controller;
import co.edu.unbosque.model.LogicaReggaeton;
import co.edu.unbosque.view.View;

public class Controller {
	
	private View view;
    private LogicaReggaeton model;
    
   
    
    public Controller() {
        model = new LogicaReggaeton();
        view = new View();
       
        ejecutar();
    }

    public void ejecutar() {
    	
    	
        String nombreArchivo = null;
        int cantidadEstrofas = 0;
        int cantidadFrases = 0;
    	int opcion;
        do {
            opcion = view.mostrarMenu();
            switch (opcion) {
               
            case 1:

            		view.escribirDato("Selecione la ruta y el nombre del archivo con el .txt");
            		nombreArchivo =  model.seleccionarRutaArchivos();
                    cantidadEstrofas = view.obtenerCantidadEstrofas();
                    cantidadFrases = view.obtenerCantidadFrasesPorEstrofa();
                    view.escribirDato("Parametros guardados exitosamente");
                    break;
            
            case 2:
                	if (nombreArchivo != null && cantidadEstrofas > 0 && cantidadFrases > 0) {
                        String cancionGenerada = model.generarCancion(cantidadEstrofas, cantidadFrases);
                        view.escribirDato("Canción generada y guardada en la ruta: " + nombreArchivo);
                       
                        view.escribirDato(model.gestionarArchivoCadena(cantidadFrases, nombreArchivo, cancionGenerada));
                       model.gestionarPropiedades(cantidadEstrofas, cantidadFrases);
                    } else {
                    	view.escribirDato("Por favor, primero ingrese los datos necesarios en la opción Definir parametros.");
                    }
                    break;
            
            case 3:
       			 	
       			
                	 String rutaArchivo = model.seleccionarArchivos();
                     if (rutaArchivo != null) {
                         String contenido = model.leerContenidoDelArchivos(rutaArchivo);
                         if (contenido != null) {
                        	 view.escribirDato("Contenido del archivo:\n" + contenido);
                         } else {
                        	 view.escribirDato("Error al leer el archivo.");
                         }
                     } else {
                         System.out.println("Selección de archivo cancelada.");
                     }
                 
             
                    break;
            
            case 4:
            		view.escribirDato("Saliendo del programa.");
                    break;
            }
        } while (opcion != 4);
    }

	
}


