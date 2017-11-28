package jeopardy;

import Controller.ControllerUsuarios;
import Views.ViewUsuarios;
import javax.swing.*;

public class Jeopardy {
    public static void main(String[] args) {
        ViewUsuarios usuarioVista = new ViewUsuarios();
        usuarioVista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        usuarioVista.setVisible(true);
        usuarioVista.setTitle("Jeopardy");
        ControllerUsuarios controlador = new ControllerUsuarios(usuarioVista);
    } 
    
}
