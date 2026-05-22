package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Profesor;

public interface ProfesorRepository {

    //CRUD
    public void create(Profesor profesor);
    public Profesor selectById(Integer id);
    public void update(Profesor profesor);
    public void deleteById(Integer id);

}
