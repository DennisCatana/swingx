import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Usuario {
    public JPanel rootPanel;
    private JButton salirButton;
    public JTextField datostxt;

    public Usuario(){
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame1;
                frame1 = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                frame1.setVisible(false);

                JFrame frame2 = new JFrame("Login");
                Login ventanaPrincipal = new Login ();
                frame2.setContentPane(ventanaPrincipal.rootPanel);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.pack();
                frame2.setVisible(true);

            }
        });
    }
}
