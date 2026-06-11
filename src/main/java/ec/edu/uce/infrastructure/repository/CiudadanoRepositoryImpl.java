package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.repository.CiudadanoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class CiudadanoRepositoryImpl implements CiudadanoRepository {

    @Inject
    EntityManager em;

    @Override
    public void create(Ciudadano ciudadano) {
        this.em.persist(ciudadano);
        
    }

}
