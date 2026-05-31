package ec.edu.uce.application.service;

import java.time.LocalDate;
import java.util.List;

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

    public List<Profesor> listarTodos() {
        return this.profesorRepository.selectAll();
    
    }

    public List<Profesor> buscarPorNombre(String nombre) {
        return this.profesorRepository.selectByNombre(nombre);
    
    }

    public Profesor buscarPorCedula(String cedula) {
        return this.profesorRepository.selectByCedula(cedula);
    
    }

    public Profesor buscarPorEspecialidad(String especialidad) {
        return this.profesorRepository.selectByEspecialidad(especialidad);
    
    }

    public List<Profesor> buscarPorGenero(String genero) {
        return this.profesorRepository.selectByGenero(genero);
    
    }

    public List<Profesor> buscarPorApellido(String apellido) {
        return this.profesorRepository.selectByApellido(apellido);
    
    }

    public List<Profesor> buscarPorRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return this.profesorRepository.selectByRangoFechas(fechaInicio, fechaFin);
    
    }

    public List<Profesor> buscarPorFacultad(String facultad) {
        return this.profesorRepository.selectByFacultad(facultad);
    
    }

    public List<Profesor> buscarPorEspecialidadNamed(String especialidad) {
        return this.profesorRepository.selectByEspecialidadNamed(especialidad);
    
    }

    public Long seleccionarContar() {
        return this.profesorRepository.seleccionarContar();
    
    }

}
