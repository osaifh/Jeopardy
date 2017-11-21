package jeopardy;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumne
 */
public class Preguntas {
    private String[] categorias;
    private HashMap < String , HashMap < Integer , Pregunta > > preguntas;
    private int numeroPreguntas, numeroPreguntasRespondidas;
    public static final int NUMERO_CATEGORIAS = 6;
    public static final int[] VALORES = {100,200,300,400,500};
    
    public Preguntas(){
        categorias = new String[NUMERO_CATEGORIAS];
        preguntas = new HashMap<String,HashMap<Integer,Pregunta>>();
    }
    
    public void entrarPreguntas(){
        for (int i = 0; i < NUMERO_CATEGORIAS; ++i){
            categorias[i] = "deporte";
            try {
                leerCategoria(categorias);
            } catch (IOException ex) {
                Logger.getLogger(Preguntas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void leerCategoria(String[] categoria) throws IOException{
        BufferedReader br = null;
        try {
            Path path = Paths.get(categoria + ".txt");
            br = Files.newBufferedReader(path, java.nio.charset.StandardCharsets.UTF_8);
            for (int i = 0; i < NUMERO_CATEGORIAS; ++i){
                preguntas.put(categoria[i], new HashMap<Integer,Pregunta>());
                Pregunta pregunta;
                String linea;
                String[] datos;
                while ((linea = br.readLine()) != null) {
                    datos = linea.split(";");
                    // me guardo en un array las tres posibles respuestas
                    String[] respuesta = {datos[1], datos[2], datos[3]};
                    //me guardo la posicion del array 0 que es el de las pregunta el array de de respuestas, 
                    //la posicion 4 que es el tipo de respuesta y la posicion que es el valo total de la respuesta
                    pregunta = new Pregunta (datos[0], respuesta, Integer.parseInt(datos[4]), Integer.parseInt(datos[5]));
                }
            }
        }
        catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        }
    }
    
}

