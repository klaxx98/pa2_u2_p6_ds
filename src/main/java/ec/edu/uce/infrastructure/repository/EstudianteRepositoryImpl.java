package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class EstudianteRepositoryImpl implements EstudianteRepository {

    // Principal gestor de persistencia,
    // se encarga de realizar las operaciones de persistencia
    @Inject
    private EntityManager em;

    @Override
    public void create(Estudiante estudiante) {
        this.em.persist(estudiante);
        
    }

    @Override
    public Estudiante selectById(Integer id) {
        return this.em.find(Estudiante.class, id);
    
    }

    @Override
    public void update(Estudiante estudiante) {
        this.em.merge(estudiante);
    
    }

    @Override
    public void deleteById(Integer id) {
        this.em.remove(this.selectById(id));
    
    }

}
