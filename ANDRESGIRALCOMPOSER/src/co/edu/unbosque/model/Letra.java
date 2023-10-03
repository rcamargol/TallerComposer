package co.edu.unbosque.model;

public class Letra {
	private String[] palabra1= {"Mami","Bebe","Plincess","Mami"};
	private String[] palabra2= {"Yo quielo","Yo puedo","Yo vengo a","Voy a"};
	private String[] palabra3= {"Encendelte","Amalte","Ligal","Jugal"};
	private String[] palabra4= {"Suave","Lento","Lapido","Fuelte"};
	private String[] palabra5= {"Hasta que salga el sol","Toda la noche","Hasta el amanecer","Todo el dia"};
	private String[] palabra6= {"Sin anestesia","Sin compromiso","Feis to feis","Sin miedo"};
	
public String crearCancion (int estrofas,int frases) {
	
		String frase = "";
		String estrofa = "";
		String cancion = "";
		
		for (int i = 0 ; i <= estrofas ; i++) {
			
			cancion = cancion + estrofa + "\n";
			estrofa = "";

			for (int j = 0 ; j < frases ; j++) {
				
				frase = palabra1 [(int)(Math.random()*4)] + palabra2 [(int)(Math.random()*4)] + palabra3 [(int)(Math.random()*4)] + palabra4 [(int)(Math.random()*4)] + palabra5 [(int)(Math.random()*4)] + palabra6 [(int)(Math.random()*4)];
				estrofa = estrofa + frase + "\n";			
			}
		}
		return (cancion);
	}
    


    }

