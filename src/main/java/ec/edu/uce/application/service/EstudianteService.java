package ec.edu.uce.application.service;

import java.util.List;

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

    public List<Estudiante> listarTodos() {
        return this.estudianteRepository.selectAll();
    
    }

    public List<Estudiante> buscarPorNombre(String nombre) {
        return this.estudianteRepository.selectByNombre(nombre);
    
    }

    public Estudiante buscarPorCedula(String cedula) {
        return this.estudianteRepository.selectByCedula(cedula);
    
    }

}
