package co.edu.unbosque.model;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import co.edu.unbosque.model.persistence.*;

public class DjRegueton {
	private FileManager fm;
	private Property propiedades;
	private Clip audio;
	private VoiceManager voiceManager;
	private Voice voice;
	
	
	
	private String cancion;
	
	public DjRegueton() {
		fm = new FileManager();
		propiedades = new Property();
		
	}
	
	public void construirCancion(int estrofas, int frasesPorEstrofa, String nombreDeLaCancion) {
	    Random r = new Random();

	     cancion = "Dj Sergio Presenta con su tremendo disco llamado :   " + nombreDeLaCancion + "\n\n\n";

	    try {
	        // Leer todas las líneas del archivo en un arreglo de Strings
	        String[] lineas = Files.readAllLines(Paths.get("recursos/Frases.txt")).toArray(new String[0]);

	        for (int i = 0; i < estrofas; i++) {
	            for (int j = 0; j < frasesPorEstrofa; j++) {
	                for (int k = 0; k < 6; k++) {
	                    String[] palabras = lineas[k].split(",");
	                    cancion += palabras[r.nextInt(palabras.length)].trim() + ", ";
	                }
	                cancion += "\n";
	            }
	            cancion += "\n";
	        }
	        setCancion(cancion);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public String crearArchivoCancion() {
		if (fm.escribirArchivo(cancion) == 0) {
			return "Canción creada con éxito";
		} else {
			return "Fallo en la creación de la canción";
		}
	}
	
	
	public void gestionarPropiedades(String nombreDeLaCancion, int estrofas, int frases) {
		propiedades.escribirPropiedadesDeLaCancion(nombreDeLaCancion, estrofas, frases);
		propiedades.listarPropiedadesDeCancion();
	}
	
	public String seleccionarCancion() {
		fm.getArchivo();
		return fm.leerArchivo();
	}
	
	public void implementacionPropiedadesVoz() {
		// Configuro FreeTTS para utilizar la voz Kevin
	       System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
	       
	       // Obtengo la instancia del administrador de voces
	       voiceManager = VoiceManager.getInstance();
	       
	       // Selecciono la voz de Kevin que contiene 16 hz
	       voice = voiceManager.getVoice("kevin16");
	       
	       if (voice != null) {
	           // Inicializa la voz
	           voice.allocate();
	           
	           // velocidad de voz ( en este caso habla mas lento)
	           voice.setRate(140); 
	        // el texto que la voz de kevin pronunciara
	           voice.speak(cancion);
	           
	           // Libera los recursos de la voz
	           voice.deallocate();
	       } 
	   }


	public void reproducirCancionAleatoria() throws AudioException {
	    int cancionActual = -1;
	    
	    String[] canciones = {
	            "recursos/SoundTrack1.wav",
	            "recursos/SoundTrack2.wav",
	            "recursos/SoundTrack3.wav",
	            "recursos/SoundTrack4.wav"
	    };
	    Random random = new Random();
		
		try {
            if (canciones.length == 0) {
                throw new AudioException("No hay canciones disponibles.", null);
            }

            int nuevaCancion;
            do {
                nuevaCancion = random.nextInt(canciones.length);
            } while (nuevaCancion == cancionActual);

            if (audio != null && audio.isRunning()) {
                audio.stop();
                audio.close();
            }

            File archivo = new File(canciones[nuevaCancion]);
            AudioInputStream musica = AudioSystem.getAudioInputStream(archivo);
            audio = AudioSystem.getClip();
            audio.open(musica);

            FloatControl gainControl = (FloatControl) audio.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-8.0f);

            audio.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    try {
                        Thread.sleep(1000); // Espera 1 segundo antes de reproducir la siguiente canción
                        reproducirCancionAleatoria();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            audio.start();
            cancionActual = nuevaCancion;
        } catch (Exception e) {
            throw new AudioException("Error al reproducir la canción", e);
        }
    }
	

	public void setCancion(String cancion) {
		this.cancion = cancion;
	}
}