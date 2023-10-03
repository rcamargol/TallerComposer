package co.edu.unbosque.model.persistencia;
import java.io.File;
import javax.swing.JFileChooser;
import java.io.*;

public class Perreito  {
	
	
	private String archivodata;
	
	
	  public String getArchivodata() {
		return archivodata;
	}


	public void setArchivodata(String archivodata) {
		this.archivodata = archivodata;
	}


	public int guardarEnArchivo(String nombreArchivo, String cancion) {
    
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
	public String tomarArchivo() {
		 JFileChooser fileChooser = new JFileChooser();

	        int returnValue = fileChooser.showOpenDialog(null);

	        if (returnValue == JFileChooser.APPROVE_OPTION) {
	            File selectedFile = fileChooser.getSelectedFile();
	            return selectedFile.getAbsolutePath();
	        } else {
	            return null; 
	        }
	    }	
}
	