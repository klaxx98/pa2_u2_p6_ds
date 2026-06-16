package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Empleado;
import ec.edu.uce.domain.repository.EmpleadoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class EmpleadoRepositoryImpl implements EmpleadoRepository {

    @Inject
    EntityManager em;

    @Override
    public void create(Empleado empleado) {
        this.em.persist(empleado);

    }

}
