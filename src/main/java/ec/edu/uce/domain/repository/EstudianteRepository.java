package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Estudiante;

public interface EstudianteRepository {

    //CRUD
    public void create(Estudiante estudiante);
    public Estudiante selectById(Integer id);
    public void update(Estudiante estudiante);
    public void deleteById(Integer id);

}
