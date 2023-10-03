package co.edu.unbosque.model;

import java.util.Random;

import co.edu.unbosque.model.persistence.EjemploFile;
import co.edu.unbosque.model.persistence.Persistence;


public class CancionRegueton {
	

	private String[] PrimerVerso = {"mami","yo quielo","encendelte","suave","hasta que salga el sol mami lica","sin anentecia"};
	private String[] SegundoVelso = {"beby","yo puedo","amalte","lento","toda la noche si dios quire beby","sin complomiso mami"};
	private String[] TerserVelso = {"princes","yo vuelvo a ","ligal","rapido","hasta el amanecer mor","feis to feis mom"};
	private String[] CuartoVelso = {"mami","voy a ","jugar","fuelte","todo el dia cabron","sin miedo al exito mami"};
	private String[] QuintoVelso= {"dimelo","my beby","ella es mi todo ","un movimiento sexy","hasta el otro mes ","sin mente como el demente "};
	private EjemploFile archivo;
	private Random random;
	
	
	public CancionRegueton() {
		archivo = new EjemploFile();
		random = new Random();
	}
	
	public void resultadoCancion(int NumerosDeVersos, int NumeroDeEstrofas, String NombreDelArchivo) {
		String cancion ="";
		for(int i= 0; i<NumeroDeEstrofas;i++) {
			cancion+="estrofa#"+(i++)+"\n";
			for(int k = 0;k<NumeroDeEstrofas;k++) {
				cancion+=PrimerVerso[random.nextInt( 4)] +" ";
				cancion+=SegundoVelso[random.nextInt( 4)] +" ";
				cancion+=TerserVelso[random.nextInt( 4)] +" ";
				cancion+=CuartoVelso[random.nextInt( 4)] +" ";
				cancion+=QuintoVelso[random.nextInt( 4)] +"\n ";

			}
		}
		String archivoAEscribir = "c:\\\\data\\\\" + NombreDelArchivo + ".txt";
		archivo.escribirArchivo(archivoAEscribir, cancion);
	}
	public String gestionaPropiedades1(int NumeroDeEstrofas, int NumeroDeVersos, String NombreDelArchivo) {
		Persistence prop = new Persistence();
		prop.escribirPropiedades(NumeroDeEstrofas, NumeroDeVersos, NombreDelArchivo);
		return "Propiedades del archivo: \n" + prop.leerPropiedades();
	}
	
	public String[] getTerserVelso() {
		return TerserVelso;
	}
	
	
	
	public void setTerserVelso(String[] terserVelso) {
		TerserVelso = terserVelso;
	}

	public String[] getCuartoVelso() {
		return CuartoVelso;
	}

	public void setCuartoVelso(String[] cuartoVelso) {
		CuartoVelso = cuartoVelso;
	}

	public String[] getQuintoVelso() {
		return QuintoVelso;
	}

	public void setQuintoVelso(String[] quintoVelso) {
		QuintoVelso = quintoVelso;
	}

	public EjemploFile getArchivo() {
		return archivo;
	}

	public void setArchivo(EjemploFile archivo) {
		this.archivo = archivo;
	}

	public String[] getPrimerVerso() {
		return PrimerVerso;
	}

	public void setPrimerVerso(String[] primerVerso) {
		PrimerVerso = primerVerso;
	}

	public String[] getSegundoVelso() {
		return SegundoVelso;
	}

	public void setSegundoVelso(String[] segundoVelso) {
		SegundoVelso = segundoVelso;
	}


	public Random getRandom() {
		return random;
	}


	public void setRandom(Random random) {
		this.random = random;
	}
	public String obtenerCancion() {
		String contenido = "";
		return contenido;
	}

	public void gestionaPropiedades(int numeroDeVersos, int numeroDeEstrofas, String nombreDelArchivo) {
		// TODO Auto-generated method stub
		
	}
}
