package co.edu.unbosque.controller;
import co.edu.unbosque.model.persistence.*;
import co.edu.unbosque.view.*;
public class AplMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Propiedades modelo = new Propiedades();
        View vista = new View();
        Controller controlador = new Controller(modelo, vista);

      
	}

}
