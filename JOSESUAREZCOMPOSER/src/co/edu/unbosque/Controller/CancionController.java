package co.edu.unbosque.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import co.edu.unbosque.Model.*;
import co.edu.unbosque.View.*;

public class CancionController {
    private CancionVista view;
    private CancionModel model;

    public CancionController(CancionVista view, CancionModel model) {
        this.view = view;
        this.model = model;

        view.setComponerCancionListener(new ComponerCancionListener());
        view.setGuardarCancionListener(new GuardarCancionListener());
        view.setAbrirCancionListener(new AbrirCancionListener());
    }

    public void iniciar() {
        view.mostrarVentana();
    }

    private class ComponerCancionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            model.setNumeroEstrofas(10);
            model.setNumeroFrasesPorEstrofa(4); 

            
            String cancion = model.componerCancion();
            view.mostrarCancion(cancion);
        }
    }

    private class GuardarCancionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            File archivo = view.mostrarDialogoGuardar();
            if (archivo != null) {
                try {
                    String contenido = view.mostrarCancion(); 
                    model.guardarCancionEnArchivo(archivo.getAbsolutePath(), contenido);
                } catch (IOException ex) {
                 
                    ex.printStackTrace();
                }
            }
        }
    }


    private class AbrirCancionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            File archivo = view.mostrarDialogoAbrir();
            if (archivo != null) {
                try {
                    String contenido = model.cargarCancionDesdeArchivo(archivo.getAbsolutePath());
                    view.mostrarCancion(contenido);
                } catch (IOException ex) {
                 
                    ex.printStackTrace();
                }
            }
        }
    }

 
}
