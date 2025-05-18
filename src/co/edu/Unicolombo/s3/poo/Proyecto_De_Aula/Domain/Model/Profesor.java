package co.edu.Unicolombo.s3.poo.Proyecto_De_Aula.Domain.Model;

import java.io.Serializable;
import java.util.Date;

public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;

    private int identificacion;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String cargo;
    private String genero;
    private String tipoUsuario;
    private String email;
    private String contrasena;
    private Date nacimiento;

    public Profesor(int identificacion, String nombres, String apellidos, String telefono, String cargo,
            String genero, String tipoUsuario, String email, String contrasena, Date nacimiento) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.cargo = cargo;
        this.genero = genero;
        this.tipoUsuario = tipoUsuario;
        this.email = email;
        this.contrasena = contrasena;
        this.nacimiento = nacimiento;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombres;
    }

    public void setNombre(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    @Override
    public String toString() {
        return "Profesor{"
                + "identificacion=" + identificacion
                + ", nombres='" + nombres + '\''
                + ", apellidos='" + apellidos + '\''
                + ", telefono='" + telefono + '\''
                + ", cargo='" + cargo + '\''
                + ", genero='" + genero + '\''
                + ", tipoUsuario='" + tipoUsuario + '\''
                + ", email='" + email + '\''
                + ", contrasena='" + contrasena + '\''
                + ", nacimiento=" + nacimiento
                + '}';
    }
}
