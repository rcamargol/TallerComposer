package co.edu.unbosque.model.persistence;

import java.io.*;

import javax.swing.JFileChooser;

public class FileManager {
	
	private String rutaArchivo = "C:\\Data\\archivo.txt";
	private JFileChooser chooser = new JFileChooser();
	
	
	public int escribirArchivo(String mensaje) {
        int resultado = chooser.showSaveDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();

            // Asegurarse de que la extensión del archivo sea .txt
            if (!archivo.getName().toLowerCase().endsWith(".txt")) {
                archivo = new File(archivo.getAbsolutePath() + ".txt");
            }

            try {
                FileWriter fw = new FileWriter(archivo);
                PrintWriter pw = new PrintWriter(fw);

                pw.write(mensaje);

                pw.close();

                return 0;
            } catch (IOException e) {
                e.printStackTrace();
                return -1;
            }
        } else {
            return -1; // El usuario canceló la operación
        }
    }

  
	public String obtenerRutaArchivoSeleccionado() {
	    if (chooser.getSelectedFile() != null) {
	        return chooser.getSelectedFile().getAbsolutePath();
	    } else {
	        return null;
	    }
	}
	
	public String leerArchivo() {
		
		File f = new File(this.rutaArchivo);
		
		String contenido = "", linea = "";
		
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			linea += br.readLine();
			while (linea != null) {
				contenido += linea + "\n";
				linea = br.readLine();
			}
			
			br.close();
			
		} catch(IOException e) {
			return null;
		}
		return contenido;
	}
	
	public void getArchivo() {
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			setRutaArchivo(chooser.getSelectedFile().toString());
		}
	}

	public String getRutaArchivo() {
		return rutaArchivo;
	}

	public JFileChooser getChooser() {
		return chooser;
	}

	public void setRutaArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

	public void setChooser(JFileChooser chooser) {
		this.chooser = chooser;
	}
}
