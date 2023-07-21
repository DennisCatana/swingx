import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Usuario {
    public Container rootPanel;
    private JPanel Usuario;
    private JButton salirButton;

    public Usuario(){
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame1;
                frame1 = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                frame1.setVisible(false);

                JFrame frame2 = new JFrame("Ventana 1");
                Login ventanaPrincipal = new Login ();
                frame2.setContentPane(ventanaPrincipal.rootPanel);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.pack();
                frame2.setVisible(true);

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Usuario");
        frame.setContentPane(new Usuario().Usuario);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
