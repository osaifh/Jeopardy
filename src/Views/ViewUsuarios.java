
package Views;

import java.awt.Container;
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
        GridLayout gridVista = new GridLayout(1,3);
        JPanel panelUsarios = new JPanel();
         panelUsarios.setLayout(gridVista);

        userL1 = new JLabel("Jugador 1: ");
        userL2 = new JLabel("Jugador 2: ");
        user1 = new JTextField();
        user2 = new JTextField();
        ok = new JButton("ok");
        panelUsarios.add(userL1);
        panelUsarios.add(user1);
        panelUsarios.add(userL2);
        panelUsarios.add(user2);
        panelUsarios.add(ok);
        panel.add(panelUsarios);
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

}

