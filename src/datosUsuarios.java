import java.io.Serializable;

public class datosUsuarios implements Serializable {
    private String usuario;
    private String contrasenia;

    public datosUsuarios(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public String getusuario() {
        return usuario;
    }

    public void setusuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public datosUsuarios() {
    }
}
