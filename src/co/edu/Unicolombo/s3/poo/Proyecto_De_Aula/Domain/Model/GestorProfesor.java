package co.edu.Unicolombo.s3.poo.Proyecto_De_Aula.Domain.Model;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorProfesor {

    private static final String ARCHIVO = "profesores.csv";
    private static final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("yyyy-MM-dd");
    private static List<Profesor> profesores = new ArrayList<>();

    public static void agregarProfesor(Profesor p) {
        profesores.add(p);
        guardarEnArchivo();
    }

    public static List<Profesor> obtenerProfesores() {
        return profesores;
    }

    public static void cargarDesdeArchivo() {
        profesores.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length != 10) {
                    System.err.println("Línea CSV inválida: " + linea);
                    continue;
                }
                try {
                    Date nacimiento = FORMATO_FECHA.parse(partes[9]);
                    Profesor p = new Profesor(
                            Integer.parseInt(partes[0]), // identificacion
                            partes[1], // nombres
                            partes[2], // apellidos
                            partes[3], // telefono
                            partes[4], // cargo
                            partes[5], // genero
                            partes[6], // tipoUsuario
                            partes[7], // email
                            partes[8], // contrasena
                            nacimiento // nacimiento
                    );
                    profesores.add(p);
                } catch (ParseException | NumberFormatException ex) {
                    System.err.println("Error al parsear línea CSV: " + linea + ", Error: " + ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo: " + ex.getMessage());
        }
    }

    private static void guardarEnArchivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO))) {
            for (Profesor p : profesores) {
                pw.println(formatearLineaCSV(p));
            }
        } catch (IOException ex) {
            System.err.println("Error al guardar el archivo: " + ex.getMessage());
        }
    }

    private static String formatearLineaCSV(Profesor p) {
        StringBuilder sb = new StringBuilder();
        sb.append(p.getIdentificacion()).append(",")
                .append(p.getNombre()).append(",")
                .append(p.getApellidos()).append(",")
                .append(p.getTelefono()).append(",")
                .append(p.getCargo()).append(",")
                .append(p.getGenero()).append(",")
                .append(p.getTipoUsuario()).append(",")
                .append(p.getEmail()).append(",")
                .append(p.getContrasena()).append(",")
                .append(FORMATO_FECHA.format(p.getNacimiento()));
        return sb.toString();
    }
}
