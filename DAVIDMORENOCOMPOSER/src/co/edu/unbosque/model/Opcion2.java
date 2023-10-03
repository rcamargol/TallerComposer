package co.edu.unbosque.model;
import java.util.Properties;
import java.io.*;
import javax.swing.JFileChooser;

public class Opcion2 {
	
	private String [] line1 = {"Mami " , "Bebe " , "Plincess " , "Mamacita " , "Bichota "};
	private String [] line2 = {"Yo quielo " , "Yo puedo " , "Yo vengo a " , "Voy a " , "Estoy puesto pa' "};
	private String [] line3 = {"Encendelte " , "Amalte " , "Ligal " , "Jugal " , "Fumal "};
	private String [] line4 = {"Suave " , "Lento " , "lapido " , "Fuelte " , "Dulo "};
	private String [] line5 = {"Hasta que salga el sol " , "Toda la noche " , "Hasta el amanecel " , "Todo el dia " , "Hasta abajo "};
	private String [] line6 = {"Sin anestecia" , "Sin complomiso" , "feis to feis" , "Sin miedo" , "Sin palal"};
	
	public String LeerArchivoProp (Properties prop , String propFile) {
		
		int numFrases;
		int numEstrofas;
		try {
			
			prop.load(new FileInputStream(propFile));
			prop.list(System.out);
			
			numFrases = Integer.parseInt(prop.getProperty("Frases"));
			numEstrofas = Integer.parseInt(prop.getProperty("Estrofas"));
		}
		catch(IOException ex) {
			
			return "No fue posible leer el archivo.";
		}
		return CrearCancion (numFrases , numEstrofas);
	}
	
	public String CrearCancion (int fr , int es) {
		
		String frase = "";
		String estrofa = "";
		String cancion = "";
		
		for (int e = 0 ; e <= es ; e++) {
			
			cancion = cancion + estrofa + "\n";
			estrofa = "";

			for (int f = 0 ; f < fr ; f++) {
				
				frase = line1 [(int)(Math.random()*5)] + line2 [(int)(Math.random()*5)] + line3 [(int)(Math.random()*5)] + line4 [(int)(Math.random()*5)] + line5 [(int)(Math.random()*5)] + line6 [(int)(Math.random()*5)];
				estrofa = estrofa + frase + "\n";			
			}
		}
		return GuardarCancion(cancion);
	}
	
	public String GuardarCancion (String cancion) {
		
		JFileChooser save = new JFileChooser();
		save.showSaveDialog(null);
		save.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		File f = new File (save.getSelectedFile()+".txt");
		
		try {
			PrintWriter pw = new PrintWriter(f);
            pw.println(cancion);             
            pw.close();
		}
		catch (IOException ex) {
			
			return "Ha ocurrido un problema. Por favor intente de nuevo";
		}   
		
		return cancion;		
	}
}
