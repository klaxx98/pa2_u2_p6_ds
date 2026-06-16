package ec.edu.uce.application.service;

import java.util.List;

import ec.edu.uce.domain.model.Alcalde;
import ec.edu.uce.domain.model.Ciudad;
import ec.edu.uce.domain.repository.AlcaldeRepository;
import ec.edu.uce.domain.repository.CiudadRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AlcaldeService {

    @Inject
    private AlcaldeRepository alcaldeRepository;

    private CiudadRepository ciudadRepository;

    public void crearAlcalde(Alcalde alcalde) {
        this.alcaldeRepository.create(alcalde);

    }

    // CREAR CIUDAD, ALCALDE Y RELACION ALCALDE-CIUDAD
    public void crearAlcaldeCiudad(Alcalde alcalde, Ciudad ciudad) {
        this.ciudadRepository.create(ciudad);
        alcalde.setCiudad(ciudad);
        this.alcaldeRepository.create(alcalde);

    }

    public List<Alcalde> buscarPorNombre(String nombre) {
        return this.alcaldeRepository.findByNombre(nombre);

    }

}
