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
import javax.swing.JButton;

/**
 *
 * @author VCMWORK
 */
public class ControllerTablero implements ActionListener {
private ViewTablero vistaTablero;
private ViewPregunta vistaPregunta;
private ControllerPreguntas controllerPreguntas;
private Pregunta pregunta;

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println(((JButton)ae.getSource()).getName());
        
        //ControllerPreguntas contPreg = new ControllerPreguntas();
        
    }

    public ControllerTablero(ViewTablero vistaTablero) {
        this.vistaTablero = vistaTablero;
        JButton[][] botones = vistaTablero.getBotones();
        for (int i = 0; i < botones.length; i++){
            for (int j = 0; j < botones[i].length; j++){
                botones[i][j].addActionListener(this);
            }
        }
    }

    
}
