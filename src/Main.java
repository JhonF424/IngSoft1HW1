import logica.Archivo;
import logica.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Menu menu= new Menu();

        Archivo file = menu.ShowMenu();

        file.buscar();
        System.out.println("Total:\t\t" + file.getGlobalTotal() + " veces");
    }


}