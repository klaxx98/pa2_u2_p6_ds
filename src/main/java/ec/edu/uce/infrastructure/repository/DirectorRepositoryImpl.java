package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Director;
import ec.edu.uce.domain.repository.DirectorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class DirectorRepositoryImpl implements DirectorRepository {

    @Inject
    EntityManager em;

    @Override
    public void create(Director director) {
        this.em.persist(director);    
        
    }

}
