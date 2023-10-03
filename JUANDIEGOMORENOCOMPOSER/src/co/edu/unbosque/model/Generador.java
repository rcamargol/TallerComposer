package co.edu.unbosque.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.swing.JOptionPane;

public class Generador {

	
	private String [] parte1;
	private String [] parte2;
	private String [] parte3;
	private String [] parte4;
	private String [] parte5;
	private String [] parte6;
	private int numEstrofas;
	private int frasesPorEstrofa;
	
	
	public Generador() {
		
		this.parte1= new String[5] ;
		parte1[0]="Mami";
		parte1[1]="Bebé";
		parte1[2]="Princesa";
		parte1[3]="Mami";
		parte1[4]="Reina";
		
		this.parte2= new String[5];
		parte2[0]=" yo quiero";
		parte2[1]=" yo puedo";
		parte2[2]=" yo vengo a";
		parte2[3]=" yo voy a";
		parte2[4]=" me encanta";
		
		this.parte3= new String[6];
		parte3[0]=" encenderte";
		parte3[1]=" amarte";
		parte3[2]=" ligar";
		parte3[3]=" jugar";
		parte3[4]=" besarte";
		parte3[5]=" abrazarte";
		
		this.parte4= new String	[5];
		parte4[0]=" suave";
		parte4[1]=" lento";
		parte4[2]=" rapido";
		parte4[3]=" fuerte";
		parte4[4]=" intensamente";
	
		this.parte5= new String	[5];
		parte5[0]=" hasta que salga el sol";
		parte5[1]=" toda la noche";
		parte5[2]=" hasta el amanecer";
		parte5[3]=" todo el dia";
		parte5[4]=" toda la vida";
		
		this.parte6= new String	[5];
		parte6[0]=" sin anestesia";
		parte6[1]=" sin compromiso";
		parte6[2]=" face to face";
		parte6[3]=" sin miedo";
		
				
		
		this.numEstrofas=0;
		this.frasesPorEstrofa=0;
		
		cargarPropiedades();
		
	}
	
	private void cargarPropiedades() {
		Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("c:\\data\\cancion.properties"));
            numEstrofas = Integer.parseInt(prop.getProperty("numEstrofas"));
            frasesPorEstrofa = Integer.parseInt(prop.getProperty("frasesPorEstrofa"));
        } catch (IOException | NumberFormatException e) {
            numEstrofas = 0;
            frasesPorEstrofa = 0;
        }
    }
	
	public void setParameters(int numEstrofas, int frasesPorestrofa) {
		this.numEstrofas=numEstrofas;
		this.frasesPorEstrofa=frasesPorestrofa;
	}
	
	public String generarCancion() {
	if(numEstrofas<=0||frasesPorEstrofa<=0) {
	JOptionPane.showMessageDialog(null, "Por favor, configura los parametros primero","Error",JOptionPane.ERROR_MESSAGE);
	return "";
	}
	
	
	Random rand= new Random();
	StringBuilder cancion= new StringBuilder();
	
	for (int i = 0; i < numEstrofas; i++) {
        for (int j = 0; j < frasesPorEstrofa; j++) {
            String parte1Aleatoria = parte1[rand.nextInt(parte1.length)];
            String parte2Aleatoria = parte2[rand.nextInt(parte2.length)];
            String parte3Aleatoria = parte3[rand.nextInt(parte3.length)];
            String parte4Aleatoria = parte4[rand.nextInt(parte4.length)];
            String parte5Aleatoria = parte5[rand.nextInt(parte5.length)];

            
            String frase = parte1Aleatoria + " " + parte2Aleatoria + " " +
                           parte3Aleatoria + " " + parte4Aleatoria + " " +
                           parte5Aleatoria;

            cancion.append(frase).append("\n");
        }
        
        if(i<numEstrofas -1) {
        	cancion.append("\n");
        	
        }
    }

    return cancion.toString();
	
	
	
}	
}
