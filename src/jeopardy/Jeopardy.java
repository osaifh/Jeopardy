
package jeopardy;

import Controller.ControllerTablero;
import Model.Juego;
import Model.Jugador;
import Views.ViewTablero;
import java.awt.Dimension;
import javax.swing.*;

/*import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;*/ 

/**
 *
 * @author VCMWORK
 */
public class Jeopardy {

    // private static final String nombreFichero="Deporte";

    public static void main(String[] args) {
        ViewTablero tablero = new ViewTablero();
        tablero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tablero.setVisible(true);
        tablero.setSize(new Dimension(900, 500));
        tablero.setTitle("Jeopardy");
        Jugador[] jugadores = new Jugador[2];
        jugadores[0] = new Jugador("Test");
        jugadores[1] = new Jugador("Test");
        Juego juego = new Juego(jugadores);
        ControllerTablero controlador = new ControllerTablero(juego,tablero);
    } 
}
