package co.edu.unbosque.controller;
import javax.swing.JOptionPane;
import co.edu.unbosque.view.View;
import co.edu.unbosque.model.*;
public class Controller {
    private View gui;
    private CrearCancion model;
    
    public Controller() {
        gui = new View();
        model = new CrearCancion();
        menu();
        
    }

    public void menu() {
        int opcion;
        int numEstrofas = 0;
        int numFrases = 0;
        String nombreArchivo = null;
        do {
            opcion = gui.mostrarMenu();

            switch (opcion) {
                case 1:

                    nombreArchivo = model.seleccionarArchivo();
                    numEstrofas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de estrofas:"));
                    numFrases = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de frases:"));
                    break;
                case 2:
                    if (numEstrofas > 0 && numFrases > 0) {
                        String cancionGenerada = model.crearCancion(numEstrofas, numFrases);
                        
						gui.escribirDato("Canción generada y guardada en la ruta: " + nombreArchivo);
                        gui.escribirDato(model.gestionarArchivoCadena(numFrases, nombreArchivo+".txt", cancionGenerada));
                        gui.escribirDato(model.gestionarPropiedades(numEstrofas, numFrases));
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe definir el número de estrofas y frases antes de mostrar la canción.");
                    }
                    break;
                case 3:
                	
                	JOptionPane.showMessageDialog(null, " Mostrar Cancion ");
                	gui.escribirDato(model.leerArchivos());  
                	break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija una opción válida.");
                    break;
            }
        } while (opcion != 4);
    }

}

