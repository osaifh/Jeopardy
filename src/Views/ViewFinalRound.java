package Views;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ViewFinalRound extends JFrame {
    private JPanel[] panelJugadores;
    private JButton go;
    
    public ViewFinalRound(){
        addComponentsToPane(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
        centrarPanel(this);
    }

    public void centrarPanel(JFrame frame){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x,y);
    }
    
    public void addComponentsToPane(Container panel){
        JPanel panelTitulo = new JPanel();
        JLabel titulo = new JLabel("Final Round\n");
        panelTitulo.setPreferredSize(new Dimension(500,40));
        panelTitulo.add(titulo);
        panel.add(panelTitulo,BorderLayout.NORTH);
        panelJugadores = new JPanel[2];
        JPanel panelTurnos = new JPanel();
        panelTurnos.setLayout(new GridLayout(1,2));
        for (int i = 0; i < panelJugadores.length; i++){
            panelJugadores[i] = new JPanel();
            panelJugadores[i].setPreferredSize(new Dimension(200,200));
            panelJugadores[i].add(new JLabel(" "));
            panelTurnos.add(panelJugadores[i]);
        }
        panel.add(panelTurnos,BorderLayout.CENTER);
        go = new JButton("Responder");
        panel.add(go,BorderLayout.SOUTH);
    }
    
    public JButton getBoton(){
        return go;
    }
    
    public JPanel[] getPanelJugadores(){
        return panelJugadores;
    }
    
    public void muestraError(String error){
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
}
