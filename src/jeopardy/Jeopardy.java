package jeopardy;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author VCMWORK
 */
public class Jeopardy {
    static ArrayList<Pregunta> preguntas;
    
    public static void main(String[] args) throws IOException {
        preguntas = InputFicheros.leerPreguntas("Deporte");
    }

}
