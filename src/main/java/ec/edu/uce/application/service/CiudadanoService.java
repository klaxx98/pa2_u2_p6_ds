package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.repository.CiudadanoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CiudadanoService {

    @Inject
    private CiudadanoRepository ciudadanoRepository;

    public void guardar(Ciudadano ciudadano) {
        this.ciudadanoRepository.create(ciudadano);
        
    }

}
