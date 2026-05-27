package ec.edu.uce.domain.repository;

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

}
