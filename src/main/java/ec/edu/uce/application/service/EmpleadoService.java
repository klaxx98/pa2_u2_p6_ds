package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Empleado;
import ec.edu.uce.domain.repository.EmpleadoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class EmpleadoService {

    @Inject
    private EmpleadoRepository empleadoRepository;

    public void guardar(Empleado empleado) {
        this.empleadoRepository.create(empleado);
        
    }

}
