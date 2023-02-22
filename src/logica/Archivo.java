package logica;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class Archivo {
    private String ruta;
    private String palabra;
    private int total;

    private int globalTotal;

    public Archivo(String ruta, String palabra) {
        this.ruta = ruta;
        this.palabra = palabra;
    }

    public int getGlobalTotal() {
        return globalTotal;
    }

    public void buscar() {
        ArrayList<File> files = new ArrayList<>();
        String linea;
        BufferedReader bfr = null;
        String extension = "";
        File folder = new File(ruta);
        try {
            for (File f : folder.listFiles()) {
                if (!f.isDirectory() && f.getName().endsWith(".txt") || f.getName().endsWith(".xml") || f.getName().endsWith(".json") || f.getName().endsWith(".csv")) {
                    files.add(f);
                } else {
                    System.out.println("El archivo no tiene un formato válido");
                }
            }
        } catch (NullPointerException e) {
            System.out.println("La carpeta proporcionada no existe.");
        }


        for (File file : files) {

            try {
                FileReader fr = new FileReader(file);
                bfr = new BufferedReader(fr);

                while ((linea = bfr.readLine()) != null) {

                    /*
                    IDEA QUE NO FUNCIONÓ PARA EVITAR EL PROBLEMA DE CONTAINS
                    while(linea.indexOf(palabra) > -1){
                        linea = linea.substring(linea.indexOf(palabra)+palabra.length(), linea.length());
                        total += 1;
                    }*/

                    /**
                     * Bug en el método constraint:
                     * Cuando encuentra la palabra en una línea, salta a la siguiente sin revisar
                     * el resto de la línea.
                     * Además toma substrings como palabras buscadas. Ejemplo: comparar.
                     * */
                    if (linea.contains(palabra)) {
                        total += 1;
                    }
                }

                System.out.println(file.getName() + "\t" + total + " veces");

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (NullPointerException e) {
                System.out.println(e.getMessage() + "No ha seleccionado ningún archivo");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            globalTotal += total;
            total = 0;

        }
    }

    @Override
    public String toString() {
        return "Archivo{" +
                "ruta='" + ruta + '\'' +
                ", palabra='" + palabra + '\'' +
                ", total=" + total +
                '}';
    }
}
