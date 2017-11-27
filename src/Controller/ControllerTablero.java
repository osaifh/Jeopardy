/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
private Pregunta pregunta;
private JButton[][] botones;
private ArrayList<Pregunta> listaPreguntas;

    public ControllerTablero(ViewTablero vistaTablero) {
        this.vistaTablero = vistaTablero;
        botones = vistaTablero.getBotones();
        for (int i = 0; i < botones.length; i++){
            for (int j = 0; j < botones[i].length; j++){
                botones[i][j].addActionListener(this);
            }
        }
        try {
            listaPreguntas = InputFicheros.leerPreguntas("Deporte");
        } catch (IOException ex) {
            Logger.getLogger(ControllerPreguntas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        System.out.println("bsdflisdf");
        System.out.println(((JButton)ae.getSource()).getName());
        pregunta = listaPreguntas.get(0);
        
        //ViewPregunta viewP = new ViewPregunta(pregunta);
        ControllerPreguntas contPreg = new ControllerPreguntas(pregunta,this);
        
    }

    public void responderPregunta(Pregunta pregunta, int respuesta){
        
    }
}
