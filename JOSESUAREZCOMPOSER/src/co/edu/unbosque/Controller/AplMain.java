package co.edu.unbosque.Controller;

import co.edu.unbosque.Model.*;
import co.edu.unbosque.View.*;

public class AplMain {
 public static void main(String[] args) {
     CancionModel model = new CancionModel();
     CancionVista view = new CancionVista();
     CancionController controller = new CancionController(view, model);
     controller.iniciar();
 }
}
