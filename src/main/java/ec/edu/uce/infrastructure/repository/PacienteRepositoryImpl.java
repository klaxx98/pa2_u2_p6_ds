package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Paciente;
import ec.edu.uce.domain.repository.PacienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class PacienteRepositoryImpl implements PacienteRepository {

    @Inject
    EntityManager em;

    @Override
    public void create(Paciente paciente) {
        this.em.persist(paciente);

    }

    @Override
    public Paciente findById(Integer id) {
        return this.em.find(Paciente.class, id);
        
    }

}
