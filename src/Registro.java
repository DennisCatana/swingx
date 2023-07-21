import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro {
    public JPanel rootPanel;
    private JTextField nombreR;
    private JButton registrarseButton;
    private JPasswordField contra;

    public Registro() {
        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomUsuario = nombreR.getText();
                String contUsuario = new String(contra.getPassword());
                JFrame registroFrame = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                registroFrame.dispose();

                try (ObjectOutputStream outputStream = new ObjectOutputStream
                    (new FileOutputStream(nomUsuario + ".dat"))) {
                    Datos userData = new Datos(nomUsuario, contUsuario);
                    outputStream.writeObject(userData);

                    JFrame registro = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                    registro.dispose();
                    // Mostrar el frame de login nuevamente
                    JFrame loginFrame = new JFrame("Login");
                    Login loginVentana = new Login();
                    loginFrame.setContentPane(loginVentana.rootPanel);
                    loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    loginFrame.pack();
                    loginFrame.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    // Mostrar mensaje de error al guardar los datos
                    JOptionPane.showMessageDialog(rootPanel, "Error al guardar los datos");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Registro");
                frame.setContentPane(new Registro().rootPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }

        });
    }
    private static class Datos implements Serializable {
        private String name;
        private String password;

        public Datos(String username, String password) {
            this.name = username;
            this.password = password;
        }
    }

}

