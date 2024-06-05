package ar.edu.um;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AlumnoDao {
    private Set<Alumno> alumnos;

    public AlumnoDao() {
        alumnos = new HashSet<>();
    }

    public void crearAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public Alumno leerAlumno(int id) {
        for (Alumno alumno : alumnos) {
            if (alumno.getId() == id) {
                return alumno;
            }
        }
        System.out.println("No existe el alumno");
        return null;
    }

    public void actualizarAlumno(Alumno alumno) {
        if (leerAlumno(alumno.getId()) != null){
            alumnos.remove(leerAlumno(alumno.getId()));
            alumnos.add(alumno);
        }
    }

    public void eliminarAlumno(int id) {
        if (leerAlumno(id) != null){
            alumnos.remove(leerAlumno(id));
        }
    }

    public List<Alumno> leerTodos(){
        List<Alumno> listAlumnos = new ArrayList<>();
        for (Alumno alumno : alumnos) {
            listAlumnos.add(alumno);
        }
        return listAlumnos;
    }
}
