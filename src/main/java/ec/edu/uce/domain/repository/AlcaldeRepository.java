package ec.edu.uce.domain.repository;

import java.util.List;

import ec.edu.uce.domain.model.Alcalde;

public interface AlcaldeRepository {

    public void create(Alcalde alcalde);
    public List<Alcalde> findByNombre(String nombre);

}
