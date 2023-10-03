package co.edu.unbosque.view;

import java.util.Scanner;

public class ComposerView {
    public void mostrarCancion(String cancion) {
        System.out.println("Canción generada:\n");
        System.out.println(cancion);
    }

    public int pedirNumeroEstrofas() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el número de estrofas: ");
        return scanner.nextInt();
    }

    public int pedirNumeroFrasesPorEstrofa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el número de frases por estrofa: ");
        return scanner.nextInt();
    }
}
