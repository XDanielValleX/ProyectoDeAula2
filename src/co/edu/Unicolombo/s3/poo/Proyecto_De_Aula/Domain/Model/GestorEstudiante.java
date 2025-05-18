package co.edu.Unicolombo.s3.poo.Proyecto_De_Aula.Domain.Model;

import co.edu.Unicolombo.s3.poo.Proyecto_De_Aula.Domain.Model.Estudiante;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorEstudiante {

    private static final String ARCHIVO = "estudiantes.csv";
    private static final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("yyyy-MM-dd"); // Define el formato de fecha
    private static List<Estudiante> estudiantes = new ArrayList<>();

    public static void agregarEstudiante(Estudiante e) {
        estudiantes.add(e);
        guardarEnArchivo();
    }

    public static List<Estudiante> obtenerEstudiantes() {
        return estudiantes;
    }

    public static void cargarDesdeArchivo() {
        estudiantes.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length != 12) {
                    System.err.println("Línea CSV inválida: " + linea);
                    continue; // Saltar la línea si está mal formada
                }
                try {
                    Date nacimiento = FORMATO_FECHA.parse(partes[3]);
                    Estudiante e = new Estudiante(
                            Integer.parseInt(partes[0]),
                            partes[1],
                            partes[2],
                            nacimiento,
                            partes[4],
                            partes[5],
                            partes[6], // ¡No almacenar contraseñas en texto plano!
                            Integer.parseInt(partes[7]),
                            partes[8],
                            partes[9],
                            partes[10],
                            partes[11]
                    );
                    estudiantes.add(e);
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
            for (Estudiante e : estudiantes) {
                pw.println(formatearLineaCSV(e));
            }
        } catch (IOException ex) {
            System.err.println("Error al guardar el archivo: " + ex.getMessage());
        }
    }

    private static String formatearLineaCSV(Estudiante e) {
        StringBuilder sb = new StringBuilder();
        sb.append(e.getCodigoEstudiante()).append(",")
                .append(e.getNombre()).append(",")
                .append(e.getApellidos()).append(",")
                .append(FORMATO_FECHA.format(e.getNacimiento())).append(",")
                .append(e.getEmail()).append(",")
                .append(e.getGenero()).append(",")
                .append(e.getContrasena()).append(",") // ¡No almacenar contraseñas en texto plano!
                .append(e.getIdentificacion()).append(",")
                .append(e.getTelefono()).append(",")
                .append(e.getTipoUsuario()).append(",")
                .append(e.getSemestre()).append(",")
                .append(e.getGrupo());
        return sb.toString();
    }
}
