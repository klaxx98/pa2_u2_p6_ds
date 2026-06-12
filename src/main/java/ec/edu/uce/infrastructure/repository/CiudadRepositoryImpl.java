package ec.edu.uce.infrastructure.repository;

import java.util.List;

import ec.edu.uce.domain.model.Ciudad;
import ec.edu.uce.domain.repository.CiudadRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@ApplicationScoped
public class CiudadRepositoryImpl implements CiudadRepository {

    @Inject
    EntityManager em;

    @Override
    public void create(Ciudad ciudad) {
        this.em.persist(ciudad);

    }

    @Override
    public List<Ciudad> findByNombre(String nombre) {
        TypedQuery<Ciudad> myQuery = this.em.createQuery("SELECT c FROM Ciudad c WHERE c.nombre = :nombre",Ciudad.class);
        myQuery.setParameter("nombre", nombre);
        return myQuery.getResultList();
        
    }

}
