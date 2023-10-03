package co.edu.unbosque.view;

import java.awt.Image;

import javax.swing.*;


public class View {
	
	
	    private JFrame frame;
	    private Fondo fondo;
	    
	    public View() {
	    	
	    	frame = new JFrame("Mix Composer");
	        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Establece el JFrame en modo pantalla completa
	        frame.setUndecorated(true); // Elimina la barra de título y bordes
	        frame.setResizable(false); // Evita que el usuario redimensione la ventana
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        // Configura el JPanel de fondo
	        fondo = new Fondo();
	        frame.setContentPane(fondo);
	        
	        // Configura otros componentes y lógica de la vista aquí
	        
	        frame.setVisible(true);
	        
	        
	        
	    }
    
    
    
	public void mostrarBienvenida() {
 		
		 JLabel imagen = new JLabel();
		 imagen.setBounds(0, 0, 350, 320);
		 
  	   Image img = new ImageIcon("recursos/dj.gif").getImage();
  	 
   
       ImageIcon icono_redimencionado =new ImageIcon(img.getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT)); 
       
       
       Icon icono = icono_redimencionado; //lo pasamos a icon para que lo pueda reconocer el joptionpane
       
       imagen.setIcon(icono);                                                  //El Scale_Default se pone obligatoriamente para un gif
      
       String mensaje = "<html><body><p style='font-size:29px;'>Compositor de Reguetón</p>" +
               "<br><br><br><br><br><br><br><br><span style='font-size:18px;'>Saquemos el perreo interior que tienes, B)</span></body></html>";
       
       JOptionPane.showMessageDialog(null, mensaje, "Bienvenido Dj promedio latinoamericano", JOptionPane.PLAIN_MESSAGE, icono);
  	 
	}
	
	
	
	public void message(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	public String pedirNombreCancion() {
		return JOptionPane.showInputDialog(null, "Digite el nombre de la canción:");
	}
	
	public int pedirNumero(String msg) {
		return Integer.parseInt(JOptionPane.showInputDialog(null, msg));
	} 
	
	public int mostrarOpciones() {
        String[] opciones = {"Componer Cancion de reguetón","Crear canción", "Buscar canción creada", "Salir"};
        
        JLabel imagen = new JLabel();
		 imagen.setBounds(0, 0, 350, 320);
		 
 	   Image img = new ImageIcon("recursos/dj_2.gif").getImage();
 	 
  
       ImageIcon icono_redimencionado =new ImageIcon(img.getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT)); 
      
      
       Icon icono = icono_redimencionado; 
      
       imagen.setIcon(icono);                                                 
      
        return JOptionPane.showOptionDialog(null, "<html><body><p style='font-size:29px;'>Vamos Mani elije la opcion que desees<br><br><br> Mi futuro DJ del perreo intenso B)</br></body></html>", "Menú para el DJ Insano que tengo al frente",
                                            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                                            icono, opciones, opciones[0]);
    }
	
    
	public void mostrarDespedida() {
 		
		 JLabel imagen = new JLabel();
		 imagen.setBounds(0, 0, 350, 320);
		 
 	   Image img = new ImageIcon("recursos/gato_dj.gif").getImage();
 	 
  
      ImageIcon icono_redimencionado =new ImageIcon(img.getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT)); 
      
      
      Icon icono = icono_redimencionado; //lo pasamos a icon para que lo pueda reconocer el joptionpane
      
      imagen.setIcon(icono);                                                  //El Scale_Default se pone obligatoriamente para un gif
     
      String mensaje = "<html><body><p style='font-size:29px;'>Nos vemos en otra ocasión manito</p>" +
              "<br><br><br><br><br><br><br><br><span style='font-size:18px;'>Chao parce, :D</span></body></html>";
      
      JOptionPane.showMessageDialog(null, mensaje, "Despedida para un gran Dj", JOptionPane.PLAIN_MESSAGE, icono);
 	 
	}
	
	
}
