
package jeopardy;

import Controller.ControllerTablero;
import Controller.ControllerVista;
import Views.ViewTablero;
import Views.ViewUsuarios;
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
        ViewUsuarios usuarioVista = new ViewUsuarios();
        usuarioVista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        usuarioVista.setVisible(true);
        usuarioVista.setTitle("Jeopardy");
        ControllerVista controlador = new ControllerVista(usuarioVista);

        /*ViewTablero tablero = new ViewTablero();
        tablero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tablero.setVisible(true);
        tablero.setSize(new Dimension(900, 500));
        tablero.setTitle("Jeopardy");
        ControllerTablero controlador = new ControllerTablero(tablero);*/
    
        
    } 
}
