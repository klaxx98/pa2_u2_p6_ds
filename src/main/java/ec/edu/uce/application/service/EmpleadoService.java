package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Empleado;
import ec.edu.uce.domain.repository.CiudadanoRepository;
import ec.edu.uce.domain.repository.EmpleadoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class EmpleadoService {

    @Inject
    private EmpleadoRepository empleadoRepository;

    @Inject
    private CiudadanoRepository ciudadanoRepository;

    public void guardar(Empleado empleado) {
        /* Ciudadano c = new Ciudadano();
        c.setNombre("Ciudadano 1");
        c.setFechaNacimiento(LocalDateTime.now());

        this.ciudadanoRepository.create(c);
        c.setNombre("David");
        empleado.setCiudadano(c); */

        this.empleadoRepository.create(empleado);
        
    }

}
