package ec.edu.uce.domain.repository;

import java.util.List;

import ec.edu.uce.domain.model.Ciudad;

public interface CiudadRepository {

    public void create(Ciudad ciudad);
    public List<Ciudad> findByNombre(String nombre);

}
