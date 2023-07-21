import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Login {

    private JTextField usuario;
    private JButton iniciarSesionButton;
    private JButton registrarseButton;
    private JPasswordField contra;
    JPanel rootPanel;

    public Login() {
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verificar las credenciales (aquí deberías implementar tu lógica de autenticación)
                String username = usuario.getText();
                String password = new String(contra.getPassword());

                if (isValidCredentials(username, password)) {
                    // Si las credenciales son válidas, ocultar el frame actual
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                    frame.setVisible(false);

                    // Mostrar el frame de usuario
                    JFrame userFrame = new JFrame("Usuario");
                    Usuario userPanel = new Usuario();
                    userFrame.setContentPane(userPanel.rootPanel);
                    userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    userFrame.pack();
                    userFrame.setVisible(true);
                } else {
                    // Mostrar mensaje de error de credenciales inválidas
                    JOptionPane.showMessageDialog(rootPanel, "Credenciales inválidas. Inténtalo de nuevo.");
                }
            }
        });

        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana actual de login
                JFrame loginFrame = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                loginFrame.setVisible(false);

                // Abrir la ventana de registro
                JFrame registroFrame = new JFrame("Registro");
                Registro registroVentana = new Registro();
                registroFrame.setContentPane(registroVentana.rootPanel);
                registroFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                registroFrame.pack();
                registroFrame.setVisible(true);
            }
        });
    }

    // Credenciales
    private boolean isValidCredentials(String username, String password) {
        return !username.isEmpty() && !password.isEmpty();
    }

    private static Login instanciaLogin; // Variable estática para almacenar la única instancia de Login

    public static Login getInstancia() {
        if (instanciaLogin == null) {
            instanciaLogin = new Login();
        }
        return instanciaLogin;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Login");
                frame.setContentPane(new Login().rootPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
