import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class Registro {
    public JPanel rootPanel;
    private JTextField nombreR;
    private JButton registrarseButton;
    private JPasswordField contra;
    private JTextField mensajetxt;
    private JButton INICIARSESIÓNButton;
    private String Nusuario;
    private String Ncontra;

    public Registro() {
        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes implementar la lógica para registrar al usuario
                // Por ahora, simplemente cerraremos la ventana de registro
                datosUsuarios usuarioN = new datosUsuarios();
                Nusuario = nombreR.getText();
                usuarioN.setusuario(Nusuario);
                Ncontra = String.valueOf(contra.getPassword());
                usuarioN.setContrasenia(Ncontra);
                try{
                    FileOutputStream nombreF = new FileOutputStream("USUARIOS.dat",true);
                    ObjectOutputStream obd = new ObjectOutputStream(nombreF);
                    obd.writeObject(usuarioN);
                    mensajetxt.setText("USUARIO REGISTRADO");
                    nombreR.setText("");
                    contra.setText("");
                } catch (FileNotFoundException ex) {
                    System.out.println("NO SE ENCUENTRA EL ARCHIVO " + ex);
                } catch (IOException ex) {
                    System.out.println("NO SE PUDO GUARDAR EL ARCHIVO" +ex);
                }
            }
        });
        INICIARSESIÓNButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame registroFrame = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                registroFrame.setVisible(false);

                JFrame loginframe = new JFrame("Login");
                Login loginventana = new Login();
                loginframe.setContentPane(loginventana.rootPanel);
                loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                loginframe.pack();
                loginframe.setVisible(true);
            }
        });
    }

}
