package ar.edu.um;

import java.util.List;

public class AlumnoService {
    private AlumnoDao alumnoDao;

    public AlumnoService(AlumnoDao alumnoDao) {
        this.alumnoDao = alumnoDao;
    }

    public List<Alumno> getAllAlumnos() {
        return alumnoDao.leerTodos();
    }

    public Alumno getAlumnoById(int alumnoId) {
        return alumnoDao.leerAlumno(alumnoId);
    }

    public void addAlumno(Alumno alumno) {
        alumnoDao.crearAlumno(alumno);
    }

    public void updateAlumno(Alumno alumno) {
        alumnoDao.actualizarAlumno(alumno);
    }

    public void deleteAlumno(Integer alumnoId) {
        alumnoDao.eliminarAlumno(alumnoId);
    }
}
