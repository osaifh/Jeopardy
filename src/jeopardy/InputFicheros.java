
package jeopardy;

import Model.Pregunta;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class InputFicheros {

    public static HashMap<String, HashMap<Integer, Pregunta>> leerPreguntas(String[] categorias) {
        HashMap<String, HashMap<Integer, Pregunta>> preguntas = new HashMap<String, HashMap<Integer, Pregunta>>();
        for (String categoria : categorias) {
            preguntas.put(categoria, leerCategoria(categoria));
        }
        return preguntas;
    }

    public static HashMap<Integer, Pregunta> leerCategoria(String categoria) {
        HashMap<Integer, Pregunta> preguntasCategoria = new HashMap<Integer, Pregunta>();
        Path path = Paths.get("Categorias/" + categoria + ".txt");
        BufferedReader br = null;
        try {
            br = Files.newBufferedReader(path, java.nio.charset.StandardCharsets.UTF_8);
            Pregunta preguntas;
            String linea;
            String[] datos;
            int i = 0;
            while ((linea = br.readLine()) != null) {
                datos = linea.split(";");
                String[] respuesta = {datos[1], datos[2], datos[3]};// me guardo en un array las tres posibles respuestas
                preguntas = new Pregunta(datos[0], respuesta, Integer.parseInt(datos[4]), Integer.parseInt(datos[5]));//me guardo la posicion del array 0 que es el de las preguntas el array de de respuestas, la posicion 4 que es el tipo de respuesta y la posicion que es el valo total de la respuesta
                preguntasCategoria.put(preguntas.getValorRespuesta(), preguntas);
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                    //no such file exception
                } catch (IOException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
            return preguntasCategoria;
        }
    }
    
}
