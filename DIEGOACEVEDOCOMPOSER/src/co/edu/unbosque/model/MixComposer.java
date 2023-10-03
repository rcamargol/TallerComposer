package co.edu.unbosque.model;

import java.util.Random;

import co.edu.unbosque.model.persistence.FileManager;
import co.edu.unbosque.model.persistence.Propiedades;

public class MixComposer {
	private FileManager fm;
	private Propiedades propiedades;
	private String[] fr1 = {"mami", "bebe", "plincess", "mami"};
	private String[] fr2 = {"yo quielo", "yo puedo", "yo vengo", "voy a"};
	private String[] fr3 = {"encendelte", "amalte", "ligal", "jugal"};
	private String[] fr4 = {"suave", "lento", "rapido", "fuelte"};
	private String[] fr5 = {"hasta que salga el sol", "toda la noche", "hasta el amanecel", "todo el dia"};
	private String[] fr6 = {"sin anestesia", "sin complomiso", "feis to feis", "sin miedo"};
	
	private int estrofas;
	private int frasesPorEstrofa;
	private String nombreDeLaCancion;
	private String cancion;
	
	public MixComposer() {
		fm = new FileManager();
		propiedades = new Propiedades();
		
	}
	
	public void construirCancion(int estrofas, int frasesPorEstrofa, String nombreDeLaCancion) {
		
		Random r = new Random();
		
		String cancion = "Nombre de la canción: " + nombreDeLaCancion + "\n";
		
		for (int i = 0; i < estrofas; i++) {
			cancion += "********Estrofa" + (i+1) +  " *************\n";
			for (int j = 0; j < frasesPorEstrofa; j++) {
				cancion += fr1[r.nextInt(0, fr1.length)] + " ";
				cancion += fr2[r.nextInt(0, fr2.length)] + " ";
				cancion += fr3[r.nextInt(0, fr3.length)] + " ";
				cancion += fr4[r.nextInt(0, fr4.length)] + " ";
				cancion += fr5[r.nextInt(0, fr5.length)] + " ";
				cancion += fr6[r.nextInt(0, fr6.length)] + " ";
				cancion += "\n";
			}
			cancion += "\n";
		}
		setEstrofas(estrofas);
		setFrasesPorEstrofa(frasesPorEstrofa);
		setNombreDeLaCancion(nombreDeLaCancion);
		setCancion(cancion);
	}
	
	public String crearArchivoCancion() {
		int valorRetorno = 0;
		try {
			valorRetorno = fm.escribirArchivo(cancion, getNombreDeLaCancion());
			if (valorRetorno == 0) {
				return "Canción creada con éxito";
			}
			return "Fallo en la creación de la canción";
		} catch (NullPointerException e) {
			return "No se ha especificado el número de estrofas y versos para la canción";
		}
	}
	
	public void gestionarPropiedades(String nombreDeLaCancion, int estrofas, int frases) {
		propiedades.escribirPropiedadesDeLaCancion(nombreDeLaCancion, estrofas, frases);
		propiedades.listarPropiedadesDeCancion();
	}
	
	public String seleccionarCancion() {
		setCancion(null);
		setEstrofas(0);
		setFrasesPorEstrofa(0);
		fm.getArchivo();
		String cancion = "";
		try {
			cancion = fm.leerArchivo();
		} catch (NullPointerException e) {
			return "No se ha seleccionado ningún archivo";
		}
		return cancion;
	}

	public FileManager getFm() {
		return fm;
	}

	public Propiedades getPropiedades() {
		return propiedades;
	}

	public String[] getFr1() {
		return fr1;
	}

	public String[] getFr2() {
		return fr2;
	}

	public String[] getFr3() {
		return fr3;
	}

	public String[] getFr4() {
		return fr4;
	}

	public String[] getFr5() {
		return fr5;
	}

	public String[] getFr6() {
		return fr6;
	}

	public int getEstrofas() {
		return estrofas;
	}

	public int getFrasesPorEstrofa() {
		return frasesPorEstrofa;
	}

	public String getCancion() {
		return cancion;
	}

	public void setFm(FileManager fm) {
		this.fm = fm;
	}

	public void setPropiedades(Propiedades propiedades) {
		this.propiedades = propiedades;
	}

	public void setFr1(String[] fr1) {
		this.fr1 = fr1;
	}

	public void setFr2(String[] fr2) {
		this.fr2 = fr2;
	}

	public void setFr3(String[] fr3) {
		this.fr3 = fr3;
	}

	public void setFr4(String[] fr4) {
		this.fr4 = fr4;
	}

	public void setFr5(String[] fr5) {
		this.fr5 = fr5;
	}

	public void setFr6(String[] fr6) {
		this.fr6 = fr6;
	}

	public void setEstrofas(int estrofas) {
		this.estrofas = estrofas;
	}

	public void setFrasesPorEstrofa(int frasesPorEstrofa) {
		this.frasesPorEstrofa = frasesPorEstrofa;
	}

	public void setCancion(String cancion) {
		this.cancion = cancion;
	}
	
	public String getNombreDeLaCancion() {
		return nombreDeLaCancion;
	}
	
	public void setNombreDeLaCancion(String nombreDeLaCancion) {
		this.nombreDeLaCancion = nombreDeLaCancion;
	}
}
