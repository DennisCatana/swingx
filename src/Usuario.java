import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Usuario {
    public JPanel rootPanel;
    private JButton salirButton;
    private JTextField datostxt;

    public Usuario(){
        Login datos = new Login();
        String usuario = datos.username;
        String contra = datos.password;
        datostxt.setText(usuario + " " + contra);
        System.out.println(usuario + " " + contra);
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
}
