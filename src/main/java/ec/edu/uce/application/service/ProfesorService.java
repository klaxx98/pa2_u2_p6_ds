package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Profesor;
import ec.edu.uce.domain.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ProfesorService {

    @Inject
    private ProfesorRepository profesorRepository;

    public void guardar(Profesor profesor) {
        this.profesorRepository.create(profesor);
        
    }

    public Profesor buscarPorId(Integer id) {
        return this.profesorRepository.selectById(id);
    
    }

    public void actualizar(Profesor profesor) {
        this.profesorRepository.update(profesor);
    
    }

    public void eliminarPorId(Integer id) {
        this.profesorRepository.deleteById(id);
    
    }

}
