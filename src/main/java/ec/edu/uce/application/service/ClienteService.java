package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Cliente;
import ec.edu.uce.domain.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ClienteService {

    @Inject
    private ClienteRepository clienteRepository;

    public void crearCliente(Cliente cliente) {
        this.clienteRepository.create(cliente);
        
    }

}
