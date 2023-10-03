package co.edu.unbosque.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class View {
	private JFileChooser chooser=new JFileChooser();

	
	public int Menu() {
		String opciones="";

		  opciones += "1.Escoger numero de frases y estrofas\n";
			opciones	+= "2.Crear canción\n";
			opciones	+= "3.Mostrar una cancion ya creada\n";
			opciones	+= "Digite su opcion: ";

			int opcion= Integer.parseInt(JOptionPane.showInputDialog(opciones));
		 return opcion;	
	}
	
	public void MostrarArchivoCreado() {
		int Ventana=chooser.showOpenDialog(null);
		if(Ventana==JFileChooser.APPROVE_OPTION) {
			File cancionSeleccionada=chooser.getSelectedFile();
			try {
				String lineas ;
				StringBuilder str= new StringBuilder();
				BufferedReader reader=new BufferedReader(new FileReader(cancionSeleccionada));
				while((lineas=reader.readLine())!=null) {
					str.append(lineas).append("\n");
				}reader.close();				
				JOptionPane.showMessageDialog(null, ""+str.toString(),cancionSeleccionada.toString(),JOptionPane.INFORMATION_MESSAGE);
				
			}catch(IOException e) {
				JOptionPane.showMessageDialog(null, "error");
				
			}
			
		}
		
	}

	public String pedirDato(String dato) {
		return JOptionPane.showInputDialog( dato);
	}


	public void MostrarDato(String dato) {
		JOptionPane.showMessageDialog(null,dato);
	}
	

	}
