package ec.edu.uce.domain.repository;

import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.domain.model.Profesor;

public interface ProfesorRepository {

    //CRUD
    public void create(Profesor profesor);
    public Profesor selectById(Integer id);
    public void update(Profesor profesor);
    public void deleteById(Integer id);

    public List<Profesor> selectAll();
    public List<Profesor> selectByNombre(String nombre);
    public Profesor selectByCedula(String cedula);
    public Profesor selectByEspecialidad(String especialidad);

    public List<Profesor> selectByGenero(String genero);
    public List<Profesor> selectByApellido(String apellido);
    public List<Profesor> selectByRangoFechas(LocalDate fechaInicio, LocalDate fechaFin);
    public List<Profesor> selectByFacultad(String facultad);
    public List<Profesor> selectByEspecialidadNamed(String especialidad);
    public Long seleccionarContar();

    public List<Profesor> selectAllNative();
    public List<Profesor> selectByApellidoNative(String apellido);
    public List<Profesor> selectByFacultadNative(String facultad);
    public List<Profesor> selectByEspecialidadNative(String especialidad);

    public List<Profesor> selectAllCriteria();
    public List<Profesor> selectByNombreCriteria(String nombre);
    public List<Profesor> selectByFacultadCriteria(String facultad);
    public List<Profesor> selectByEspecialidadCriteria(String especialidad);
    public List<Profesor> selectDynamicCriteria(String nombre, String apellido);

}
