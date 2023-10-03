package co.edu.unbosque.model;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFileChooser;

import co.edu.unbosque.model.persistence.EjercicioArchivo;
import co.edu.unbosque.model.persistence.Propiedades;

public class Compositor {
private String [][] palabrasCancion;
private String cancion;
private int contador;

private EjercicioArchivo eja;
private Propiedades prop;
private Random r;
private String [][] matrizEstrofas;

public Compositor() {
	palabrasCancion = new String [4][6];
	eja = new EjercicioArchivo();
	prop = new Propiedades(null, null);
	r = new Random();
			
}

public void crearLetrasCancion() {
	palabrasCancion [0][0]= "Mami ";
	palabrasCancion [1][0]= "Bebe ";
	palabrasCancion [2][0]= "Princess ";
	palabrasCancion [3][0]= "Mami ";
	palabrasCancion [0][1]= "yo quiero ";
	palabrasCancion [1][1]= "yo puedo ";
	palabrasCancion [2][1]= "yo vengo ";
	palabrasCancion [3][1]= "yo voy ";
	palabrasCancion [0][2]= "encenderte ";
	palabrasCancion [1][2]= "amarte ";
	palabrasCancion [2][2]= "ligar ";
	palabrasCancion [3][2]= "jugar ";
	palabrasCancion [0][3]= "suave ";
	palabrasCancion [1][3]= "lento ";
	palabrasCancion [2][3]= "rapido ";
	palabrasCancion [3][3]= "fuerte ";
	palabrasCancion [0][4]= "hasta que salga el sol ";
	palabrasCancion [1][4]= "toda la noche ";
	palabrasCancion [2][4]= "hasta el amanecer ";
	palabrasCancion [3][4]= "todo el dia ";
	palabrasCancion [0][5]= "sin anestesia ";
	palabrasCancion [1][5]= "sin compromiso ";
	palabrasCancion [2][5]= "face to face ";
	palabrasCancion [3][5]= "sin miedo ";
	
}

public void definirPropiedades(String num1, String num2) {
	String frase = "";
	int numRandom = 0;

	
	System.out.println(num1 + " "+ num2);
	prop.escribirPropiedades(num1, num2);
	System.out.println(prop.getEstrofas()+ " "+prop.getFrasesEstrofa());
	matrizEstrofas = new String [Integer.parseInt(prop.getFrasesEstrofa())][Integer.parseInt(prop.getEstrofas())];
	
	
			for (int k = 0; k < Integer.parseInt(prop.getEstrofas()); k++ ) {
				for (int l = 0; l < Integer.parseInt(prop.getFrasesEstrofa()); l++ ) {
					frase = "";
					for (int m = 0; m < 6; m++) {
						numRandom = r.nextInt(3);
						frase += palabrasCancion[numRandom][m];
						matrizEstrofas [l][k]=frase;
					}
					
				}
			}

	

}

public void mostrarMatriz(String nombreCancion) {
	contador = 0;
	for (int i = 0; i < matrizEstrofas[0].length; i++) {// Revisa las columnas
		for (int j = 0; j < matrizEstrofas.length; j++) {// Revisa las filas
			contador = contador+1;
			
			if(contador==Integer.parseInt(prop.getFrasesEstrofa()) ) {
			cancion +=matrizEstrofas[j][i]+"\n"+"\n";
			contador=0;
			} else {
				cancion +=matrizEstrofas[j][i]+"\n";
				
			}
			
		}
		eja.crearArchivos(cancion, nombreCancion);
	}

}

public  String seleccionarArchivo() {
    JFileChooser fileChooser = new JFileChooser();

    int valor = fileChooser.showOpenDialog(null);

    if (valor == JFileChooser.APPROVE_OPTION) {
        File archivoSeleccionado = fileChooser.getSelectedFile();
        return archivoSeleccionado.getAbsolutePath();
    } else {
        return null; 
    }
}

public String leerContenidoDelArchivo(String ubicacion) {
    try {
        File archivo = new File(ubicacion);
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
