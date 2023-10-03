package co.edu.unbosque.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public  class Fondo extends JPanel{

         private static final long serialVersionUID = 1L;
         
         

       @Override
       public void paintComponent(Graphics img)	{ // se hace un metodo no retornable donde se le asigna que es tipo graphics y tiene como nombre img



       Image fondo = new ImageIcon("Recursos/Fondo.gif").getImage(); //se crea un objeto de fondo tipo imagen para el llamado del gif


  img.drawImage(fondo, 0, 0, getWidth(),getHeight(), this/* el this es obligatorio para este caso ya que indicamos que es esta clase para que se ver la animacion del gif */ ); 


// el drawaImage es de la parte Graphics que se llama con img que fue el nombre asigando para esta, donde ayudara para asignarle las dimensiones 


          setOpaque(false); // para que sea tranparente y se pueda vizualisar la imagen

         super.paintComponent(img); // pintara con los parametros que le dimos

     } 
}
