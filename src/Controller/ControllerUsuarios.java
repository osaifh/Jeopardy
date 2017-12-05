package Controller;

import Model.Juego;
import Model.Jugador;
import Views.ViewTablero;
import Views.ViewUsuarios;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ControllerUsuarios implements ActionListener{
    private ViewUsuarios vistaUsuarios;
    private Jugador[] usuarios = new Jugador[2];
    
    public ControllerUsuarios(ViewUsuarios vistaUsuarios) {
        this.vistaUsuarios = vistaUsuarios;
        vistaUsuarios.getBoton().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String usuario1 = vistaUsuarios.obtenerNombreUsuarios()[0];
        String usuario2 = vistaUsuarios.obtenerNombreUsuarios()[1];
        if (usuario1.isEmpty() || usuario2.isEmpty()){
            vistaUsuarios.muestraError("Datos incompletos");
        }
        else if (usuario1.equals(usuario2)){
            vistaUsuarios.muestraError("Nombres iguales");
        }
        else {
            usuarios[0] = new Jugador(usuario1);
            usuarios[1] = new Jugador(usuario2);
            Juego juego = new Juego(usuarios);
            ViewTablero tablero = new ViewTablero();
            tablero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            tablero.setVisible(true);
            tablero.setSize(new Dimension(900, 500));
            tablero.setTitle("Jeopardy");
            ControllerTablero contTablero = new ControllerTablero(juego,tablero);
            vistaUsuarios.dispose(); 
        }
    }
    
}
