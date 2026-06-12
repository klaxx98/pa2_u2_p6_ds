package ec.edu.uce.application.service;

import java.util.List;

import ec.edu.uce.domain.model.Ciudad;
import ec.edu.uce.domain.repository.CiudadRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CiudadService {

    @Inject
    private CiudadRepository ciudadRepository;

    public void crearCiudad(Ciudad ciudad) {
        this.ciudadRepository.create(ciudad);

    }

    public List<Ciudad> buscarPorNombre(String nombre) {
        return this.ciudadRepository.findByNombre(nombre);
        
    }

}
