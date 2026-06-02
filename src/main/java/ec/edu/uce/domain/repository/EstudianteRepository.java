package ec.edu.uce.domain.repository;

import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.domain.model.Estudiante;

public interface EstudianteRepository {

    //CRUD
    public void create(Estudiante estudiante);
    public Estudiante selectById(Integer id);
    public void update(Estudiante estudiante);
    public void deleteById(Integer id);

    public List<Estudiante> selectAll();
    public List<Estudiante> selectByNombre(String nombre);
    public Estudiante selectByCedula(String cedula);

    public List<Estudiante> selectByGenero(String genero);
    public List<Estudiante> selectByGenero2(String genero);
    public List<Estudiante> selectByApellido(String apellido);
    public List<Estudiante> selectByRangoFechas(LocalDate fechaInicio, LocalDate fechaFin);
    public Long seleccionarContar();

    public List<Estudiante> selectAllNative();

    public List<Estudiante> selectAllCriteria();
    public List<Estudiante> selectByNombreCriteria(String nombre);
    public List<Estudiante> selectDynamicCriteria(String nombre, String apellido);

}
