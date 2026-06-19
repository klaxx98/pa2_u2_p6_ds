package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Director;
import ec.edu.uce.domain.repository.DirectorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class DirectorService {

    @Inject
    private DirectorRepository directorRepository;

    public void crearDirector(Director director) {
        this.directorRepository.create(director);
        
    }

}
