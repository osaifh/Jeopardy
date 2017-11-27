/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Juego;
import Model.Pregunta;
import Views.ViewPregunta;
import Views.ViewTablero;
import java.awt.event.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import jeopardy.InputFicheros;

/**
 *
 * @author VCMWORK
 */
public class ControllerTablero implements ActionListener {
private ViewTablero vistaTablero;
private ViewPregunta vistaPregunta;
private ControllerPreguntas controllerPreguntas;
private JButton[][] botones;
private Juego juego;

    public ControllerTablero(Juego juego, ViewTablero vistaTablero) {
        this.juego = juego;
        this.vistaTablero = vistaTablero;
        botones = vistaTablero.getBotones();
        for (int i = 0; i < botones.length; i++){
            for (int j = 0; j < botones[i].length; j++){
                botones[i][j].addActionListener(this);
            }
        }
    }
    
    
    public void actionPerformed(ActionEvent ae) {
       String[] codigo = ((JButton)ae.getSource()).getName().split(":");
       int x = Integer.parseInt(codigo[1]);
       int y = Integer.parseInt(codigo[3]);
        Pregunta pregunta = juego.getPregunta(x, y);
        ControllerPreguntas contPreg = new ControllerPreguntas(pregunta,this);
        ((JButton)ae.getSource()).setEnabled(false);
    }

    public void responderPregunta(Pregunta pregunta, int respuesta){
        juego.preguntaRespondida(pregunta, respuesta);
    }
}
