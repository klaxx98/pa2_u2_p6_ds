package ec.edu.uce.application.service;

import java.time.LocalDate;
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

    public List<Estudiante> buscarPorGenero(String genero) {
        return this.estudianteRepository.selectByGenero(genero);
    
    }

    public List<Estudiante> buscarPorGenero2(String genero) {
        return this.estudianteRepository.selectByGenero2(genero);

    }

    public List<Estudiante> buscarPorApellido(String apellido) {
        return this.estudianteRepository.selectByApellido(apellido);

    }

    public List<Estudiante> buscarPorRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return this.estudianteRepository.selectByRangoFechas(fechaInicio, fechaFin);

    }

    public Long seleccionarContar() {
        return this.estudianteRepository.seleccionarContar();

    }

    public List<Estudiante> listarTodosNative() {
        return this.estudianteRepository.selectAllNative();
        
    }

    public List<Estudiante> listarTodosCriteria() {
        return this.estudianteRepository.selectAllCriteria();

    }

    public List<Estudiante> buscarPorNombreCriteria(String nombre) {
        return this.estudianteRepository.selectByNombreCriteria(nombre);

    }

    public List<Estudiante> buscarDynamicCriteria(String nombre, String apellido) {
        return this.estudianteRepository.selectDynamicCriteria(nombre, apellido);

    }

}
