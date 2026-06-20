package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Materia;

public interface MateriaRepository {

    public void create(Materia materia);
    public Materia findByIdMateria(Integer id);
    
}
