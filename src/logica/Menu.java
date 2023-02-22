package logica;

import java.util.Scanner;

public class Menu {

    private String ruta;
    private String palabra;

    public Menu() {}

    public Archivo ShowMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("Por favor ingrese la ruta en donde están los archivos");
        String ruta = in.nextLine();
        System.out.println("Ahora ingrese la palabra que desea buscar y contar en los archivos");
        String palabra = in.nextLine();
        return new Archivo(ruta, palabra);
    }

}
