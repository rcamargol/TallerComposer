package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class View {
	
public View() {
	
			
}

public int mostrarMenuOpciones() {
	   
    String[] opciones = { "Determinar versos y estrofas", "Crear canción", "Mostrar canción", "Salir" };
    int e = JOptionPane.showOptionDialog(null,"¡Bienvenido a Reggaeton Composer!, selecciona una opción:","Menú Reggaeton Composer",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,opciones,opciones[0]
    );

    return e;
}

public  String obtenerCantidadEstrofas() {
    
	String estrofas = JOptionPane.showInputDialog(null, "Ingrese la cantidad de estrofas:");
        return estrofas;
   
}

public  String obtenerCantidadFrasesPorEstrofa() {
    String frasesPorEstrofa = JOptionPane.showInputDialog(null, "Ingresa la cantidad de frases por estrofa:");
        return frasesPorEstrofa;
   
}

public String obtenerNombreArchivo() {
    return JOptionPane.showInputDialog(null, "Ingresa el nombre del archivo, escribiendo su ruta, en formato C:\\data\\nombrecancion.txt:");
}



public void escribirDato(String dato) 
{
	JOptionPane.showMessageDialog(null, dato, "T�tulo del Message Dialog", JOptionPane.INFORMATION_MESSAGE);
}
}
