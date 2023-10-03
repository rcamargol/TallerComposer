package co.edu.unbosque.controller;


import javax.swing.JOptionPane;

import co.edu.unbosque.model.Fachada;
import co.edu.unbosque.view.View;

public class Controller {
	
	private Fachada fachada;
	private View view;
	
	public Controller() {
		fachada= new Fachada();
		view= new View();
		
	}
	
	public void ejecutar() {
		boolean exit= false;
		
		while(!exit) {
			String menu= "Menu Composer: \n"+
					"1. Configurar parámetros\n" +
                    "2. Generar canción\n" +
                    "3. Guardar cancion\n" +
                    "4. Seleccionar cancion guardada\n"+
                    "5. Salir\n"+
                    "Elije una opción: ";
			
			String seleccion1= JOptionPane.showInputDialog(null,menu);
			if(seleccion1== null) {
				exit=true;
				continue;
			}
			int seleccion2=Integer.parseInt(seleccion1);
			
			switch(seleccion2) {
			case 1:
				configurarParametros();
				break;
			case 2:
				generarCancion();
				break;
			case 3:
				guardarCancion();
				break;
			case 4:
				seleccionarCancionGuardada();
				break;
				
			case 5:	
				exit= true;
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcion no valida, intente de nuevo");
			}
		}
	}
	
	private void configurarParametros() {
        String numEstrofasStr = JOptionPane.showInputDialog("Ingrese el número de estrofas: ");
        String frasesPorEstrofaStr = JOptionPane.showInputDialog("Ingrese el número de frases por estrofa: ");

        if (numEstrofasStr == null || frasesPorEstrofaStr == null) {
            return;
        }

        int numEstrofas = Integer.parseInt(numEstrofasStr);
        int frasesPorEstrofa = Integer.parseInt(frasesPorEstrofaStr);

        fachada.configurarParametros(numEstrofas, frasesPorEstrofa);
    }

    private void generarCancion() {
        String song = fachada.generarCancion();
        JOptionPane.showMessageDialog(null, song);
    }

    private void guardarCancion() {
        boolean exito = fachada.guardarCancion();

        if (exito) {
            JOptionPane.showMessageDialog(null, "Canción guardada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al guardar la canción en el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void seleccionarCancionGuardada() {
        String cancionGuardada = fachada.seleccionarCancionGuardada();

        if (cancionGuardada != null) {
            JOptionPane.showMessageDialog(null, "Canción seleccionada:\n" + cancionGuardada);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo seleccionar la canción guardada.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
