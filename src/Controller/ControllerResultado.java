package Controller;

import Model.Juego;
import Model.Jugador;
import Views.ViewResultado;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControllerResultado implements ActionListener {
    private Juego juego;
    private Jugador[] jugadores;
    private ViewResultado vistaResultado;
    
    public ControllerResultado(Juego juego){
        this.juego = juego;
        jugadores = juego.getJugadores();
        vistaResultado = new ViewResultado();
        showResultado();
        vistaResultado.getRestart().addActionListener(this);
    }
    
    private void showResultado(){
        JPanel[] paneles = vistaResultado.getPanelJugadores();
        for (int i = 0; i < paneles.length; i++){
            JPanel panel = paneles[i];
            ((JLabel)panel.getComponent(1)).setText(jugadores[i].getNombreJugador());
            ((JLabel)panel.getComponent(3)).setText("Puntos: "+jugadores[i].getPuntos());
            ((JLabel)panel.getComponent(5)).setText("Respuestas correctas: "+jugadores[i].getRespuestasCorrectas());
            ((JLabel)panel.getComponent(7)).setText("Respuestas erroneas: "+jugadores[i].getRespuestasErroneas());
            if (jugadores[i].equals(juego.getGanador())) panel.setBackground(Color.green);
            else panel.setBackground(Color.red);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ControllerUsuarios controlador = new ControllerUsuarios(jugadores[0].getNombreJugador(),jugadores[1].getNombreJugador());
        vistaResultado.dispose();
    }
}
