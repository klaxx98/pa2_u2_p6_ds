package ec.edu.uce.infrastructure.repository;

import ec.edu.uce.domain.model.Cliente;
import ec.edu.uce.domain.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class ClienteRepositoryImpl implements ClienteRepository {

    @Inject
    EntityManager em;

    @Override
    public void create(Cliente cliente) {
        this.em.persist(cliente);
        
    }

}
