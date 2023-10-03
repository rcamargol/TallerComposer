package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.Archivo;
import co.edu.unbosque.model.persistence.Propiedades;

public class Fachada {
	
	private Generador generador;
    private Archivo archivo;
    private Propiedades propiedades;
    private GuardarCancion gc;

    public Fachada() {
        generador = new Generador();
        archivo = new Archivo();
        propiedades = new Propiedades();
        gc= new GuardarCancion();
    }

    public void configurarParametros(int numEstrofas, int frasesPorEstrofa) {
        generador.setParameters(numEstrofas, frasesPorEstrofa);
        propiedades.escribirPropiedades(numEstrofas, frasesPorEstrofa);
    }

    public String generarCancion() {
        return generador.generarCancion();
    }

    public boolean guardarCancion() {
        String song = generador.generarCancion();
        return gc.guardarCancionConFileChooser(song);
    }

    public String seleccionarCancionGuardada() {
        return gc.abrircancion();
    }
}


