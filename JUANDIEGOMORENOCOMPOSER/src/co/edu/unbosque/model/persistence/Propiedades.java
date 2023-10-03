package co.edu.unbosque.model.persistence;
import java.io.*;

import java.util.Properties;


public class Propiedades {
	
	private Properties prop = new Properties();
    private String archivoprop = "c:\\data\\cancion.properties";

    public int escribirPropiedades(int numEstrofas, int frasesPorEstrofa) {
        try {
            prop.setProperty("numEstrofas", String.valueOf(numEstrofas));
            prop.setProperty("frasesPorEstrofa", String.valueOf(frasesPorEstrofa));
            prop.store(new FileOutputStream(archivoprop), null);
        } catch (IOException ex) {
            return -1;
        }
        return 0;
    }

    public int[] leerPropiedades() {
        int[] parametros = new int[2];
        try {
            prop.load(new FileInputStream(archivoprop));

            String numEstrofasStr = prop.getProperty("numEstrofas");
            String frasesPorEstrofaStr = prop.getProperty("frasesPorEstrofa");

            if (numEstrofasStr != null && frasesPorEstrofaStr != null) {
                parametros[0] = Integer.parseInt(numEstrofasStr);
                parametros[1] = Integer.parseInt(frasesPorEstrofaStr);
            } else {
                parametros[0] = 0;
                parametros[1] = 0;
            }
        } catch (IOException ex) {
            return null;
        }
        return parametros;
    }
}