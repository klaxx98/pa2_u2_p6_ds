package ec.edu.uce.domain.repository;

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

}
