package co.edu.Unicolombo.s3.poo.Proyecto_De_Aula.crud;

import co.edu.Unicolombo.s3.poo.Proyecto_De_Aula.Domain.Model.Profesor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesorCrud {

    private static final String ARCHIVO_PROFESORES = "AppData/profesores.dat";
    private List<Profesor> profesores;

    public ProfesorCrud() {
        profesores = cargarProfesores();
    }

    public void agregarProfesor(Profesor profesor) {
        profesores.add(profesor);
        guardarProfesores();
    }

    private void guardarProfesores() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_PROFESORES))) {
            oos.writeObject(profesores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Profesor> cargarProfesores() {
        File archivo = new File(ARCHIVO_PROFESORES);
        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<Profesor>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Profesor> obtenerTodos() {
        return profesores;
    }
}
