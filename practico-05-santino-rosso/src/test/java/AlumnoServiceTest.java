import ar.edu.um.Alumno;
import ar.edu.um.AlumnoDao;
import ar.edu.um.AlumnoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class AlumnoServiceTest {

    @Mock
    private AlumnoDao alumnoDao;

    @InjectMocks
    private AlumnoService alumnoService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllAlumnos() {
        Alumno alumno1 = new Alumno(1, "Juan", "Perez");
        Alumno alumno2 = new Alumno(2, "Ana", "Gomez");
        List<Alumno> alumnos = Arrays.asList(alumno1, alumno2);

        when(alumnoDao.leerTodos()).thenReturn(alumnos);

        List<Alumno> result = alumnoService.getAllAlumnos();

        assertEquals(2, result.size());
        assertTrue(result.contains(alumno1));
        assertTrue(result.contains(alumno2));
    }

    @Test
    public void testFindByAlumnoId() {
        Alumno alumno1 = new Alumno(1, "Juan", "Perez");

        when(alumnoDao.leerAlumno(anyInt())).thenReturn(alumno1);

        Alumno result = alumnoService.getAlumnoById(1);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Juan", result.getNombre());
    }



    @Test
    public void testDeleteAlumno() {

        alumnoService.deleteAlumno(1);

        Alumno result = alumnoDao.leerAlumno(1);

        assertNull(result);
    }
}
