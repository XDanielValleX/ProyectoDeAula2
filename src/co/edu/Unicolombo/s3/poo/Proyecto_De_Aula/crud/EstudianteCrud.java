package co.edu.Unicolombo.s3.poo.Proyecto_De_Aula.crud;

import co.edu.Unicolombo.s3.poo.Proyecto_De_Aula.Domain.Model.Estudiante;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteCrud {

    private static final String ARCHIVO_ESTUDIANTES = "AppData/estudiantes.dat";
    private List<Estudiante> estudiantes;
    private int ultimoCodigoAsignado; // Para generar el código secuencial

    public EstudianteCrud() {
        estudiantes = cargarEstudiantes();
        ultimoCodigoAsignado = calcularUltimoCodigo(); // Calcula el último código al cargar
    }

    public int agregarEstudiante(Estudiante estudiante) {
        // Generar el código del estudiante
        int nuevoCodigo = generarNuevoCodigo();
        estudiante.setCodigoEstudiante(nuevoCodigo); // Establecer el código en el objeto Estudiante
        estudiantes.add(estudiante);
        guardarEstudiantes();
        return nuevoCodigo; // Retornar el nuevo código
    }

    public List<Estudiante> obtenerTodos() {
        return new ArrayList<>(estudiantes);
    }

    public Estudiante buscarPorCodigoE(int codigo) {
        for (Estudiante e : estudiantes) {
            if (e.getCodigoEstudiante() == codigo) {
                return e;
            }
        }
        return null;
    }

    public boolean actualizarEstudiante(Estudiante estudianteActualizado) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getCodigoEstudiante() == estudianteActualizado.getCodigoEstudiante()) {
                estudiantes.set(i, estudianteActualizado);
                guardarEstudiantes();
                return true;
            }
        }
        return false;
    }

    public boolean eliminarEstudiante(int id) {
        boolean eliminado = estudiantes.removeIf(e -> e.getCodigoEstudiante() == id);
        if (eliminado) {
            guardarEstudiantes();
        }
        return eliminado;
    }

    // ----------- MÉTODOS PRIVADOS PARA ARCHIVOS -----------
    private void guardarEstudiantes() {
        try {
            File carpeta = new File("AppData");
            if (!carpeta.exists()) {
                carpeta.mkdir();
            }

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_ESTUDIANTES));
            oos.writeObject(estudiantes);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Estudiante> cargarEstudiantes() {
        File archivo = new File(ARCHIVO_ESTUDIANTES);
        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<Estudiante>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>(); // Manejar la excepción y retornar una lista vacía
        }
    }

    private int generarNuevoCodigo() {
        ultimoCodigoAsignado++;
        return ultimoCodigoAsignado;
    }

    private int calcularUltimoCodigo() {
        int maxCodigo = 24023799;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCodigoEstudiante() > maxCodigo) {
                maxCodigo = estudiante.getCodigoEstudiante();
            }
        }
        return maxCodigo;
    }
}
