package co.edu.Unicolombo.s3.poo.Proyecto_De_Aula.Domain.Model;

import java.io.Serializable;
import java.util.Date;

public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L; // Agregar serialVersionUID
    private int codigoEstudiante;
    private String nombres;
    private String apellidos;
    private Date nacimiento;
    private String email;
    private String genero;
    private String contrasena;
    private int identificacion;
    private String telefono;
    private String tipoUsuario;
    private String semestre;
    private String grupo;

    public Estudiante(int codigoEstudiante, String nombres, String apellidos, Date nacimiento, String email,
            String genero, String contrasena, int identificacion, String telefono,
            String tipoUsuario, String semestre, String grupo) {
        this.codigoEstudiante = codigoEstudiante;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.email = email;
        this.genero = genero;
        this.contrasena = contrasena;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
        this.semestre = semestre;
        this.grupo = grupo;
    }

    public int getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(int codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getNombre() {
        return nombres;
    }

    public void setNombre(String nombre) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "codigoEstudiante=" + codigoEstudiante + ", nombres=" + nombres + ", apellidos=" + apellidos + ", nacimiento=" + nacimiento + ", email=" + email + ", genero=" + genero + ", contrasena=" + contrasena + ", identificacion=" + identificacion + ", telefono=" + telefono + ", tipoUsuario=" + tipoUsuario + ", semestre=" + semestre + ", grupo=" + grupo + '}';
    }
}
