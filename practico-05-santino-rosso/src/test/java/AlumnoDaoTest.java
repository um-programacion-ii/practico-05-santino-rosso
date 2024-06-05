import ar.edu.um.Alumno;
import ar.edu.um.AlumnoDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlumnoDaoTest {
    private AlumnoDao alumnoDao;

    @BeforeEach
    public void setUp() {
        alumnoDao = new AlumnoDao();
        alumnoDao.crearAlumno(new Alumno(1, "Juan", "Perez"));
        alumnoDao.crearAlumno(new Alumno(2, "Ana", "Gomez"));
        alumnoDao.crearAlumno(new Alumno(3, "Carlos", "Rodriguez"));
    }

    @Test
    public void testCrearAlumno() {
        Alumno nuevoAlumno = new Alumno(4, "Maria", "Lopez");
        alumnoDao.crearAlumno(nuevoAlumno);
        assertTrue(alumnoDao.leerAlumno(4).equals(nuevoAlumno));
    }

    @Test
    public void testLeerAlumno() {
        Alumno alumno = alumnoDao.leerAlumno(1);
        assertNotNull(alumno);
        assertEquals("Juan", alumno.getNombre());
    }

    @Test
    public void testActualizarAlumno() {
        Alumno alumno = alumnoDao.leerAlumno(1);
        alumno.setNombre("Juanito");
        alumnoDao.actualizarAlumno(alumno);
        assertEquals("Juanito", alumnoDao.leerAlumno(1).getNombre());
    }

    @Test
    public void testEliminarAlumno() {
        alumnoDao.eliminarAlumno(1);
        assertNull(alumnoDao.leerAlumno(1));
    }

    @Test
    void testEliminarAlumnoInexistente() {
        assertDoesNotThrow(() -> {
            alumnoDao.eliminarAlumno(999);
        });
    }

    @Test
    void testLeerAlumnoInexistente() {
        assertDoesNotThrow(() -> {
            Alumno alumno = alumnoDao.leerAlumno(999);
            assertNull(alumno);
        });
    }

    @Test
    void testActualizarAlumnoInexistente() {
        assertDoesNotThrow(() -> {
            Alumno alumnoActualizado = new Alumno(80, "Jorge", "Lopez");
            alumnoDao.actualizarAlumno(alumnoActualizado);
            assertNull(alumnoDao.leerAlumno(80));
        });
    }

}
