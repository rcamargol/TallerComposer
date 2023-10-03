package co.edu.unbosque.model;

import java.util.Random;
import co.edu.unbosque.model.persistence.*;

public class Cancion {
	 private String[] Verso1= {"mami","bebe","plincess","mami"};
	 private String[] Verso2= {"yo quielo","Yo puedo","Yo vengo","voy a"};
	 private String[]Verso3= {"enceldelte","amalte","ligal","jugar"};
	 private String[] Verso4= {"Suave","Lento","rapido","Fuelte"};
	 private String[] Verso5= {"Hasta qye salga el sol","toda la noche","hasta el amanecer","todo el dia"};
	 private String[]Verso6= {"Sin anestesia","Sin complomiso","feis ti feis","sin miedo"};
	 
	 private Random random=new Random();
	 String Letra="";
	 
	 public void CrearCancion(String NombreArchivo,int NumeroEstrofas, int NumeroVersos) {
		 for(int i=0;i<NumeroEstrofas;i++) {
			 for(int j=0;j<NumeroVersos;j++) {
				 Letra += Verso1[random.nextInt(0, 4)] ;
					Letra += Verso2[random.nextInt(0, 4)];
					Letra += Verso3[random.nextInt(0, 4)];
					Letra += Verso4[random.nextInt(0, 4)];
					Letra += Verso5[random.nextInt(0, 4)];
					Letra += Verso6[random.nextInt(0, 4)]+ "\n\n";
			 }
		 }
		 
		  }
	 public String Propiedades(String NombreArchivo,int NumeroEstrofas, int NumeroVersos) {
		 Propiedades prop=new Propiedades();
		 prop.escribirPropiedades(NombreArchivo,NumeroEstrofas,NumeroVersos);
		 
		 return"Las propiedades del archivos son: "+prop.leerPropiedades();			
	 }
	public String[] getVerso1() {
		return Verso1;
	}
	public void setVerso1(String[] verso1) {
		Verso1 = verso1;
	}
	public String[] getVerso2() {
		return Verso2;
	}
	public void setVerso2(String[] verso2) {
		Verso2 = verso2;
	}
	public String[] getVerso3() {
		return Verso3;
	}
	public void setVerso3(String[] verso3) {
		Verso3 = verso3;
	}
	public String[] getVerso4() {
		return Verso4;
	}
	public void setVerso4(String[] verso4) {
		Verso4 = verso4;
	}
	public String[] getVerso5() {
		return Verso5;
	}
	public void setVerso5(String[] verso5) {
		Verso5 = verso5;
	}
	public String[] getVerso6() {
		return Verso6;
	}
	public void setVerso6(String[] verso6) {
		Verso6 = verso6;
	}
	public Random getRandom() {
		return random;
	}
	public void setRandom(Random random) {
		this.random = random;
	}
	public String getLetra() {
		return Letra;
	}
	public void setLetra(String letra) {
		Letra = letra;
	}
	 
	
	 }


