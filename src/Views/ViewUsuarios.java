
package Views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;


public class ViewUsuarios extends JFrame{
    private JLabel userL1;
    private JTextField user1;
    private JLabel userL2;
    private JTextField user2;
    private JButton ok;
    
    public ViewUsuarios(){
        this.setTitle("Jeopardy");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(this.getContentPane());
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
    }
    
    public JButton getBoton(){
        return ok;
    }
    
    private void addComponentsToPane(Container panel) {
        BoxLayout boxuser = new BoxLayout(panel, BoxLayout.Y_AXIS);
        //panel.setPreferredSize(new Dimension(400,300));
           userL1 = new JLabel("Jugador 1: ");
        userL2 = new JLabel("Jugador 2: ");
        user1 = new JTextField();
        user1.setPreferredSize(new Dimension(400,25));
        
        user2 = new JTextField();
                user2.setPreferredSize(new Dimension(400,25));

        ok = new JButton("ok");
        panel.setLayout(boxuser);
        userL1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(userL1);
        user1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(user1);
        userL2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(userL2);
        user2.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(user2);
        ok.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(ok);
        /*panel.setPreferredSize(new Dimension(480,480));
        GridLayout gridVista = new GridLayout(5,1);
        JPanel panelUsarios = new JPanel();
        panelUsarios.setLayout(gridVista);
        JPanel text1 = new JPanel();
        JPanel text2 = new JPanel();

        
        userL1 = new JLabel("Jugador 1: ");
        userL2 = new JLabel("Jugador 2: ");
        user1 = new JTextField();
        user1.setPreferredSize(new Dimension(400,25));
        user2 = new JTextField();
        user2.setPreferredSize(new Dimension(400,25));

        ok = new JButton("ok");
        panelUsarios.add(userL1);
        text1.add(user1);
        panelUsarios.add(text1);
        panelUsarios.add(userL2);
        text2.add(user2);
        panelUsarios.add(text2);
        panelUsarios.add(ok);
        panel.add(panelUsarios);*/
    }

    public String[] obtenerNombreUsuarios() {
        String[] nombre = new String[2];
        nombre[0] = user1.getText();
        nombre[1] = user2.getText();
        if (nombre[0].equals(null) || nombre[1].equals(null)) {
            System.out.println("Error: los dos campos han de estar llenos");
        } else {
            return nombre;
        }
        return nombre;
    }
    
    public void muestraError(String error){
        JOptionPane.showMessageDialog(null,error,"Error",JOptionPane.ERROR_MESSAGE);
    }
}
