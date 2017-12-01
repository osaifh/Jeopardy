package Views;

import Controller.ControllerTablero;
import Model.Juego;
import Model.Jugador;
import Model.Pregunta;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class ViewTablero extends JFrame {

    public JLabel[] categoryNames = new JLabel[6];
    public JButton[][] buttonArray = new JButton[6][5];
    private ControllerTablero controlador;
    private Pregunta preg;
    private JLabel[] infoPartida;
    //[0] = jugador1
    //[1] = puntuacio1
    //[2] = contador Turnos
    //[3] = jugador2
    //[4] = puntuacio2
    public ViewTablero() {
        //setLayout(new GridLayout(6, 5));
        addComponentsToPane(this);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    private void addComponentsToPane(Container panel) {
        //panel jugadores 
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        
        JPanel jugadoresPanel = new JPanel();
        //    GridBagConstraints c = new GridBagConstraints();
        jugadoresPanel.setLayout(new BoxLayout(jugadoresPanel, BoxLayout.X_AXIS));
        jugadoresPanel.setBackground(Color.yellow);
        infoPartida = new JLabel[5];
        for (int i = 0; i < infoPartida.length; i++) {
            infoPartida[i] = new JLabel(" ");
            infoPartida[i].setBackground(Color.yellow);
            
            jugadoresPanel.setBorder(border);
            if (i == 0) jugadoresPanel.add(Box.createRigidArea(new Dimension(300,0)));
            if (i == 1) jugadoresPanel.add(Box.createRigidArea(new Dimension(10,0)));
            if (i == 4) jugadoresPanel.add(Box.createRigidArea(new Dimension(10,0)));



            jugadoresPanel.add(infoPartida[i]);
            if (i == 1) jugadoresPanel.add(Box.createHorizontalGlue());
            if (i == 2) jugadoresPanel.add(Box.createHorizontalGlue());
            if (i == 4) jugadoresPanel.add(Box.createRigidArea(new Dimension(300,0)));

            
        }

        panel.add(jugadoresPanel, BorderLayout.NORTH);

        String[] nombreBoton = new String[5];
        for (int i = 0; i < nombreBoton.length; ++i) {
            nombreBoton[i] = "" + Juego.PUNTUACIONES[i];
        }
        String[] categoriaNombre = Juego.CATEGORIAS;


        // panel categorias
        JPanel panelCategoarios = new JPanel();
        panelCategoarios.setLayout(new GridLayout(6, 5));

        for (int i = 0; i < categoriaNombre.length; ++i) {
            JLabel categoria = new JLabel(categoriaNombre[i]);
            categoria.setHorizontalAlignment(SwingConstants.CENTER);
            categoria.setBorder(border);
            panelCategoarios.add(categoria);
        }

        for (int i = 0; i < buttonArray[0].length; ++i) {
            for (int j = 0; j < buttonArray.length; ++j) {
                buttonArray[j][i] = new JButton(nombreBoton[i]);
                buttonArray[j][i].setSize(150, 100);
                buttonArray[j][i].setName("x:" + j + ":y:" + i);
                panelCategoarios.add(buttonArray[j][i], BorderLayout.CENTER);
            }
        }
        panel.add(panelCategoarios, BorderLayout.CENTER);
    }

    public JButton[][] getBotones() {
        return buttonArray;
    }

    public JLabel[] getLabels() {
        return infoPartida;
    }

}
