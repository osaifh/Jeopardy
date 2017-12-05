
package Controller;

import Model.Juego;
import Model.Pregunta;
import Views.ViewPregunta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class ControllerPreguntas implements ActionListener {
    private Pregunta pregunta;
    private IControllerPrincipal controllerPrincipal;
    private ViewPregunta viewPregunta;
    private Juego juego;
    private Timer timer;
    private ActionListener taskPerformer = (ActionEvent e) -> {
        viewPregunta.dispose();
        controllerPrincipal.finDeTurno();
        timer.stop();
    };
    
    public ControllerPreguntas(Pregunta preguntaModel, IControllerPrincipal controllerPrincipal, Juego juego) {
        timer = new Timer(3000,taskPerformer);
        this.pregunta = preguntaModel;
        this.controllerPrincipal = controllerPrincipal;
        viewPregunta = new ViewPregunta(preguntaModel);
        viewPregunta.getBotonRespuesta().addActionListener(this);
        this.juego = juego;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (viewPregunta.respuestaSeleccionada()){
            int respSelec = viewPregunta.getRespuestaSeleccionada();
            if (juego.preguntaRespondida(pregunta, respSelec)){
                viewPregunta.cambiarColorVerde(respSelec);
            }
            else {
                viewPregunta.cambiarColorVerde(pregunta.getRespuestaCorrecta());
                viewPregunta.cambiarColorRojo(respSelec);
            }
            viewPregunta.getBotonRespuesta().setEnabled(false);
            timer.start();
        } else {
            viewPregunta.muestraError("No se ha seleccionado ninguna respuesta");
        }
    }
    
}
