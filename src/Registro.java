import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro {
    public Container rootPanel;
    private JPanel Registro; // Corrección en el nombre de la variable registro

    private JTextField nombreR;
    private JButton registrarseButton;
    private JPasswordField contra;

    public Registro() {
        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Utiliza la variable rootPanel declarada como miembro de la clase
                JFrame frame1 = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                frame1.setVisible(false);

                JFrame frame2 = new JFrame("Login");
                Login ventanaPrincipal = new Login();
                frame2.setContentPane(ventanaPrincipal.rootPanel);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.pack();
                frame2.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Registro");
        frame.setContentPane(new Registro().Registro); // Corrección en el nombre de la variable registro
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
