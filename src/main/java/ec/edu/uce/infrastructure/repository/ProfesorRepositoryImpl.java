package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Profesor;
import ec.edu.uce.domain.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class ProfesorRepositoryImpl implements ProfesorRepository {

    @Inject
    private EntityManager em;

    @Override
    public void create(Profesor profesor) {
        this.em.persist(profesor);

    }

    @Override
    public Profesor selectById(Integer id) {
        return this.em.find(Profesor.class, id);
    
    }

    @Override
    public void update(Profesor profesor) {
        this.em.merge(profesor);
    
    }

    @Override
    public void deleteById(Integer id) {
        this.em.remove(this.selectById(id));
    
    }

}
