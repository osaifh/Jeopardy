
package jeopardy;


import Controller.ControllerVista;

import Views.ViewUsuarios;
import javax.swing.*;

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

    } 
}
