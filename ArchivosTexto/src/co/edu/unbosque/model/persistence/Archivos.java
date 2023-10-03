package co.edu.unbosque.model.persistence;

import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Archivos  {
	
	
	private String archivodata;
	
	
	  public String getArchivodata() {
		return archivodata;
	}


	public void setArchivodata(String archivodata) {
		this.archivodata = archivodata;
	}


	public int guardarCancionEnArchivo(String nombreArchivo, String cancion) {
    
		  File f = new File(this.archivodata);
			
	
	  try {
		  
		  FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println(cancion);
			fw.close();

      } catch (IOException e) {
			return -1;
      }
		return 0;
  }
 
	
	public String leerArchivo() {
		
		String linea = "";
		String cadena = "";
		
		File f = new File(this.archivodata); 
		
		try {
			FileReader fr = new FileReader(f); 
			BufferedReader br = new BufferedReader(fr); 
			linea = br.readLine();   
			while (linea != null) {   
				cadena += linea+ "\n";      
				linea = br.readLine(); 
			}
			fr.close();
		} 
		catch (IOException e) {
			return null;
		}
		return cadena ;
	}
	   public  String seleccionarArchivo() {
	        JFileChooser fileChooser = new JFileChooser();

	        int returnValue = fileChooser.showOpenDialog(null);

	        if (returnValue == JFileChooser.APPROVE_OPTION) {
	            File selectedFile = fileChooser.getSelectedFile();
	            return selectedFile.getAbsolutePath();
	        } else {
	            return null; 
	        }
	    }

	    public String leerContenidoDelArchivo(String rutaArchivo) {
	        try {
	            File archivo = new File(rutaArchivo);
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
	    public String seleccionarRutaArchivo() {
	        JFileChooser fileChooser = new JFileChooser();
	        fileChooser.setDialogTitle("Seleccione la ruta del archivo");
	        
	        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt");
	        fileChooser.setFileFilter(filter);
	        
	        int resultado = fileChooser.showSaveDialog(null); 
	        
	        if (resultado == JFileChooser.APPROVE_OPTION) {
	            File selectedFile = fileChooser.getSelectedFile();
	            return selectedFile.getAbsolutePath();
	        } else {
	            System.out.println("Selecci�n de archivo cancelada.");
	            return null;
	        }
	    }

}
