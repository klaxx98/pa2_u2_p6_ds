package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class EstudianteService {

    @Inject
    private EstudianteRepository estudianteRepository;

    public void guardar(Estudiante estudiante) {
        this.estudianteRepository.create(estudiante);
        
    }

    public Estudiante buscarPorId(Integer id) {
        return this.estudianteRepository.selectById(id);
    
    }

    public void actualizar(Estudiante estudiante) {
        this.estudianteRepository.update(estudiante);
    
    }

    public void eliminarPorId(Integer id) {
        this.estudianteRepository.deleteById(id);
    
    }

}
