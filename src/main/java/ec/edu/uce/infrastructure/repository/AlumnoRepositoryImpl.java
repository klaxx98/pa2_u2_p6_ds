package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Alumno;
import ec.edu.uce.domain.repository.AlumnoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class AlumnoRepositoryImpl implements AlumnoRepository {

    @Inject
    EntityManager em;

    @Override
    public void create(Alumno alumno) {
        this.em.persist(alumno);

    }

}
